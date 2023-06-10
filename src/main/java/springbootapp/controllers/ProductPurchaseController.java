package springbootapp.controllers;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.ProductPurchase;
import springbootapp.models.ProductPurchaseRequest;
import springbootapp.services.ProductPurchaseService;

import java.util.List;

@RestController
@RequestMapping("/product-purchase")
public class ProductPurchaseController extends CrudController<Integer, ProductPurchaseRequest, ProductPurchase> {
    ProductPurchaseService productPurchaseService;

    public ProductPurchaseController(ProductPurchaseService productPurchaseService) {
        super(ProductPurchase.class, productPurchaseService);
        this.productPurchaseService = productPurchaseService;
    }

    @CrossOrigin
    @GetMapping("/customer/{id}")
    List<ProductPurchase> getAllByCustomerId(@PathVariable Integer id) {
        return productPurchaseService.getByCustomerId(id);
    }

    @CrossOrigin
    @Modifying
    @PutMapping("/delete/{id}")
    void markAsDeletedById(@PathVariable Integer id) {
        productPurchaseService.markAsDeletedById(id);
    }
}
