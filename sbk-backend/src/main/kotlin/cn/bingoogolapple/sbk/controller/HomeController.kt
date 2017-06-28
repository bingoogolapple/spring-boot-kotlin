package cn.bingoogolapple.sbk.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/6/25 下午9:06
 * 描述:
 */
@Controller
@RequestMapping("/")
class HomeController {

    @RequestMapping(value = "/")
    fun index() : ModelAndView {
        return ModelAndView("forward://index.html");
    }

    @RequestMapping(value = "/guest")
    fun guest(): String {
        return "guest"
    }

}