package kz.daka.lombard.rest.address

import kz.daka.lombard.rest.address.entities.AddressReferenceWrapper
import kz.daka.lombard.service.address.AddressReferenceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by root on 10/24/15.
 */

@RestController
@RequestMapping("/addresses")
class AddressReferenceRest {

    @Autowired
    private AddressReferenceService addressReferenceService

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    AddressReferenceWrapper getAddressReferenceById(@PathVariable("Id") Long id) {
        new AddressReferenceWrapper()
    }

    @RequestMapping(method = RequestMethod.GET)
    List<AddressReferenceWrapper> getAddressReferences(@RequestParam(value = "parentId", required = false) Long parentId) {
        addressReferenceService.getAddressReferences(parentId)
    }

    @RequestMapping(value =  "/elements/types", method = RequestMethod.GET)
    List<String> getElementTypes() {
        addressReferenceService.getAddressElementTypes()
    }

    @RequestMapping(method = RequestMethod.POST)
    AddressReferenceWrapper addAddressReference(@RequestBody AddressReferenceWrapper reference) {
        addressReferenceService.addAddressReference(reference)
    }

    @RequestMapping(value = "/path", method = RequestMethod.GET)
    String getAddressPath(@RequestParam(value = "id", required = true) Long id) {
        addressReferenceService.getAddressPath(id)
    }

}
