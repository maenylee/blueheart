/**
 * FileName: MybatisConfig
 * Author:   Danny
 * Date:     2019/7/30 19:57
 * Description: mybatis plus相关配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
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
 * @create 2019/7/30
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
    /*
    * oracle数据库配置JdbcTypeForNull
    * 参考：https://gitee.com/baomidou/mybatisplus-boot-starter/issues/IHS8X
    不需要这样配置了，参考 yml:
    mybatis-plus:
      confuguration
        dbc-type-for-null: 'null'
   @Bean
   public ConfigurationCustomizer configurationCustomizer(){
       return new MybatisPlusCustomizers();
   }

   class MybatisPlusCustomizers implements ConfigurationCustomizer {

       @Override
       public void customize(org.apache.ibatis.session.Configuration configuration) {
           configuration.setJdbcTypeForNull(JdbcType.NULL);
       }
   }
   */
}