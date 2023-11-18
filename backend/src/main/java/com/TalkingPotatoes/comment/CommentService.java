package com.TalkingPotatoes.comment;

import com.TalkingPotatoes.boardtoyoutube.YoutubeDTO;
import com.TalkingPotatoes.boardtoyoutube.YoutubeEntity;
import com.TalkingPotatoes.boardtoyoutube.YoutubeRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Builder
public class CommentService {

    private final YoutubeRepository youtubeRepository;
    private final CommentRepository commentRepository;



    @Transactional
    public List<CommentsDTO> showComment(Long id){


        Optional<YoutubeEntity> byId = youtubeRepository.findById(id);

        List<CommentsDTO> list = new ArrayList<>();

        for (CommentEntity comments : byId.get().getComments()){
            list.add(CommentsDTO.builder()
                    .comment(comments.getComment())
                    .build());

        }
        return list;
    }
    public void saveComment(CommentDTO commentDTO){

        Optional<YoutubeEntity> byId = youtubeRepository.findById(commentDTO.getYoutubeEntityId());
        CommentEntity entity = CommentEntity.builder()
                .youtube_title(byId.get())
                .comment(commentDTO.getComment())
                .build();

        commentRepository.save(entity);
    }
//
//    public void showComment(Long id){
//        List<CommentDTO> list =  commentRepository.findIdByComment(id);
//    }




}
