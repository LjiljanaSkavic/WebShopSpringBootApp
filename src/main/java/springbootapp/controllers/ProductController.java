package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.ProductRequest;
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
    public Product findById(@PathVariable Integer id) throws NotFoundException {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product insert(ProductRequest productRequest) throws NotFoundException {
        return productService.insert(productRequest);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody ProductRequest productRequest) throws NotFoundException {
        return productService.update(id, productRequest);
    }
}
