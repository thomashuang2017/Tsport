# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html


import MySQLdb

class BaseballPipeline(object):
    def __init__(self):
        self.conn = MySQLdb.connect(user='admin', passwd='th850413', host='127.0.0.1',port =3305 ,db ='baseball',charset='utf8' )

    def process_item(self, item, spider):

        cursor = self.conn.cursor()
        sql1 = 'create table if not exists`test`(pos varchar(20) , team varchar(20))'
        sql = 'insert into `test`(pos,team) values (%s,%s)'

        try:
            cursor.execute(sql1)
            cursor.execute(sql, (item['pos'], item['team']))
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self):
        self.conn.close()