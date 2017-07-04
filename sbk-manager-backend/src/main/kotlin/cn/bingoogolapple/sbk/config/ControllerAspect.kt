package cn.bingoogolapple.sbk.config

import cn.bingoogolapple.sbk.exception.SbkException
import com.google.common.base.Strings
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*
import java.util.stream.Collectors

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 下午4:25
 * 描述:
 */
@Aspect
@Component
class ControllerAspect {
    private val LOGGER = LoggerFactory.getLogger(ControllerAspect::class.java)

    @Pointcut("execution(* (@org.springframework.web.bind.annotation.RestController *).*(..))")
    fun controller() {
    }

    @Before("controller()")
    fun doBefore(joinPoint: JoinPoint) {
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes
        val request = attributes.request
        LOGGER.debug("Before url={} method={} ip={} class_method={}", request.requestURL, request.method, request.remoteAddr, joinPoint.signature.declaringTypeName + "." + joinPoint.signature.name)

        val args = joinPoint.args
        if (args != null && args.size > 0) {
            valid(args)
        }
    }

    /**
     * 验证请求参数是否有效
     */
    private fun valid(args: Array<Any>) {
        val errorMsg = Arrays.stream(args)
                .filter { o -> o is Errors }
                .map { o -> o as Errors }
                .flatMap { errors -> errors.allErrors.stream() }
                .map { error -> error.defaultMessage }
                .collect(Collectors.joining(","))

        if (!Strings.isNullOrEmpty(errorMsg)) {
            throw SbkException(errorMsg)
        }
    }

    @After("controller()")
    fun doAfter() {
        LOGGER.debug("After")
    }

    @AfterReturning(returning = "any", pointcut = "controller()")
    fun doAfterReturning(any: Any) {
        LOGGER.debug("After")
    }
}