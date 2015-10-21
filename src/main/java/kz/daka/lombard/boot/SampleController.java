package kz.daka.lombard.boot;

import kz.daka.lombard.boot.entities.SomeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/object")
    @ResponseBody
    public Object getSomeData() {
        SomeObject result = new SomeObject();
        result.setId("1");
        result.setName("Dauren Mussa");
        result.getTags().add("One Tag");
        result.getTags().add(1);
        result.getTags().add(true);
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class);
    }

}
