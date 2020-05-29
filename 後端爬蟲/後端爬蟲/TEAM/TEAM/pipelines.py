# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html


import MySQLdb

class TeamPipeline(object):
    def __init__(self):
        self.conn = MySQLdb.connect(user='thomas', passwd='th850413', host='127.0.0.1',db = 'baseball', charset='utf8')

    def process_item(self, item, spider):

        cursor = self.conn.cursor()
        #sql1 = 'create table if not exists`why`(date varchar(100) , schedule varchar(100))'
        #brother
        #sql1 = 'create table if not exists`fuban`(number text,name text,position text,UH text,HW text,birth text)'
        #sql1 = 'create table if not exists`lamigo`(number text,name text,position text,UH text,HW text,birth text)'
        sql1 = 'create table if not exists`lion`(number text,name text,position text,UH text,HW text,birth text)'
        #sql1 = 'create table if not exists`brother`(number text,name text,position text,UH text,HW text,birth text)'

        #sql = 'insert into `why`(date,schedule) values (%s,%s)'

        #sql = 'insert into `fuban`(number,name,position,UH,HW,birth) values (%s,%s,%s,%s,%s,%s)'
        #sql = 'insert into `lamigo`(number,name,position,UH,HW,birth) values (%s,%s,%s,%s,%s,%s)'
        sql = 'insert into `lion`(number,name,position,UH,HW,birth) values (%s,%s,%s,%s,%s,%s)'
        #sql = 'insert into `brother`(number,name,position,UH,HW,birth) values (%s,%s,%s,%s,%s,%s)'

        try:
            cursor.execute(sql1)
            #cursor.execute(sql, (item['date'], item['schedule']))
            cursor.execute(sql,(item['number'],item['name'],item['position'],item['UH'],item['HW'],item['birth']))
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self):
        self.conn.close()