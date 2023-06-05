package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.MessageEntity;
import springbootapp.repositories.ContactSupportRepository;
import springbootapp.services.ContactSupportService;

@Service
public class ContactSupportServiceImplementation extends CrudJpaService<MessageEntity, Integer> implements ContactSupportService {

    ContactSupportRepository repository;
    ModelMapper modelMapper;

    public ContactSupportServiceImplementation(ContactSupportRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, MessageEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }
}
