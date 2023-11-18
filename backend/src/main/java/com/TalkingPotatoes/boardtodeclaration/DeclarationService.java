package com.TalkingPotatoes.boardtodeclaration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

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

    public List<DeclarationShowDTO> showBoard() {

        List<DeclarationEntity> all = declarationRepository.findAll();
        List<DeclarationShowDTO> list = new ArrayList<>();
        for (DeclarationEntity id : all) {
            list.add(DeclarationShowDTO.builder()
                    .content(id.getContent())
                    .id(id.getId())
                    .title(id.getTitle())
                    .build());
        }

        return list;


    }

    public DeclarationCreateDTO showDeclaration(Long id) {

        Optional<DeclarationEntity> byId = declarationRepository.findById(id);

        DeclarationCreateDTO board = DeclarationCreateDTO.builder()
                .title(byId.get().getTitle())
                .password(byId.get().getPassword())
                .longitude(byId.get().getLongitude())
                .latitude(byId.get().getLatitude())
                .content(byId.get().getContent())
                .build();

        return board;
    }






}
