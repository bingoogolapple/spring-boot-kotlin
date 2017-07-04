package cn.bingoogolapple.sbk.controller

import cn.bingoogolapple.sbk.dto.ResultDto
import cn.bingoogolapple.sbk.model.UserModel
import cn.bingoogolapple.sbk.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 上午2:44
 * 描述:
 */
@Api(tags = arrayOf("User"), description = "用户管理")
@RestController
@RequestMapping("api/v1/manager/user")
class UserController(val userService: UserService) {

    @ApiOperation(value = "添加用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "model", value = "用户实体", required = true, paramType = "body", dataType = "UserModel")
    @PostMapping
    fun postBlog(@Valid @RequestBody model: UserModel, bindingResult: BindingResult): ResultDto<*> {
        userService.create(model)
        return ResultDto.msg("添加用户成功")
    }
}