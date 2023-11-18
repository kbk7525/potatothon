package com.TalkingPotatoes.comment;


import com.TalkingPotatoes.boardtoyoutube.YoutubeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CommentDTO {


    //    private Long comment_id;

    private String comment;
    private Long youtubeEntityId;


}
