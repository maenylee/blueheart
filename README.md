# blueheart
还没想好整什么，搭个架子玩哦
####新建springboot项目
####集成Mybatis plus
######导如依赖
<dependencies>
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>最新版本号</version>
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