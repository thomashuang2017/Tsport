
import scrapy
import requests
from urllib2 import urlopen
from bs4 import BeautifulSoup
from scrapy.spiders import CrawlSpider, Rule
from scrapy.http import FormRequest
from scrapy.http import Request
from scrapy.linkextractors import LinkExtractor
import sys
from Season.items import SeasonItem


class SeasonCrawler(CrawlSpider):
    name = 'Season'
    start_urls = ["http://www.cpbl.com.tw/standing/season.html"]
    #2
    def parse(self,response):

        All=[]

        item = SeasonItem()
        sel = response.xpath('//tr[2]//td/text()')
        item['RKS'] = sel[0].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['TEAM'] = sel[1].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['G'] = sel[3].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['WTL'] = sel[4].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['PCT'] = sel[5].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['GB'] = sel[6].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['Lamigo'] = sel[7].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['ELEVEn'] = sel[8].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['Fubon'] = sel[9].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['brother'] = sel[10].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['HOME'] = sel[11].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['AWAY'] = sel[12].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['STRK'] = sel[13].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['L10'] = sel[14].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        All.append(item)


        item = SeasonItem()
        sel = response.xpath('//tr[3]//td/text()')
        item['RKS'] = sel[0].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['TEAM'] = sel[1].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['G'] = sel[3].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['WTL'] = sel[4].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['PCT'] = sel[5].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['GB'] = sel[6].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['Lamigo'] = sel[7].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['ELEVEn'] = sel[8].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['Fubon'] = sel[9].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['brother'] = sel[10].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['HOME'] = sel[11].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['AWAY'] = sel[12].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['STRK'] = sel[13].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['L10'] = sel[14].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        All.append(item)


        item = SeasonItem()
        sel = response.xpath('//tr[4]//td/text()')
        item['RKS'] = sel[0].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['TEAM'] = sel[1].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['G'] = sel[3].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['WTL'] = sel[4].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['PCT'] = sel[5].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['GB'] = sel[6].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['Lamigo'] = sel[8].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['ELEVEn'] = sel[9].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['Fubon'] = sel[10].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['brother'] = sel[11].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['HOME'] = sel[12].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['AWAY'] = sel[13].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['STRK'] = sel[14].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['L10'] = sel[15].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        All.append(item)


        item = SeasonItem()
        sel = response.xpath('//tr[5]//td/text()')
        item['RKS'] = sel[0].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['TEAM'] = sel[1].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['G'] = sel[3].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['WTL'] = sel[4].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['PCT'] = sel[5].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['GB'] = sel[6].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(sys.stdin.encoding)
        item['Lamigo'] = sel[8].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['ELEVEn'] = sel[9].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['Fubon'] = sel[10].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['brother'] = sel[11].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['HOME'] = sel[12].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['AWAY'] = sel[13].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['STRK'] = sel[14].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        item['L10'] = sel[15].extract().lstrip().rstrip().encode(sys.stdin.encoding, "replace").decode(
            sys.stdin.encoding)
        All.append(item)
        return All




