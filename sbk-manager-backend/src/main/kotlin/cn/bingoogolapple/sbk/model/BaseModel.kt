package cn.bingoogolapple.sbk.model

import cn.bingoogolapple.sbk.annotation.AllopenNoarg
import java.io.Serializable
import java.util.*

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:2017/7/4 下午2:59
 * 描述:
 */
@AllopenNoarg
class BaseModel : Serializable {
    /**
     * 创建人
     */
    var inUser: String? = null
    /**
     * 创建日期
     */
    var inDate: Date? = null
    /**
     * 更新人
     */
    var lastEditUser: String? = null
    /**
     * 更改日期
     */
    var lastEditDate: Date? = null
    /**
     * 是否没有被删除。默认值为 true，删除了之后只将状态置为 false, 不做物理删除
     */
    var isActive: Boolean = true
}