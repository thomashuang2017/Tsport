# -*- coding: big5 -*-
import scrapy
import requests

from bs4 import BeautifulSoup
from scrapy.spiders import CrawlSpider, Rule
from scrapy.selector import HtmlXPathSelector
from scrapy.http import FormRequest
from scrapy.http import Request
from scrapy.linkextractors import LinkExtractor
from sblnews.items import  SblnewsItem

class SBLCrawler(CrawlSpider):
    name = "SBL"
    def start_requests(self):
        base_url = "http://www.cpbl.com.tw"
        url = "http://sports.ettoday.net/news-list/%E7%B1%83%E7%90%83/SBL%E3%80%81WSBL/"
        pages = range(1, 2)
        for page in pages:
            url2 = url + str(page)
            yield Request(url2,callback=self.parse_title)
    def parse_title(self,response):
        domain = "http://sports.ettoday.net"
        res = BeautifulSoup(response.body)
        i = 0
        for news1 in range(10):
            news1 = res.select("h3")[i]
            i +=1
            #print(domain + news1.select("a")[0]["href"])
        #print(news1.select("a")[0].text)
        #print(domain + news1.select("a")[0]["href"])
            yield scrapy.Request(domain + news1.select("a")[0]["href"],callback=self.parse_headline)
    def parse_headline(self, response):
        newsitem = SblnewsItem()
        res = BeautifulSoup(response.body)
        date1 = res.select(".date")
        date2 = date1[0].text.replace('\n','')
        date = date2.replace('','')
        newsitem["date"] = date.strip(' ')

        """title = res.select(".title")
        newsitem["title"] = title[0].text

        content1 = res.select(".story")
        content2 = content1[0].text.replace('\n',' ')
        newsitem["content"] =content2
        #Title = title[0].text
        #time = title.select("span")
        #print(Title.strip())
        #p1 = res.select(".cont_txt_line_height")
        #print(p1[0].text)
        #p2 = p1[0].text.replace(u'\xa0', u' ')
        #newsitem["content"] = p2.replace(u'\n',u'')
        #t1 = Title.replace(u'\t', u'')
        #t2 = t1.replace(u'\n', u'')
        #newsitem["title"] = t2.replace(u'\r', u'')"""
        return newsitem
