# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import MySQLdb

class BalleroffensePipeline(object):
    def __init__(self):
        self.conn = MySQLdb.connect(user='thomas', passwd='th850413', host='127.0.0.1', db='baseball', charset='utf8')

    def process_item(self, item, spider):

        cursor = self.conn.cursor()
        # sql1 = 'create table if not exists`why`(date varchar(100) , schedule varchar(100))'
        #baller_offense_ brother
        #baller_offense_lion
        #baller_offense_lamigo
        #baller_offense_fuban
        sql1 = 'create table if not exists`baller_offense_brother`' \
               '(name text,' \
               'year text, team text,G text,GS text,GR text,' \
               'CG text,SHO text,NBB text,W text,L text,' \
               'SV text,BS text,HLD text,IP text,WHIP text,' \
               'ERA text,BF text,NP text,H text,HR text,' \
               'BB text,IBB text,HBP text,SO text,WP text,' \
               'BK text,R text,ER text,GO text,AO text,' \
               'GF text)'
        # sql = 'insert into `why`(date,schedule) values (%s,%s)'
        sql = 'insert into `baller_offense_brother`(name,' \
              'year,team,G,GS,GR,' \
              'CG,SHO,NBB,W,L,' \
              'SV,BS,HLD,IP,WHIP,' \
              'ERA,BF,NP,H,HR,' \
              'BB,IBB,HBP,SO,WP,' \
              'BK,R,ER,GO,AO' \
              ',GF)' \
              ' values (%s,' \
              '%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,' \
              '%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,' \
              '%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,' \
              '%s)'

        try:
            cursor.execute(sql1)
            # cursor.execute(sql, (item['date'], item['schedule']))
            cursor.execute(sql, (item['name'],
                                 item['year'], item['team'], item['G'], item['GS'], item['GR'],
                                 item['CG'], item['SHO'], item['NBB'], item['W'], item['L'],
                                 item['SV'], item['BS'], item['HLD'], item['IP'], item['WHIP'],
                                 item['ERA'], item['BF'], item['NP'], item['H'], item['HR'],
                                 item['BB'], item['IBB'], item['HBP'], item['SO'], item['WP'],
                                 item['BK'], item['R'], item['ER'], item['GO'], item['AO'], item['GF']))
            self.conn.commit()
        except Exception as e:
            print(e)
            self.conn.rollback()

        return item

    def close_spider(self):
        self.conn.close()

