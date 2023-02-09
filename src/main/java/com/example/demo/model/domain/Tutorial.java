package com.example.demo.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("tutoriales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

	@Id
	private String id;
	
	private String title, description;
	private Boolean published;
	
}
