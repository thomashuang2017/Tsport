import scrapy
import requests
from urllib2 import urlopen
from bs4 import BeautifulSoup
from scrapy.spiders import CrawlSpider, Rule
from scrapy.http import FormRequest
from scrapy.http import Request
from scrapy.linkextractors import LinkExtractor
from baseball.items import BaseballItem

def page_a():
    payload = {
        'stat': 'ppit',
        'year': '2006',
        'online': '1'
    }
    return requests.get("http://www.cpbl.com.tw/stats/all.html", params=payload)

class baseballCrawler(CrawlSpider):
    name = 'baseball'
    rules = [
        Rule(LinkExtractor(allow=('/stats/all.html')), callback='parse_list', follow=True)
    ]
    def start_requests(self):
        yield Request(page_a().url, callback=self.parse_list)
    def parse_list(self, response):
        domain = 'http://www.cpbl.com.tw'
        soup = BeautifulSoup(response.body)
        data = soup.findAll("td", {"align": "left"})
        for data1 in data:
            #print (domain + data1.select('a')[0]['href'])
            yield scrapy.Request(domain + data1.select('a')[0]['href'], self.parse_detail)

    def parse_detail(self, response):
        soup = BeautifulSoup(response.body)
        item = BaseballItem()
        positionlist = soup.find("table",{"class":"player_info_other"})
        position = positionlist.find("td")
        item['pos'] = position.get_text()
        print position.get_text()
        teamlist = soup.find("div",{"class":"player_info_name"})
        team = teamlist.find("span")
        item['team'] = team.get_text()
        print team.get_text()
        return item



