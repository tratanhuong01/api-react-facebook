package com.facebook.facebook.feel_comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/feelComments")

public class FeelCommentController {

    //
    @Autowired
    FeelCommentService feelCommentService;
    //

    @PostMapping("")
    public FeelComment addFeelComment(@RequestBody FeelComment feelComment) {
        feelComment.setTimeCreated(new Timestamp(new Date().getTime()));
        return feelCommentService.addFeelComment(feelComment);
    }

    @PutMapping("")
    public FeelComment updateFeelComment(@RequestBody FeelComment feelComment) {
        return feelCommentService.updateFeelComment(feelComment);
    }

    @DeleteMapping("")
    public void deleteFeelComment(@RequestBody FeelComment feelComment) {
        feelCommentService.deleteFeelComment(feelComment);
    }

    @GetMapping("/check")
    public FeelComment checkUserFeelComment(@RequestParam Long idUser,@RequestParam Long idCommentPost) {
        return feelCommentService.checkUserFeelComment(idUser, idCommentPost);
    }

}
