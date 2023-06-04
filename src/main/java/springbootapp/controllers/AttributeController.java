package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.Attribute;
import springbootapp.models.AttributeRequest;
import springbootapp.models.AttributeValueKeys;
import springbootapp.services.AttributeService;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController extends CrudController<Integer, AttributeRequest, Attribute> {

    AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {

        super(Attribute.class, attributeService);
        this.attributeService = attributeService;
    }

    @CrossOrigin
    @GetMapping("/category/{id}")
    List<Attribute> getAttributesFromCategory(@PathVariable Integer id) {
        return attributeService.getAllByCategoryId(id);
    }

    @CrossOrigin
    @GetMapping("/of-product/{id}")
    List<AttributeValueKeys> getAllByProductId(@PathVariable Integer id) {
        return attributeService.getAllByProductId(id);
    }
}
