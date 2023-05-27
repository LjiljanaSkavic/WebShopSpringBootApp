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
    @GetMapping("/filter-by-category/{id}")
    List<Product> getAllByCategory(@PathVariable Integer id) {
        return productService.getByCategoryId(id);
    }

    @CrossOrigin
    @GetMapping("/search-by-query/{query}")
    List<Product> getByQuery(@PathVariable String query) {
        return productService.getByProductTitle(query);
    }

    @CrossOrigin
    @GetMapping("/filter-by-category/{id}/search-by-query/{query}")
    List<Product> getByQuery(@PathVariable Integer id, @PathVariable String query) {
        return productService.getByCategoryIdAndProductTitle(id, query);
    }
}
