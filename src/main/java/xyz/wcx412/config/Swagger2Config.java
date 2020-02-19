package xyz.wcx412.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 功能描述：配置swagger信息
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * swagger2 启动后，通过createRestApi函数创建Docket的Bean，
     * apiInfo() 用来创建该Api的基本信息（这些基本信息会展现在文档页面中）。
     * select() 函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
     *
     * @return
     */
    @Bean
    public Docket createApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("xyz.wcx412.controller"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDateTime.class, Date.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("wcx毕设系统")
                .description("接口测试平台")
                .contact(new Contact("wcx", "http://www.wcx412.xyz", "xxxx@jxwxkj.com"))
                .version("v1.0")
                .build();
    }
}
