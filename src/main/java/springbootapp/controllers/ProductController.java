package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Product;
import springbootapp.models.ProductRequest;
import springbootapp.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Integer, ProductRequest, Product> {
    public ProductController(ProductService productService) {
        super(Product.class, productService);
    }
}
