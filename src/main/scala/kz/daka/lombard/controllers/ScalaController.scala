package kz.daka.lombard.controllers

import kz.daka.lombard.boot.SampleController
import kz.daka.lombard.entities.phone.{Cell, Phone}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

object ScalaController extends App {

  SpringApplication.run(classOf[AnotherController])

}
