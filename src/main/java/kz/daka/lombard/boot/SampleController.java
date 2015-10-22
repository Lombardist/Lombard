package kz.daka.lombard.boot;

import kz.daka.lombard.boot.entities.SomeObject;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class SampleController {

    @Bean
    public EmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        final TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(this.createConnection());
        return factory;
    }

    private Connector createConnection() {
        final String protocol = "org.apache.coyote.http11.Http11NioProtocol";
        final Connector connector = new Connector(protocol);

        connector.setScheme("http");
        connector.setPort(80);
        connector.setRedirectPort(443);
        return connector;
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
