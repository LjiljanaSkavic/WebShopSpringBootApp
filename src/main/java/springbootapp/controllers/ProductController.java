package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.SingleProduct;
import springbootapp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public SingleProduct findById(@PathVariable Integer id) throws NotFoundException {
        return productService.findById(id);
    }
}
