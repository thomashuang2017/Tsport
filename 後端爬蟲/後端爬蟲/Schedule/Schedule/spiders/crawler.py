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
from Schedule.items import ScheduleItem

class ScheduleCrawler(CrawlSpider):
    name ='Schedule'
    start_urls = ["http://zxc22.idv.tw/sche/main.asp?mmm=7&place=&team="]
    def start_requests(self):
        name_list = [7,8,9,10]
        for i in name_list:
            varitem = ScheduleItem()
            url = "http://zxc22.idv.tw/sche/main.asp?mmm="+str(i)+"&place=&team="
            varitem = str(i)
            yield Request(url,meta={'item':varitem},callback=self.parse_date)
    def parse_date(self,response):
        soup = BeautifulSoup(response.body)
        itemResult=[]
        month = response.meta['item']
        data1 = soup.findAll("td", {"bgcolor": "white"})
        weekday = 0
        for num in data1:
            answer = num.get_text().strip()
            #print answer
            weekday +=1
            d = str('2017-')+str(month)+str('-')+str(weekday)
            #print d
            item = ScheduleItem()
            item['date'] = d
            item['schedule'] = answer
            itemResult.append(item)
        return itemResult
        #length = len(articles)
        #print str(articles).decode('string_escape')
        #print "".join(articles[0:length])
        # for news in soup.select('tr'):
        # item = ScheduleItem()
        # print news.select('td')[0].text
        # item['schedule'] = news.select('td')[0].text
        # itemResult.append(item)
        # return itemResult
