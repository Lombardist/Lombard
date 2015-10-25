package kz.daka.lombard.beans

import kz.daka.lombard.entities.reference.address.AddressElementType
import kz.daka.lombard.entities.reference.address.AddressReference
import kz.daka.lombard.service.address.AddressReferenceService
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.support.AnnotationConfigContextLoader

/**
 * Created by root on 10/25/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@ComponentScan
class TestService {

    @Autowired
    AddressReferenceService service

    //@Test
    void test1() {
        def address = new AddressReference()
        address.parent = null
        address.elementType = AddressElementType.Country
        address.elementName = "Kazakhstan"
        def result = service.addAddressReference(address)
        assert result.id != null
    }

}
