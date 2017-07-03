package cn.bingoogolapple.sbk.repository

import cn.bingoogolapple.sbk.model.UserModel
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:21
 * 描述:
 */
@Mapper
@Repository
interface UserRepository {
    fun insert(model: UserModel) : Int
}