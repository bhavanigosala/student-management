package com.kaivale.student.management.domain.response;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ApiModel
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponseList {
	
	private List<StudentResponseDTO> studentsList = new ArrayList<>();

	public List<StudentResponseDTO> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(List<StudentResponseDTO> studentsList) {
		this.studentsList = studentsList;
	}
	
	
	
	

}
