package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.Comment;
import springbootapp.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController extends CrudController<Integer, Comment, Comment> {

    CommentService commentService;

    public CommentController(CommentService commentService) {
        super(Comment.class, commentService);
        this.commentService = commentService;
    }

    @CrossOrigin
    @GetMapping("/product/{id}")
    public List<Comment> getCommentsForProduct(@PathVariable Integer id) {
        return commentService.getAllCommentsByProductId(id);
    }

}
