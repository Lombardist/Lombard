package kz.daka.lombard.boot

import kz.daka.lombard.boot.entities.SomeObject
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GroovyController {

    @RequestMapping("/controller")
    @ResponseBody
    public String getName() {
        return "some name"
    }

    @RequestMapping("/controller/object")
    @ResponseBody
    public Object getControllerObject() {
        return new SomeObject()
    }

}
