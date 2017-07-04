package cn.bingoogolapple.sbk.config

import cn.bingoogolapple.sbk.dto.ResultDto
import cn.bingoogolapple.sbk.exception.SbkException
import org.slf4j.LoggerFactory
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 下午3:48
 * 描述:
 */
@ControllerAdvice
class ManagerControllerAdvice {
    private val LOGGER = LoggerFactory.getLogger(ManagerControllerAdvice::class.java)

    @ExceptionHandler
    @ResponseBody
    fun handleException(e: Exception): ResultDto<Any> {
        return when (e) {
            is SbkException -> {
                if (e.forbidden) {
                    // TODO 清除当前登录用户在服务端的缓存信息

                    ResultDto.forbidden(e)
                } else {
                    ResultDto.warning(e)
                }
            }
            is HttpMessageNotReadableException -> ResultDto.warning(e)
            is MethodArgumentTypeMismatchException -> ResultDto.warning(e)
            else -> {
                LOGGER.error("「系统异常」", e)
                ResultDto.error(e)
            }
        }
    }
}