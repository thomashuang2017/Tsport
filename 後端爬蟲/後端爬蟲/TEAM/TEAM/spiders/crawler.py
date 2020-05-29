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
from TEAM.items import TeamItem

class TEAMCrawler(CrawlSpider):
    name ='TEAM'
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=B04"]#fuban
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=A02"]#lamigo
    start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=L01"]#lion
    #start_urls = ["http://www.cpbl.com.tw/web/team_player.php?&team=E02"]#brother
    def parse(self,response):
        name = response.xpath('//tr//td//a/text()') #name
        other = response.xpath('//tr//td/text()') # other
        itemAll = []
        data=[]
        for i in range(len(other)):
            data.append(other[i].extract())
        i=0
        j=0
        a = len(other)
        while i<a:
            item = TeamItem()
            item['name'] = name[j].extract()
            item['number'] = other[i].extract()
            item['position'] = other[i + 1].extract()
            item['UH'] = other[i + 2].extract()
            item['HW'] = other[i + 3].extract()
            item['birth'] = other[i + 4].extract()
            itemAll.append(item)
            j+=1
            i+=5
        return itemAll






