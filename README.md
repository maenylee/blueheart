# blueheart
还没想好整什么，搭个架子玩哦  
#### 新建springboot项目  
![图片](https://github.com/maenylee/blueheart/raw/master/other/创建.png)  
![图片](https://github.com/maenylee/blueheart/raw/master/other/创建1.png)  
![图片](https://github.com/maenylee/blueheart/raw/master/other/创建2.png)  
![图片](https://github.com/maenylee/blueheart/raw/master/other/创建3.png)  
![图片](https://github.com/maenylee/blueheart/raw/master/other/创建4.png)  
![图片](https://github.com/maenylee/blueheart/raw/master/other/项目结构.png)  
#### 配置数据源  
###### 依赖  
```
<!-- Lombok：以注解的方式优化javabean代码 -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
<!-- thymeleaf模板，前端模板springboot推荐模板 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
<!-- mysql数据库连接 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>${mysql.version}</version>
</dependency>
<!-- aop：切面编程 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```
###### application.yml配置  
```
spring:
  mvc:
    view:
      suffix: .html
      prefix: /page/
  thymeleaf:
    enabled: true
    prefix: classpath:/templates/
    suffix: .html
  datasource:
    url: jdbc:mysql://172.16.0.34:3306/blueheart?useUnicode=true&characterEncoding=utf8
    #url: jdbc:postgresql://172.16.0.34:5432/postgres
    username: root
    password: xxxx
    driver-class-name: com.mysql.jdbc.Driver
```
#### 集成Mybatis plus    
###### 导如依赖  
```
<dependencies>
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>版本号(本项目采用2.x版本)</version>
  </dependency>
</dependencies>
<!-- 如果mapper.xml是放在src/main/java目录下，需配置以下-->
<build>
  <resources>
      <resource>
          <directory>src/main/java</directory>
          <filtering>false</filtering>
          <includes>
              <include>**/mapper/*.xml</include>
          </includes>
      </resource>
  </resources>
</build>
```
###### Mybatis plus配置  
```
mybatis-plus:
  # 如果是放在src/main/java目录下 classpath:/com/yourpackage/*/mapper/*Mapper.xml
  # 如果是放在resource目录 classpath:/mapper/*Mapper.xml
  mapper-locations: classpath:/mapper/*Mapper.xml
  #实体扫描，多个package用逗号或者分号分隔
  typeAliasesPackage: com.heart.blue.*.entity
  global-config:
    #主键类型  0:"数据库ID自增", 1:"用户输入ID",2:"全局唯一ID (数字类型唯一ID)", 3:"全局唯一ID UUID";
    id-type: 0
    #字段策略 0:"忽略判断",1:"非 NULL 判断"),2:"非空判断"
    field-strategy: 2
    #驼峰下划线转换
    db-column-underline: true
    #刷新mapper 调试神器
    refresh-mapper: true
    #数据库大写下划线转换
    #capital-mode: true
    #序列接口实现类配置
    #key-generator: com.baomidou.springboot.xxx
    #逻辑删除配置（下面3个配置）
    logic-delete-value: 0
    logic-not-delete-value: 1
  configuration:
    #配置返回数据库(column下划线命名&&返回java实体是驼峰命名)，自动匹配无需as（没开启这个，SQL需要写as： select user_id as userId）
    map-underscore-to-camel-case: true
    cache-enabled: false
    #配置JdbcTypeForNull, oracle数据库必须配置
    #jdbc-type-for-null: 'null'
```
##### 分页插件配置  
```
package com.heart.blue.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈mybatis plus相关配置〉
 *
 * @author Danny
 * @since 1.0.0
 */
@Configuration
@MapperScan("com.heart.blue.*.dao")
public class MybatisConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
```
