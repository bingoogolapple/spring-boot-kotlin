package cn.bingoogolapple.sbkgnote

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
class BackendApplication : WebMvcConfigurerAdapter() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.apply {
            addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BackendApplication::class.java, *args)
}