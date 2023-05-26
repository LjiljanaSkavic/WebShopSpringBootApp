package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Product;

import java.util.List;

public interface ProductService extends CrudService<Integer> {
    List<Product> getAllByCategory(Integer id);
}
