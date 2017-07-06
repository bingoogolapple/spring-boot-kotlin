package cn.bingoogolapple.sbk.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.ParameterBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.schema.ModelRef
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/6/28 下午5:20
 * 描述:
 */
@Profile("!prod")
@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun testApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .host("localhost:18080")
                .globalOperationParameters(Arrays.asList(
                        ParameterBuilder()
                                .name("header1name")
                                .description("Description of header")
                                .defaultValue("header1value")
                                .modelRef(ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()
                ))
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.bingoogolapple.sbk.controller"))
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("SBK API 文档")
                .version("1.0")
                .build()
    }
}