package com.TalkingPotatoes.boardtodeclaration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeclarationService {


    private final DeclarationRepository declarationRepository;



    public void CreateDeclartaion(DeclarationCreateDTO dto){

        DeclarationEntity entity = DeclarationEntity.builder()
                .content(dto.getContent())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .password(dto.getPassword())
                .title(dto.getTitle())
                .url(dto.getUrl())
                .build();



        declarationRepository.save(entity);
    }



    public String DeleteDeclartaion(Long id , String password){

        Optional<DeclarationEntity> byId = declarationRepository.findById(id);

        if(byId.get().getPassword().equals(password)){
            declarationRepository.delete(byId.get());
            return "성공";
        }


        return "실패";
    }







}
