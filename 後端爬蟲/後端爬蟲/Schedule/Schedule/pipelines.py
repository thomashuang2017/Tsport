# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import MySQLdb

class SchedulePipeline(object):
    def __init__(self):
        self.conn = MySQLdb.connect(user='thomas', passwd='th850413', host='127.0.0.1', db='baseball', charset='utf8')

    def process_item(self, item, spider):

        cursor = self.conn.cursor()
        #sql1 = 'create table if not exists`why`(date varchar(100) , schedule varchar(100))'
        sql1 = 'create table if not exists`schedule`(date DATE, schedule text)'
        #sql = 'insert into `why`(date,schedule) values (%s,%s)'
        sql = 'insert into `schedule`(date,schedule) values (%s,%s)'

        try:
            cursor.execute(sql1)
            #cursor.execute(sql, (item['date'], item['schedule']))
            cursor.execute(sql,(item['date'],[item['schedule']]))
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self):
        self.conn.close()