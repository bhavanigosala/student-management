package com.kaivale.student.management.entity;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.kaivale.student.management.util.DatabaseConstants;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@Setter
@Getter
public class Entity {
	
	
	@Id
    @GeneratedValue
    @Access(AccessType.PROPERTY)
    @Column(name = DatabaseConstants.ID)
     private int id;

    @Column(name = DatabaseConstants.CREATED_DTTM)
    private LocalDateTime createdDttm;

    @Column(name = DatabaseConstants.LAST_MODIFIED_DTTM)
    private LocalDateTime lastModifiedDttm;

    @Column(name = DatabaseConstants.LAST_MODIFIED_USER)
    private String lastModifiedUser;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDttm() {
		return createdDttm;
	}

	public void setCreatedDttm(LocalDateTime createdDttm) {
		this.createdDttm = createdDttm;
	}

	public LocalDateTime getLastModifiedDttm() {
		return lastModifiedDttm;
	}

	public void setLastModifiedDttm(LocalDateTime lastModifiedDttm) {
		this.lastModifiedDttm = lastModifiedDttm;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
    
    
    
    
    
    
	
	
	

}
