package cn.bingoogolapple.sbk.exception

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 下午3:51
 * 描述:
 */
data class SbkException(override val message: String, val forbidden: Boolean = false) : RuntimeException(message)