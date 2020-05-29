# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class BallerdefenseItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    name = scrapy.Field()
    year = scrapy.Field()
    team = scrapy.Field()
    G =scrapy.Field()
    TC = scrapy.Field()
    PO =scrapy.Field()
    A = scrapy.Field()
    E = scrapy.Field()
    DP = scrapy.Field()
    TP = scrapy.Field()
    FPCT = scrapy.Field()





