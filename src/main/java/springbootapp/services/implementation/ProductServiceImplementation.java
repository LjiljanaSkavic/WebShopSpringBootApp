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
    public List<Product> getAll() {
        return this.repository.getAll().stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategoryId(Integer categoryId) {
        return this.repository.getByCategoryId(categoryId).stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getBySellerId(Integer id) {
        return this.repository.getBySellerId(id).stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByProductTitle(String query) {
        return this.repository.getByProductTitle(query).stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getByCategoryIdAndProductTitle(Integer id, String query) {
        return this.repository.getByCategoryIdAndProductTitle(id, query).stream().map(e -> modelMapper.map(e, Product.class)).collect(Collectors.toList());
    }

    @Override
    public void markAsDeletedById(Integer id) {
        this.repository.markAsDeletedById(id);
    }
}
