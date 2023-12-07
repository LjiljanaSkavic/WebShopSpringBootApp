package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.Comment;
import springbootapp.models.CommentRequest;
import springbootapp.services.implementation.CommentServiceImplementation;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/comments")
public class CommentController extends CrudController<Integer, CommentRequest, Comment> {

    CommentServiceImplementation commentServiceImplementation;

    public CommentController(CommentServiceImplementation commentServiceImplementation) {
        super(Comment.class, commentServiceImplementation);
        this.commentServiceImplementation = commentServiceImplementation;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product/{id}")
    public List<Comment> getCommentsForProduct(@PathVariable Integer id) {
        return commentServiceImplementation.getAllCommentsByProductId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment insertComment(@RequestBody CommentRequest commentRequest) {
        return commentServiceImplementation.insert(commentRequest, Comment.class);
    }
}
