package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.SingleProduct;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    SingleProduct findById(Integer id) throws NotFoundException;
}
