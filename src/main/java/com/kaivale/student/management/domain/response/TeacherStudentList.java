package com.kaivale.student.management.domain.response;

import java.util.List;
import java.util.Map;

public class TeacherStudentList {
	
	
	private Map<Integer,List<Integer>> teacherStudentsList;

	public Map<Integer, List<Integer>> getTeacherStudentsList() {
		return teacherStudentsList;
	}

	public void setTeacherStudentsList(Map<Integer, List<Integer>> teacherStudentsList) {
		this.teacherStudentsList = teacherStudentsList;
	}
	
	

}
