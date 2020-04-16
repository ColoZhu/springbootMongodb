
-- 查看数据库
show  dbs ;

 -- 没有就创建数据库,有的话就是用数据库
use jiangjun ;

-- 插入数据后才能查看到
db.jiangjun.insert( { "name" :"将军上座"}) ;


--  删除数据库,删除当前数据库，默认test,所以先切换到需要删除的数据库再执行
db.dropDatabase() ;

cd  /usr/local/mongodb/bin

-- 后台一直运行启动mongodb(关闭shell窗口会自动关闭mongo服务),后面一串参数必须
 --dbpath 表示安装目录 ,
 -- logpath 自己创建一个日志文件
 -- 另外不是正常关闭,例如kill -9 会损坏文件,启动下面的命令会报错~解决方法是./mongod 临时启动一下,然后关闭shell窗口即可,或者 pkill mongod
 --  --auth  # 启用认证
 ./mongod --fork --auth --dbpath=/usr/local/mongodb --logpath=/usr/local/mongodb/mongo.log --logappend


-- telnet xxx:27017



-- 创建集合
db.createCollection('helloworld');
  /*创建固定集合 mycol，整个集合空间大小 6142800 KB, 文档最大个数为 10000 个。*/

db.createCollection("mycol", { capped : true, autoIndexId : true, size :
   6142800, max : 10000 } )

-- 当你插入一些文档时MongoDB会自动创建集合
db.jiangjun.insert({"name" : "自动创建了集合"});


-- CRUD
 -- 插入年龄和姓名
db.helloworld.insert( {
 "name":"hahh2",
 'age':38
})  ;

-- 查询年龄=18数据
db.helloworld.find( { 'age': 18 }) ;


