package xyz.wcx412.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能描述：登录拦截器，放行指定路劲的资源
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 功能描述：跨域配置
     *
     * @return 跨域过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("*");
        // 4）允许的头信息
        config.addAllowedHeader("*");
        //5,有效时长
        // config.setMaxAge(3600L);
        //2.添加映射路径，我们拦截一切请求
        final UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }

}
