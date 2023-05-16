package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Attribute;
import springbootapp.models.AttributeRequest;
import springbootapp.services.AttributeService;

@RestController
@RequestMapping("/attributes")
public class AttributeController extends CrudController<Integer, AttributeRequest, Attribute> {
    
    public AttributeController(AttributeService attributeService) {
        super(Attribute.class, attributeService);
    }
}
