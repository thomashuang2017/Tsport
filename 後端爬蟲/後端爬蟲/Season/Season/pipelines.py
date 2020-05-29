# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import MySQLdb

class SeasonPipeline(object):
    def __init__(self):
        self.conn = MySQLdb.connect(user='thomas', passwd='th850413', host='127.0.0.1',db = 'baseball', charset='utf8')

    def process_item(self, item, spider):

        #RKS	TEAM	G	W-T-L	PCT	GB	E	Lamigo	統一7-ELEVEn	富邦	中信兄弟	HOME	AWAY	STRK	L10
        cursor = self.conn.cursor()
        #sql1 = 'create table if not exists`why`(date varchar(100) , schedule varchar(100))'
        sql1 = 'create table if not exists`Season`( RKS	text,TEAM text,G	text,WTL text,PCT text,GB text,' \
               'Lamigo text,ELEVEn text,Fubon text,brother text,HOME text,	AWAY text,STRK text,L10 text)'
        #sql = 'insert into `why`(date,schedule) values (%s,%s)'
        sql = 'insert into `Season`(RKS,TEAM,G,WTL,PCT,GB,Lamigo,ELEVEn,Fubon,brother,HOME,AWAY,STRK,L10)' \
              ' values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)'

        try:
            cursor.execute(sql1)
            #cursor.execute(sql, (item['date'], item['schedule']))
            cursor.execute(sql,(item['RKS'],item['TEAM'],item['G'],item['WTL'],item['PCT'],item['GB']
            ,item['Lamigo'],item['ELEVEn'],item['Fubon'],item['brother'],item['HOME'],item['AWAY'],item['STRK'],item['L10']))
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self):
        self.conn.close()