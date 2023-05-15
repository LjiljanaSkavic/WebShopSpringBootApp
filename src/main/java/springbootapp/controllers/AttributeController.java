package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Attribute;
import springbootapp.services.AttributeService;

import java.util.List;

@RestController
@RequestMapping("/attributes")
public class AttributeController {

    private final AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    List<Attribute> findAll() {
        return attributeService.findAll();
    }

    @GetMapping("/{id}")
    public Attribute findById(@PathVariable Integer id) throws NotFoundException {
        return attributeService.findById(id);
    }
}
