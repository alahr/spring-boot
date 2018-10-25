#Spring boot
```
##directory说明
config:配置目录
module:功能开发
realm:数据库realm
util:工具类

##mysql、page helper
详细配置信息见application*文件中

##log日志
info、error日志分开生成日志文件，周期为30天

##redis
StringRedisTemplate, RedisTemplate

##swagger2
接口管理
访问链接为http://localhost:8080/swagger-ui.html

##JWT
json web token仅为工具类，没有和spring boot集成

##shiro
控制用户登录及角色、权限管理
```
#功能
```
##home
设置默认URL
##person
人员信息的分页查询，添加，修改和删除
##redis
JSONObject的存取

#运行环境选择
##修改属性文件
修改spring.profiles.active为dev,test,prod，就分别切换为开发、测试、生产
##spring boot启动时指定
java -jar spring-boot-1.0-SNAPSHOT.jar --spring.profile.active=test或dev或prod
```