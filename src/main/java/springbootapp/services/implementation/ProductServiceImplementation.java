package springbootapp.services.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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
@Transactional
public class ProductServiceImplementation implements ProductService {

    private final ModelMapper modelMapper;

    private final ProductEntityRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

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
        entityManager.refresh(productEntity);
        return findById(productEntity.getId());
    }

    //TODO: Needs improvement, doesn't work as expected
    @Override
    public Product insert(ProductRequest productRequest) throws NotFoundException {
        System.out.println(productRequest);
        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);
        productEntity.setId(null);
        System.out.println(productEntity);
        productEntity = repository.saveAndFlush(productEntity);
        entityManager.refresh(productEntity);
        return findById(productEntity.getId());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
