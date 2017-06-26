package cn.bingoogolapple.sbkgnote.controller

import cn.bingoogolapple.sbk.Test
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/6/25 下午9:06
 * 描述:
 */
@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping(value = "world")
    fun world() : HashMap<String, String> {
        val hashMap = HashMap<String, String>();
        hashMap.put("hello", "world");
        hashMap.put("hello1", "world1");
        hashMap.put("helloworld", Test().test());
        return hashMap;
    }

}