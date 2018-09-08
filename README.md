#Spring boot
##mysql、page helper
####详细配置信息见application*文件中
##log日志
####info、error日志分开生成日志文件，周期为30天
##redis
####StringRedisTemplate, RedisTemplate

#功能
##home
####设置默认URL
##person
####人员信息的分页查询，添加，修改和删除

#运行环境选择
##修改属性文件
####修改spring.profiles.active为dev,test,prod，就分别切换为开发、测试、生产
##spring boot启动时指定
####java -jar spring-boot-1.0-SNAPSHOT.jar --spring.profile.active=test或dev或prod