package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Product;
import springbootapp.models.SingleProduct;
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
    public SingleProduct findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), SingleProduct.class);
    }
}
