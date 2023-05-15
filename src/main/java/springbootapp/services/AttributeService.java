package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Attribute;

import java.util.List;

public interface AttributeService {
    List<Attribute> findAll();

    Attribute findById(Integer id) throws NotFoundException;

//    List<Attribute> getAllAttributesByCategoryId(Integer id);
}
