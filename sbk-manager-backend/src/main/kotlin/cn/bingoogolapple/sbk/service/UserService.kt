package cn.bingoogolapple.sbk.service

import cn.bingoogolapple.sbk.mapper.UserMapper
import cn.bingoogolapple.sbk.model.UserModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:39
 * 描述:
 */
@Transactional
@Service
class UserService(val userMapper: UserMapper) {

    fun create(model: UserModel) {
        userMapper.insert(model)
    }

}