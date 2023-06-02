package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Comment;

import java.util.List;

public interface CommentService extends CrudService<Integer> {
    List<Comment> getAllCommentsByProductId(Integer productId);

}
