package com.TalkingPotatoes.boardtoyoutube;

import com.TalkingPotatoes.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class YoutubeService {

    private final YoutubeRepository youtubeRepository;
    private final CommentRepository commentRepository;

    public void createYoutube(String url){

        YoutubeEntity entity = YoutubeEntity.builder()
                .url(url)
                .build();

        youtubeRepository.save(entity);

    }


}
