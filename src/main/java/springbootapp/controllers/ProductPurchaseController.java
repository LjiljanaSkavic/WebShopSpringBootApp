package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.ProductPurchase;
import springbootapp.services.ProductPurchaseService;

import java.util.List;

@RestController
@RequestMapping("/product-purchase")
public class ProductPurchaseController extends CrudController<Integer, ProductPurchase, ProductPurchase> {
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
}
