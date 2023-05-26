package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.Product;
import springbootapp.models.ProductRequest;
import springbootapp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Integer, ProductRequest, Product> {

    ProductService productService;

    public ProductController(ProductService productService) {
        super(Product.class, productService);
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping("/sort-by-category/{id}")
    List<Product> getAll(@PathVariable Integer id) {
        return productService.getAllByCategory(id);
    }
}
