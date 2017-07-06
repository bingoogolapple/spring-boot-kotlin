package cn.bingoogolapple.sbk.config

import cn.bingoogolapple.sbk.interceptor.AuthorizationInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/6/28 下午5:49
 * 描述:
 */
@Configuration
class WebConfig(val authorizationInterceptor: AuthorizationInterceptor) : WebMvcConfigurerAdapter() {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authorizationInterceptor)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
    }

}