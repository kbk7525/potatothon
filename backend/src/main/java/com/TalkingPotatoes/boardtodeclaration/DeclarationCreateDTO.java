package com.TalkingPotatoes.boardtodeclaration;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DeclarationCreateDTO {


    private String latitude;    //위도
    private String longitude;   //경도
    private String title;
    private String password;
    private String content;
    private String url;

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }
}
