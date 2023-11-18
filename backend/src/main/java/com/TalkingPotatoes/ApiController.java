package com.TalkingPotatoes;

import com.TalkingPotatoes.boardtodeclaration.*;
import com.TalkingPotatoes.boardtoyoutube.YoutubeService;
import com.TalkingPotatoes.comment.CommentDTO;
import com.TalkingPotatoes.comment.CommentService;
import com.TalkingPotatoes.comment.CommentsDTO;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ApiController {


    private final YoutubeService youtubeService;
    private final CommentService commentService;
    private final DeclarationService declarationService;


    //
    @GetMapping("/showComment")
    public List<CommentsDTO> showComment(@RequestParam Long id) {
        return commentService.showComment(id);
    }


    //댓글저장
    /*
    {
        "comment" : "hi",
        "youtube_title" : 3
    }
  */
    @PostMapping("/saveComment")
    public void saveComment(@RequestBody CommentDTO commentDTO) {

        System.out.println("asd");
        commentService.saveComment(commentDTO);

    }


    //유튜브 저장
    @PostMapping("/youtube")
    public void createYoutube(@RequestParam String url) {
        youtubeService.createYoutube(url);
    }

    //?보내느거 ?

    @PostMapping("/declaration/create")
    public void createDeclaration(@RequestBody DeclarationCreateDTO dto) {
        declarationService.CreateDeclartaion(dto);
    }



    @PostMapping("/declaration/{id}")
    public ResponseEntity<String> DeleteDeclaration(@PathVariable Long id , @RequestParam String password){
        return ResponseEntity.ok().body(declarationService.DeleteDeclartaion(id, password));
    }


}