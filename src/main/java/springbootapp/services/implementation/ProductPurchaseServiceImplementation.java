package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.ProductPurchase;
import springbootapp.models.entities.ProductPurchaseEntity;
import springbootapp.repositories.ProductPurchaseEntityRepository;
import springbootapp.services.ProductPurchaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductPurchaseServiceImplementation extends CrudJpaService<ProductPurchaseEntity, Integer> implements ProductPurchaseService {
    ProductPurchaseEntityRepository repository;
    ModelMapper modelMapper;

    public ProductPurchaseServiceImplementation(ProductPurchaseEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, ProductPurchaseEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductPurchase> getByCustomerId(Integer id) {
        return this.repository.getByCustomerId(id).stream().map(e -> modelMapper.map(e, ProductPurchase.class)).collect(Collectors.toList());
    }

    @Override
    public void markAsDeletedById(Integer id) {
        this.repository.markAsDeletedById(id);
    }
}
