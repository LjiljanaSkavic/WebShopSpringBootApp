package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.ProductRequest;
import springbootapp.models.SingleProduct;
import springbootapp.models.entities.ProductEntity;
import springbootapp.repositories.ProductEntityRepository;
import springbootapp.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {

    private ModelMapper modelMapper;

    private final ProductEntityRepository repository;

    public ProductServiceImplementation(ProductEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(productEntity -> modelMapper.map(productEntity, Product.class)).collect(Collectors.toList());
    }

    @Override
    public Product findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), SingleProduct.class);
    }

    @Override
    public Product update(Integer id, ProductRequest productRequest) throws NotFoundException {
        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);
        productEntity.setId(id);
        productEntity = repository.saveAndFlush(productEntity);
        return findById(productEntity.getId());
    }

    @Override
    public Product insert(ProductRequest productRequest) throws NotFoundException {
        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);
        productEntity.setId(null);
        productEntity = repository.saveAndFlush(productEntity);
        return findById(productEntity.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }


}
