package com.kaivale.student.management.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kaivale.student.management.domain.request.StudentRequest;
import com.kaivale.student.management.domain.response.StudentResponseDTO;
import com.kaivale.student.management.domain.response.StudentResponseList;
import com.kaivale.student.management.domain.response.SuccessResponse;
import com.kaivale.student.management.entity.Student;
import com.kaivale.student.management.repository.StudentRepository;
import com.kaivale.student.management.util.DatabaseConstants;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
	
	
	 @InjectMocks
	 private StudentService studentService;
	 
	 @Mock
	 private StudentRepository studentRepo;
	 
	 
	 
	 @Test
	 public void getAllStudents_Successs() {
		 List<Student> expectedStudentList = buildStudentList();
		 when(studentRepo.findAll()).thenReturn(expectedStudentList);
		 StudentResponseList response = studentService.getAllStudents();
		 assertNotNull(response);
		 validateResponseData(response,expectedStudentList);
		 verify(studentRepo, times(1)).findAll();
	 }
	 
	 
	 @Test
	 public void getAllStudents_Successs_WhenNoStudentsExists() {
		 List<Student> expectedStudentList = new ArrayList<>();
		 when(studentRepo.findAll()).thenReturn(expectedStudentList);
		 StudentResponseList response = studentService.getAllStudents();
		 assertTrue(response.getStudentsList().isEmpty());
		 assertEquals(0,response.getStudentsList().size());
		 verify(studentRepo, times(1)).findAll();
	 }
	 
	 
	 
	 @Test
	 public void addStudent_Success() {
		 
		 StudentRequest studentReq = buildStudentRequest();
		 SuccessResponse expectedResponse = buildResponse(DatabaseConstants.STUDENT_ADDED, DatabaseConstants.SUCCESS_CODE);
		 SuccessResponse actualResponse = studentService.addStudent(studentReq);
		 assertNotNull(actualResponse);
		 assertEquals(expectedResponse.getCode(),actualResponse.getCode());
		 assertEquals(expectedResponse.getMessage(),actualResponse.getMessage());
		 
	 }	


	private SuccessResponse buildResponse(String studentUpdated, String successCode) {
			SuccessResponse response = new SuccessResponse();
			response.setTimestamp(LocalDateTime.now());
			response.setMessage(studentUpdated);
			response.setCode(successCode);
			return response;
		}




	private StudentRequest buildStudentRequest() {
		StudentRequest studentRequest = new StudentRequest();
		studentRequest.setFirstName("Bhavani");
		studentRequest.setLastName("Shankar");
		studentRequest.setGroupId("CSE");
		return studentRequest;
	}


	private List<Student> buildStudentList() {
		List<Student> studentsList = new ArrayList<>();
		
		
		Student student = new Student();
		student.setFirstName("Bhavani");
		student.setLastName("Shankar");
		student.setId(1);
		student.setLastModifiedUser("ADMIN");
		
		studentsList.add(student);
		
		return studentsList;
	}
	
	
	
	private void validateResponseData(StudentResponseList response, List<Student> expectedStudentList) {
		for(int i=0;i<expectedStudentList.size();i++) {
			List<StudentResponseDTO> actualData = response.getStudentsList();
			Student	currentExpectedaData = expectedStudentList.get(i);
			StudentResponseDTO currnetActualData = actualData.get(i);
			assertEquals(currentExpectedaData.getFirstName(),currnetActualData.getFirstName());
			assertEquals(currentExpectedaData.getLastName(),currnetActualData.getLastName());
		}
	}
	 
	
	

}
