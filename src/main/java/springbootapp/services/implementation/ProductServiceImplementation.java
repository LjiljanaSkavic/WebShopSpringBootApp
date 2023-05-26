package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.Product;
import springbootapp.models.entities.ProductEntity;
import springbootapp.repositories.ProductEntityRepository;
import springbootapp.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation extends CrudJpaService<ProductEntity, Integer> implements ProductService {
    ProductEntityRepository repository;
    ModelMapper modelMapper;

    public ProductServiceImplementation(ProductEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, ProductEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Product> getAllByCategory(Integer categoryId) {
        return this.repository.getAllFromCategory(categoryId).stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }
}
