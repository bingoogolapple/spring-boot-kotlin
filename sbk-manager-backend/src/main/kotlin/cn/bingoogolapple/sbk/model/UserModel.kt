package cn.bingoogolapple.sbk.model

import cn.bingoogolapple.sbk.annotation.AllopenNoarg
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotBlank

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:26
 * 描述:
 */
@AllopenNoarg
data class UserModel(
        var id: Long,
        /**
         * 登录用户名，需要建立唯一索引
         */
        @NotBlank(message = "请设置登录账号")
        @Length(min = 1, max = 20, message = "登录账号的长度为1~20个字符")
        var username: String,
        /**
         * 登录密码，BASE64(SHA1(SHA1(password) + inDate))
         */
        var password: String,
        /**
         * 邮箱地址
         */
        @NotBlank(message = "请设置邮箱地址")
        @Email(message = "请提供有效地邮箱地址")
        var email: String
) : BaseModel()