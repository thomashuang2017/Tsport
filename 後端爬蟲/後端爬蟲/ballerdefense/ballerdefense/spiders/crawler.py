import scrapy
import uniout
import requests
from urllib2 import urlopen
from bs4 import BeautifulSoup
from scrapy.spiders import CrawlSpider, Rule
from scrapy.selector import HtmlXPathSelector
from scrapy.http import FormRequest
from scrapy.http import Request
from scrapy.linkextractors import LinkExtractor
from ballerdefense.items import BallerdefenseItem
import sys
import re

class BallerdefenseCrawler(CrawlSpider):
    name ='ballerdefense'

    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=B04"]  # fuban
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=A02"]#lamigo
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=L01"]#lion
    start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=E02"]#brother

    def parse(self,response):
        domain = 'http://www.cpbl.com.tw'
        html=response.xpath('//tr//td//a/@href')
        h=0
        a = len(html)
        while h<a:
            Entrance = str(domain)+html[h].extract()
            #print Entrance
            yield scrapy.Request(Entrance,self.parse_detail)
            h+=1
    def parse_detail(self,response):
        second_len = response.xpath("//div[@class='gap_b20']/table[2]//tr")
        name = response.xpath("//div[@class='player_info_name']/text()")
        second_range=len(second_len)
        second_row=2
        sec=[]
        itemlist=[]
        data=[]
        while second_row<=second_range:
            second = response.xpath("//div[@class='gap_b20']/table[2]//tr"+str([second_row])+"//td/text()")
            if len(second) == 10:
                sec.append(second.extract())
            second_row+=1
        for i in sec:
            try:
                print i
                for j in i:
                    data.append(j)
            except:
                pass
        length = len(data)/10
        i=0
        j=0
        while(j<length):
            item = BallerdefenseItem()
            item['name']=name.extract()
            item['year']=data[i]
            item['team']=data[i+1]
            item['G'] =data[i+2]
            item['TC'] =data[i+3]
            item['PO'] =data[i+4]
            item['A'] =data[i+5]
            item['E'] =data[i+6]
            item['DP'] =data[i+7]
            item['TP'] =data[i+8]
            item['FPCT'] =data[i+9]
            i=i+10
            j=j+1
            itemlist.append(item)
        return  itemlist






