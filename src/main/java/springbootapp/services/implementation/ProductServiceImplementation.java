package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.ProductEntity;
import springbootapp.services.ProductService;

@Service
public class ProductServiceImplementation extends CrudJpaService<ProductEntity, Integer> implements ProductService {
    public ProductServiceImplementation(JpaRepository<ProductEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, ProductEntity.class);
    }
}
