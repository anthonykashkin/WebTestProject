package org.protei.controller

import org.protei.domain.MyDataObject
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMethod
import java.util.Calendar
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody


@Controller
// мапим наш REST на /myservice
@RequestMapping(value = "/time")
class MainController {

    // этот метод будет принимать время методом GET и на его основе
    // отвечать клиенту
    @RequestMapping(value = "/{time}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getMyData(@PathVariable time: Long): MyDataObject {
        return MyDataObject(Calendar.getInstance(), "Это ответ метода GET!")
    }

    // этот метод будет принимать Объект MyDataObject и отдавать его клиенту
    // обычно метод PUT используют для сохранения либо для обновления объекта
    @RequestMapping(method = arrayOf(RequestMethod.PUT))
    @ResponseBody
    fun putMyData(@RequestBody md: MyDataObject): MyDataObject {
        return md
    }

    // этот метод будет методом POST отдавать объект MyDataObject
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun postMyData(): MyDataObject {
        return MyDataObject(Calendar.getInstance(), "это ответ метода POST!")
    }

    // этот метод будет принимать время методом DELETE
    // и на его основе можно удалит объект
    @RequestMapping(value = "/{time}", method = arrayOf(RequestMethod.DELETE))
    @ResponseBody
    fun deleteMyData(@PathVariable time: Long): MyDataObject {
        return MyDataObject(Calendar.getInstance(), "Это ответ метода DELETE!")
    }
}