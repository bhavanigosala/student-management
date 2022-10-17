package com.kaivale.student.management.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Table;

import com.kaivale.student.management.util.DatabaseConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstants.TABLE_MARKS)
public class Marks extends Entity{
	
	
	@Column(name = DatabaseConstants.STUDENT_ID)
	private int studentId;
	
	@Column(name = DatabaseConstants.SUBJECT_ID)
	private int subjectId;
	
	@Column(name = DatabaseConstants.MARK)
	private int mark;
	
	@Column(name = DatabaseConstants.DATE)
	private LocalDate date; 


}
