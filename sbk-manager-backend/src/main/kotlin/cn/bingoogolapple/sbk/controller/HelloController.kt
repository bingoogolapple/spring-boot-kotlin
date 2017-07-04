package cn.bingoogolapple.sbk.controller

import cn.bingoogolapple.sbk.Test
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/6/25 下午9:06
 * 描述:
 */
@Api(tags = arrayOf("Hello"), description = "HelloWorld")
@RestController
@RequestMapping("/hello")
class HelloController {

    @ApiOperation(notes = "world notes", value = "world value")
    @GetMapping(value = "world")
    fun world() : HashMap<String, String> {
        val hashMap = HashMap<String, String>();
        hashMap.put("hello", "world");
        hashMap.put("hello1", "world111111");
        hashMap.put("helloworld", Test().test());
        return hashMap;
    }

}