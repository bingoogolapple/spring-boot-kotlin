package cn.bingoogolapple.sbkgnote

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

@SpringBootApplication
class BackendApplication : SpringBootServletInitializer() {

    override fun configure(application: SpringApplicationBuilder) : SpringApplicationBuilder {
        return application.sources(BackendApplication::class.java)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(BackendApplication::class.java, *args)
}