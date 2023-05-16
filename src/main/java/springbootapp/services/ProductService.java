package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id) throws NotFoundException;

    Product update(Integer id, ProductRequest productRequest) throws NotFoundException;

    Product insert(ProductRequest productRequest) throws NotFoundException;

    void delete(Integer id);
}
