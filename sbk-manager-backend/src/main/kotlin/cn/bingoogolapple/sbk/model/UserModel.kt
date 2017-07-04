package cn.bingoogolapple.sbk.model

import cn.bingoogolapple.sbk.annotation.AllopenNoarg
import java.util.*

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:26
 * 描述:
 */
@AllopenNoarg
data class UserModel constructor(var id: Int, var username: String, var password: String, var email: String, var cellphone: String, var inUser: String, var inDate: Date, var lastEditUser: String, var lastEditDate: Date, var isActive: Boolean)