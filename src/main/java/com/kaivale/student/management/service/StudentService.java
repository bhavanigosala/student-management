package com.kaivale.student.management.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaivale.student.management.domain.request.StudentRequest;
import com.kaivale.student.management.domain.response.StudentMarksList;
import com.kaivale.student.management.domain.response.StudentMarksResponseDTO;
import com.kaivale.student.management.domain.response.StudentResponseDTO;
import com.kaivale.student.management.domain.response.StudentResponseList;
import com.kaivale.student.management.domain.response.SuccessResponse;
import com.kaivale.student.management.domain.response.TeacherStudent;
import com.kaivale.student.management.domain.response.TeacherStudentList;
import com.kaivale.student.management.entity.Student;
import com.kaivale.student.management.iface.IStudentService;
import com.kaivale.student.management.repository.StudentRepository;
import com.kaivale.student.management.util.DatabaseConstants;

import io.vavr.control.Try;

@Component
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	private static SuccessResponse response = new SuccessResponse();

	@Override
	public StudentResponseList getAllStudents() {

		List<StudentResponseDTO> studentResponseList = new ArrayList<>();
		StudentResponseList studentResponse = new StudentResponseList();
		Try.run(() -> {

			List<Student> studentList = studentRepository.findAll();

			studentList.stream().forEach(student -> {
				StudentResponseDTO studentDTO = new StudentResponseDTO();
				BeanUtils.copyProperties(student, studentDTO);
				studentResponseList.add(studentDTO);
			});

		});
		studentResponse.setStudentsList(studentResponseList);
		return studentResponse;

	}

	@Override
	public SuccessResponse addStudent(StudentRequest studentRequest) {

		Try.run(() -> {

			Student student = new Student();

			BeanUtils.copyProperties(studentRequest, student);

			student.setCreatedDttm(LocalDateTime.now());
			student.setLastModifiedDttm(LocalDateTime.now());
			student.setLastModifiedUser(DatabaseConstants.USER_ADMIN);

			studentRepository.save(student);

			response = buildResponse(DatabaseConstants.STUDENT_ADDED, DatabaseConstants.SUCCESS_CODE);

		}).onFailure(Exception.class, ex -> {
			response = buildResponse(DatabaseConstants.STUDENT_NOT_ADDED, DatabaseConstants.ERROR_CODE);

		});

		return response;
	}

	@Override
	public StudentResponseDTO getStudentById(int id) {
		StudentResponseDTO studentResponse = new StudentResponseDTO();
		Try.run(() -> {

			Optional<Student> student = studentRepository.findById(id);

			if (student.isPresent()) {
				BeanUtils.copyProperties(student.get(), studentResponse);
			}

		}).onFailure(Exception.class, ex -> {
			// Need to handle exception handling

		});
		return studentResponse;
	}

	@Override
	public SuccessResponse updateStudent(int id, StudentRequest studentRequest) {

		Try.run(() -> {
			response = new SuccessResponse();
			Optional<Student> existingStudent = studentRepository.findById(id);

			if (existingStudent.isPresent()) {
				BeanUtils.copyProperties(studentRequest, existingStudent);
				existingStudent.get().setLastModifiedDttm(LocalDateTime.now());
			}
			studentRepository.save(existingStudent.get());

			response = buildResponse(DatabaseConstants.STUDENT_UPDATED, DatabaseConstants.SUCCESS_CODE);

		}).onFailure(Exception.class, ex -> {
			response = new SuccessResponse();
			response = buildResponse(DatabaseConstants.STUDENT_NOT_UPDATED, DatabaseConstants.ERROR_CODE);
		});
		return response;
	}

	private SuccessResponse buildResponse(String studentUpdated, String successCode) {
		SuccessResponse response = new SuccessResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(studentUpdated);
		response.setCode(successCode);
		return response;
	}

	@Override
	public StudentMarksList getMarksByStudentId(int id) {
		
		
		StudentMarksList studentMarksResponse = new StudentMarksList();
		List<StudentMarksResponseDTO> studentMarksList = studentRepository.getStudentMarks(id);
		studentMarksResponse.setStudentMarks(studentMarksList);
		return studentMarksResponse;
	}

	@Override
	public TeacherStudentList getStudentsByTeacherId(int teacherId) {
        TeacherStudentList teacherStudentList = new TeacherStudentList();
		Map<Integer, List<Integer>> responseMap = new HashMap<>();
		List<TeacherStudent> teachersStudentList = studentRepository.getStudentsByTeacherId(teacherId);
		teachersStudentList.stream().forEach(techerObj -> {
			List<Integer> studentIds = new ArrayList<>();
			if (null != responseMap.get(techerObj.getTeacherId())) {
				studentIds = responseMap.get(techerObj.getTeacherId());
				studentIds.add(techerObj.getStudentId());
				responseMap.put(techerObj.getTeacherId(), studentIds);
			} else {
				responseMap.put(techerObj.getTeacherId(), new ArrayList<>(techerObj.getStudentId()));
			}

		});
		teacherStudentList.setTeacherStudentsList(responseMap);
		return teacherStudentList;
	} 

}
