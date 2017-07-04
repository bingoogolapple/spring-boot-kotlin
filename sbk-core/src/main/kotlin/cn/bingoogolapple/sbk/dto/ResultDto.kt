package cn.bingoogolapple.sbk.dto

import java.io.Serializable
import java.util.*

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:50
 * 描述:
 */
data class ResultDto<T>(val code: Int, val message: String?, val data: T?) : Serializable {
    var errorMessage: String? = null
    var stackTrace: String? = null

    constructor(code: Int) : this(code, null, null)

    companion object {
        /**
         * 表示成功
         */
        val OK = 0
        /**
         * 表示服务器端异常错误
         */
        val ERROR = 1
        /**
         * 表示验证错误或者警告, 客户端使用黄色alert对话框展示
         */
        val WARNING = 2
        /**
         * 表示账户被禁用, 客户端使用红色alert对话框展示并跳转到登录界面
         */
        val FORBIDDEN = 3

        fun ok(message: String?, data: Any?): ResultDto<Any> {
            return ResultDto(ResultDto.OK, message, data)
        }

        fun data(data: Any): ResultDto<Any> {
            return ResultDto.ok(null, data)
        }

        fun msg(message: String?): ResultDto<Any> {
            return ResultDto.ok(message, null)
        }

        fun ok(): ResultDto<Any> {
            return ResultDto.msg(null)
        }

        fun error(e: Exception?): ResultDto<Any> {
            val resultDto = ResultDto<Any>(ResultDto.ERROR)

            if (e != null) {
                resultDto.errorMessage = "系统异常"

                val stackTraceSb = StringBuffer()
                Arrays.stream(e.stackTrace).forEach { ste -> stackTraceSb.append(ste.toString() + "\r\n") }
                resultDto.stackTrace = stackTraceSb.toString()
            }
            return resultDto
        }

        fun warning(e: Exception?): ResultDto<Any> {
            val resultDto = ResultDto<Any>(ResultDto.WARNING)
            if (e != null) {
                resultDto.errorMessage = e.message
            }
            return resultDto
        }

        fun forbidden(e: Exception?): ResultDto<Any> {
            val resultDto = ResultDto<Any>(ResultDto.FORBIDDEN)
            if (e != null) {
                resultDto.errorMessage = e.message
            }
            return resultDto
        }
    }
}