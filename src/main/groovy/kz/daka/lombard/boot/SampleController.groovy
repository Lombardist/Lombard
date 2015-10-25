package kz.daka.lombard.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan("kz.daka.lombard")
class SampleController {

    /*@Bean
    EmbeddedServletContainerFactory tomcatEmbeddedServletContainerFactory() {
        final TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint()
                securityConstraint.setUserConstraint("CONFIDENTIAL")
                SecurityCollection collection = new SecurityCollection()
                collection.addPattern("*//*")
                securityConstraint.addCollection(collection)
                context.addConstraint(securityConstraint)
            }
        }
        factory.addAdditionalTomcatConnectors(this.createConnection())
        factory
    }

    private Connector createConnection() {
        final String protocol = "org.apache.coyote.http11.Http11NioProtocol"
        final Connector connector = new Connector(protocol)

        connector.setScheme("http")
        connector.setPort(81)
        connector.setRedirectPort(443)
        return connector
    }*/

    static void main(String[] args) {
        SpringApplication.run(SampleController.class)
    }

}
