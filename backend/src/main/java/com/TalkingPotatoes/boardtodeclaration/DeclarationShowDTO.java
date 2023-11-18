package com.TalkingPotatoes.boardtodeclaration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeclarationShowDTO {

    private Long id;
    private String title;
    private String content;

}
