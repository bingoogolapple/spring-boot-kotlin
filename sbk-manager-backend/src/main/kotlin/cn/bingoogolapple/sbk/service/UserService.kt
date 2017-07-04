package cn.bingoogolapple.sbk.service

import cn.bingoogolapple.sbk.model.UserModel
import cn.bingoogolapple.sbk.repository.UserRepository
import org.springframework.stereotype.Service

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:39
 * 描述:
 */
@Service
class UserService(val userRepository: UserRepository) {

    fun create(model: UserModel) {
        userRepository.insert(model)
    }

}