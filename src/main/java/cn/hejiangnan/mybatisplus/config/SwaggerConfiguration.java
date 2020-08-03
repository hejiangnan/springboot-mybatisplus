package cn.hejiangnan.mybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfiguration
 * @Description: Swagger配置类
 * @Author: hejiangnan
 * @Date: 2020/7/20
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				// 是否开启
				.enable(true).select()
				// 扫描的路径包
				.apis(RequestHandlerSelectors.basePackage("cn.hejiangnan.mybatisplus.controller"))
				// 指定路径处理PathSelectors.any()代表所有的路径
				.paths(PathSelectors.any()).build().pathMapping("/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 标题
				.title("springBoot-mybatisplus")
				// 描述
				//.description("Flowable 6.4.0")
				// 作者信息
				//.contact(new Contact("hejiangnan", "https://flowable.com/open-source/", "xxxxxxx@zz.com"))
				// 版本信息
				.version("1.0").build();
	}

}