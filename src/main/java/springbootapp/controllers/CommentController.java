package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.Comment;
import springbootapp.models.CommentRequest;
import springbootapp.services.implementation.CommentServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController extends CrudController<Integer, CommentRequest, Comment> {

    CommentServiceImplementation commentServiceImplementation;

    public CommentController(CommentServiceImplementation commentServiceImplementation) {
        super(Comment.class, commentServiceImplementation);
        this.commentServiceImplementation = commentServiceImplementation;
    }

    @CrossOrigin
    @GetMapping("/product/{id}")
    public List<Comment> getCommentsForProduct(@PathVariable Integer id) {
        return commentServiceImplementation.getAllCommentsByProductId(id);
    }
}
