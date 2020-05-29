# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class BalleroffenseItem(scrapy.Item):
    name = scrapy.Field()
    year = scrapy.Field()
    team = scrapy.Field()
    G = scrapy.Field()
    GS = scrapy.Field()
    GR = scrapy.Field()
    CG = scrapy.Field()
    SHO = scrapy.Field()
    NBB = scrapy.Field()
    W = scrapy.Field()
    L = scrapy.Field()
    SV = scrapy.Field()
    BS = scrapy.Field()
    HLD = scrapy.Field()
    IP = scrapy.Field()
    WHIP = scrapy.Field()
    ERA = scrapy.Field()
    BF = scrapy.Field()
    NP = scrapy.Field()
    H = scrapy.Field()
    HR = scrapy.Field()
    BB = scrapy.Field()
    IBB = scrapy.Field()
    HBP = scrapy.Field()
    SO = scrapy.Field()
    WP = scrapy.Field()
    BK = scrapy.Field()
    R = scrapy.Field()
    ER = scrapy.Field()
    GO = scrapy.Field()
    AO = scrapy.Field()
    GF = scrapy.Field()