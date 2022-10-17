package com.kaivale.student.management.domain.response;

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
public class StudentMarksResponseDTO {
	
	
	
	private String firstName;
	private String lastName;
	private int subjectName;
	private int marks;
	
	
	public int getMarks() {
		return marks;
	}
	public void setMark(int marks) {
		this.marks = marks;
	}

	public int getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(int subjectName) {
		this.subjectName = subjectName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
