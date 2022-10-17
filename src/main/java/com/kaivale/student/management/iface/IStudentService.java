package com.kaivale.student.management.iface;

import com.kaivale.student.management.domain.request.StudentRequest;
import com.kaivale.student.management.domain.response.StudentMarksList;
import com.kaivale.student.management.domain.response.StudentResponseDTO;
import com.kaivale.student.management.domain.response.StudentResponseList;
import com.kaivale.student.management.domain.response.SuccessResponse;
import com.kaivale.student.management.domain.response.TeacherStudentList;

public interface IStudentService {
	
	
	StudentResponseList getAllStudents();

	SuccessResponse addStudent(StudentRequest studentRequest);

	StudentResponseDTO getStudentById(int id);

	SuccessResponse updateStudent(int id, StudentRequest studentRequest);

	StudentMarksList getMarksByStudentId(int id);

	TeacherStudentList getStudentsByTeacherId(int teacherId);

}
