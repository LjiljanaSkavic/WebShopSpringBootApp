package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Comment;

import java.util.List;

public interface CommentService extends CrudService<Integer> {
    public List<Comment> getAllCommentsByProductId(Integer productId);

}
