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
from balleroffense.items import BalleroffenseItem
import sys
import re

class BalleroffenseCrawler(CrawlSpider):
    name ='balleroffense'

    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=B04"]  # fuban
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=A02"]#lamigo
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=L01"]#lion
    start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=E02"]#brother

    def parse(self,response):
        domain = 'http://www.cpbl.com.tw'
        html=response.xpath('//tr//td//a/@href')
        i=0
        a = len(html)
        while i<a:
            Entrance = str(domain)+html[i].extract()
            #print Entrance
            yield scrapy.Request(Entrance,self.parse_detail)
            i+=1
    def parse_detail(self,response):
        first_len = response.xpath("//div[@class='gap_b20']/table[1]//tr")
        second_len = response.xpath("//div[@class='gap_b20']/table[2]//tr")
        name = response.xpath("//div[@class='player_info_name']/text()")
        first_range=len(first_len)
        second_range=len(second_len)
        first_row=2
        second_row=2
        itemlist=[]
        while first_row<=first_range:
            first = response.xpath("//div[@class='gap_b20']/table[1]//tr"+str([first_row])+"//td/text()")
            item= BalleroffenseItem()
            if len(first)==31:
                    item['name']=name.extract()
                    item['year']=first[0].extract()
                    item['team']=first[1].extract()
                    item['G'] = first[2].extract()
                    item['GS'] =first[3].extract()
                    item['GR'] =first[4].extract()
                    item['CG'] =first[5].extract()
                    item['SHO'] =first[6].extract()
                    item['NBB'] =first[7].extract()
                    item['W'] =first[8].extract()
                    item['L'] =first[9].extract()
                    item['SV'] =first[10].extract()
                    item['BS'] =first[11].extract()
                    item['HLD'] =first[12].extract()
                    item['IP'] =first[13].extract()
                    item['WHIP'] =first[14].extract()
                    item['ERA'] =first[15].extract()
                    item['BF'] =first[16].extract()
                    item['NP'] =first[17].extract()
                    item['H'] =first[18].extract()
                    item['HR'] =first[19].extract()
                    item['BB'] =first[20].extract()
                    item['IBB'] =first[21].extract()
                    item['HBP'] =first[22].extract()
                    item['SO'] =first[23].extract()
                    item['WP'] =first[24].extract()
                    item['BK'] =first[25].extract()
                    item['R'] =first[26].extract()
                    item['ER'] =first[27].extract()
                    item['GO'] =first[28].extract()
                    item['AO'] =first[29].extract()
                    item['GF'] =first[30].extract()
                    itemlist.append(item)
            first_row+=1
        return itemlist
        while second_row<=second_range:
            second = response.xpath("//div[@class='gap_b20']/table[2]//tr"+str([second_row])+"//td/text()")
            sec.append(second.extract())
            second_row+=1
        for i in sec:
            try:
                print i
            except:
                pass