package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.ProductPurchase;

import java.util.List;

public interface ProductPurchaseService extends CrudService<Integer> {

    List<ProductPurchase> getByCustomerId(Integer id);

    void markAsDeletedById(Integer id);
}
