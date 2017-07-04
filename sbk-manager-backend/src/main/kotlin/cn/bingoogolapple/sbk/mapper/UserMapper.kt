package cn.bingoogolapple.sbk.mapper

import cn.bingoogolapple.sbk.model.UserModel

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:21
 * 描述:
 */
interface UserMapper {
    fun insert(model: UserModel) : Int
}