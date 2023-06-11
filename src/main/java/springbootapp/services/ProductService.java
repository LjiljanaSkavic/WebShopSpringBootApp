package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Product;

import java.util.List;

public interface ProductService extends CrudService<Integer> {
    List<Product> getAll();

    List<Product> getByCategoryId(Integer id);

    List<Product> getBySellerId(Integer id);

    List<Product> getByProductTitle(String query);

    List<Product> getByCategoryIdAndProductTitle(Integer id, String query);

    void markAsDeletedById(Integer id);
}
