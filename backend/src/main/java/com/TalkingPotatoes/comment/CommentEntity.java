package com.TalkingPotatoes.comment;

import com.TalkingPotatoes.boardtoyoutube.YoutubeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class CommentEntity {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    private String comment;

    //youtitle  유튜브 페이지 이름
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "youtube_id" )
    private YoutubeEntity youtube_title;







}
