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
from title.items import  TitleItem

class titleCrawler(CrawlSpider):
    name = "title"
    def start_requests(self):
        base_url = "http://www.cpbl.com.tw"
        url = "http://www.cpbl.com.tw/news/lists/news_lits.html?year=0&month=0&search=&tag=&per_page="
        pages = range(0, 10)
        for page in pages:
            url2 = url + str(page)
            yield Request(url2,callback=self.parse_title)
    def parse_title(self,response):
        domain = "http://www.cpbl.com.tw"
        res = BeautifulSoup(response.body)
        for news1 in res.select(".news_head"):
            #print(news1.select("a")[0].text)
            #print(domain + news1.select("a")[0]["href"])
            yield scrapy.Request(domain + news1.select("a")[0]["href"],callback=self.parse_headline)
        for news in res.select(".news_row_cont"):
            #print(news.select("a")[0].text)
            yield scrapy.Request(domain + news.select("a")[0]["href"], self.parse_content)
    def parse_headline(self, response):
        newsitem = TitleItem()
        res = BeautifulSoup(response.body)
        title = res.select(".news_title")
        Time = res.select(".news_title")[0]
        time = Time.select("span")
        date = time[0].text
        Title = title[0].text
        newsitem["date"] = date
        p1 = res.select(".cont_txt_line_height")
        p2 = p1[0].text.replace(u'\xa0', u' ')
        newsitem["content"] = p2
        t1 = Title.replace(u'\t', u'')
        t2 = t1.replace(u'\n', u'')
        t3 = t2.replace(u'\r', u'')
        newsitem["title"] =t3.replace(date,'')
        return newsitem
    def parse_content(self, response):
        newsitem2 = TitleItem()
        res = BeautifulSoup(response.body)
        title = res.select(".news_title")
        Title = title[0].text
        Time = res.select(".news_title")[0]
        time = Time.select("span")
        date = time[0].text
        newsitem2["date"] = date
        post = res.select(".cont_txt_line_height")
        string = post[0].text.replace(u'\xa0', u' ')
        newsitem2["content"] = string
        t1 = Title.replace(u'\t',u'')
        t2 = t1.replace(u'\n',u'')
        t3 = t2.replace(u'\r', u'')
        newsitem2["title"] = t3.replace(date,'')
        return newsitem2