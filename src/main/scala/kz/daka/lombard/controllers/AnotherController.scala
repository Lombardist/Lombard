package kz.daka.lombard.controllers

import kz.daka.lombard.entities.phone.{Cell, Phone}
import org.springframework.context.annotation.{ComponentScan, Configuration}
import org.springframework.web.bind.annotation.{ResponseBody, RestController, RequestMethod, RequestMapping}

@RestController
@Configuration
@ComponentScan
class AnotherController {

  @RequestMapping(Array("/scalaController"))
  @ResponseBody
  def name: String = {
    "Some name"
  }

  @RequestMapping(Array("/scalaController/phone"))
  @ResponseBody
  def getPhone: Phone = {
    Phone("701", "5137812", Cell)
  }

}
