package xyz.wcx412.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 功能描述：MyBatis Plus 配置
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "xyz.wcx412.mapper")
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
