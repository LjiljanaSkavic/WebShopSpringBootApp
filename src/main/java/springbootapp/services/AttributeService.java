package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Attribute;
import springbootapp.models.AttributeValueKeys;

import java.util.List;

public interface AttributeService extends CrudService<Integer> {

    List<Attribute> getAllByCategoryId(Integer CategoryId);

    List<AttributeValueKeys> getAllByProductId(Integer productId);
}
