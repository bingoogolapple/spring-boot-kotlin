package cn.bingoogolapple.sbk.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/6 下午2:28
 * 描述:
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.bingoogolapple.sbk.mapper")
class DatabaseConfig {
}