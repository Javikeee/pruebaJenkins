package com.example.demo.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.model.TutorialVO;
import com.example.demo.model.domain.Tutorial;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TutorialMapper {

    private final ModelMapper modelMapper;
    
    public TutorialVO fromPropertyToVO(Tutorial tutorial){
        return modelMapper.map(tutorial, TutorialVO.class);
    }

    public Tutorial fromVOToProperty(TutorialVO tutorialVO){
        return modelMapper.map(tutorialVO, Tutorial.class);
    }
}
