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
@Table(name = DatabaseConstants.TABLE_SUBJECT)
public class Subject extends Entity{
	
	@Column(name = DatabaseConstants.TITLE)
	private String title;
	
	
	
	

}
