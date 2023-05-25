package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.Comment;
import springbootapp.models.entities.CommentEntity;
import springbootapp.repositories.CommentEntityRepository;
import springbootapp.services.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImplementation extends CrudJpaService<CommentEntity, Integer> implements CommentService {
    CommentEntityRepository repository;
    ModelMapper modelMapper;

    public CommentServiceImplementation(CommentEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CommentEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Comment> getAllCommentsByProductId(Integer productId) {
        return this.repository.getAllByProductId(productId).stream().map(e -> this.modelMapper.map(e, Comment.class)).collect(Collectors.toList());
    }
}
