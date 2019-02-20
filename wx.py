# !/usr/bin/python
# -*- coding: UTF-8 -*-
import xlrd
import pymysql
import re
db = pymysql.connect("localhost","root","lifeng","text")
cursor = db.cursor()
# cursor.execute("alter table tb1 add shijianc int")
# db.commit()
cursor.execute("select * from tb1")
data = cursor.fetchone()
list1 = []
list2 = []
while data != None :
    j=data[1]
    result=re.sub(r"\D","",j)
    list1.append(j)
    list2.append(result)     
    data = cursor.fetchone() 
print(list1)
print(list2)
for i in range(len(list1)):
    j=i+1
    if len(list2[i])==0:
        cmd = "update tb1 set shijianb=null where name="+"'"+list1[i]+"'"
    else:
        cmd = "update tb1 set shijianb="+"'"+list2[i]+"'"+" where name="+"'"+list1[i]+"'"
    cursor.execute(cmd)
    db.commit()
    print('OK')
db.close();
