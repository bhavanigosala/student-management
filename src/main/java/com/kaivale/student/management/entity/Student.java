package com.kaivale.student.management.entity;


import com.kaivale.student.management.util.*;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@javax.persistence.Entity
@Builder(toBuilder = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstants.TABLE_STUDENT)
public class Student extends Entity{
	
	
    @Column(name = DatabaseConstants.FIRST_NAME)
	private String firstName;
    
    
    @Column(name = DatabaseConstants.LAST_NAME)
	private String lastName;
    
    @Column(name = DatabaseConstants.GROUP_ID)
  	private String groupId;
    

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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	
	
    
    
    

}
