package com.kaivale.student.management.entity;

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
@Table(name = DatabaseConstants.TABLE_TEACHER_SUBJECT)
public class TeacherSubject extends Entity{
	
	
	@Column(name = DatabaseConstants.TEACHER_ID)
	private int teacherId;
	
	
	@Column(name = DatabaseConstants.SUBJECT_ID)
	private int subjectId;
	
	@Column(name = DatabaseConstants.GROUP_ID)
	private int groupId;
	
	
	
	
	
	
	
	

}
