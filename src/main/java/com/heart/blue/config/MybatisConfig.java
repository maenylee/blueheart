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

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 〈一句话功能简述〉<br> 
 * 〈mybatis plus相关配置〉
 *
 * @author Danny
 * @create 2019/7/30
 * @since 1.0.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.heart.blue.*.dao.mapper*")
public class MybatisConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

}