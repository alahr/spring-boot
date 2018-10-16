package com.alahr.springboot.config;

import com.alahr.springboot.util.RSAUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@ComponentScan(value = "com.alahr.springboot.module")
@Configuration
public class DatabaseConfig {
    private Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public DataSource initDataSource(){
        String profilesActive = env.getProperty("spring.profiles.active");
        logger.warn("spring.profiles.active={}", profilesActive);

        logger.info("decrypt password by using private key");
        String privateKey = env.getProperty("rsa.private.key");
        String data = env.getProperty("spring.datasource.password");
        String password = null;
        try{
            password = RSAUtil.privateDecrypt(data, RSAUtil.getPrivateKey(privateKey));
        }
        catch (Exception e){
            logger.error("decrypt password failed...", e);
        }
        if(null != password){
            logger.info("init data source");
            return DataSourceBuilder
                    .create()
                    .type(HikariDataSource.class)
                    .url(env.getProperty("spring.datasource.url"))
                    .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                    .username(env.getProperty("spring.datasource.username"))
                    .password(password)
                    .build();
        }
        return null;
    }
}
