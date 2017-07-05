package cn.bingoogolapple.sbk

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

/**
 * 注解 @SpringBootApplication 中的 @ComponentScan 注解配置后扫描的是带有 @SpringBootApplication 注解的类所在的包及其子包中的类
 * 继承 SpringBootServletInitializer 是为了能够部署到独立的 Tomcat 中
 */
@SpringBootApplication
class ManagerApplication : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ManagerApplication::class.java)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ManagerApplication::class.java, *args)
}