package com.TalkingPotatoes.boardtoyoutube;

import com.TalkingPotatoes.comment.CommentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class YoutubeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "youtube_id")
    private Long id;


    private String url;


    @Builder.Default
    @OneToMany(mappedBy = "youtube_title",fetch = FetchType.LAZY)
    private List<CommentEntity> comments = new ArrayList<>();


}