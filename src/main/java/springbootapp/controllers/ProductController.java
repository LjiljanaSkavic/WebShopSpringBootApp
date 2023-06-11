package springbootapp.controllers;

import org.springframework.data.jpa.repository.Modifying;
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
    @GetMapping("/all")
    List<Product> getAll() {
        return productService.getAll();
    }

    @CrossOrigin
    @GetMapping("/filter-by-category/{id}")
    List<Product> getAllByCategory(@PathVariable Integer id) {
        return productService.getByCategoryId(id);
    }

    @CrossOrigin
    @GetMapping("/filter-by-category/{id}/search-by-query/{query}")
    List<Product> getByQuery(@PathVariable Integer id, @PathVariable String query) {
        return productService.getByCategoryIdAndProductTitle(id, query);
    }

    @CrossOrigin
    @GetMapping("/search-by-query/{query}")
    List<Product> getByQuery(@PathVariable String query) {
        return productService.getByProductTitle(query);
    }

    @CrossOrigin
    @GetMapping("/seller/{id}")
    List<Product> getBySellerId(@PathVariable Integer id) {
        return productService.getBySellerId(id);
    }

    @CrossOrigin
    @Modifying
    @PutMapping("/delete/{id}")
    void markAsDeletedById(@PathVariable Integer id) {
        productService.markAsDeletedById(id);
    }
}
