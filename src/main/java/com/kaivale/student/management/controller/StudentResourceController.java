package com.kaivale.student.management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaivale.student.management.domain.request.StudentRequest;
import com.kaivale.student.management.domain.response.StudentMarksList;
import com.kaivale.student.management.domain.response.StudentResponseDTO;
import com.kaivale.student.management.domain.response.StudentResponseList;
import com.kaivale.student.management.domain.response.SuccessResponse;
import com.kaivale.student.management.domain.response.TeacherStudentList;
import com.kaivale.student.management.iface.IStudentService;
import com.kaivale.student.management.util.DatabaseConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@Api(value = "StudentResourceController", tags = "Student Management Operations")
@RequestMapping("/student")
@AllArgsConstructor
@Validated
public class StudentResourceController {
	
	    
	@Autowired
	private IStudentService studentService;
	
	
	
	    @ApiOperation(value = "Get All Students")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @GetMapping("/")
	    public ResponseEntity<?> getAllStudents() {
           return new ResponseEntity<StudentResponseList>(studentService.getAllStudents(), HttpStatus.OK);
	    }
	
	    
	    
	    @ApiOperation(value = "Add Student")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @PostMapping("/add")
	    public ResponseEntity<?> addStudent(@ApiParam(name =  "create student request object", value = "Student create", required = true)
         @RequestBody StudentRequest studentRequest) {
           return new ResponseEntity<SuccessResponse>(studentService.addStudent(studentRequest), HttpStatus.OK);
	    }
	    
	    
	    @ApiOperation(value = "Get Student By Id")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @GetMapping("/{studentId}")
	    public ResponseEntity<?> getStudentById(@ApiParam(name =  "student Id", value = "Get Student Info", required = true)
         @PathVariable("studentId") int studentId) {
           return new ResponseEntity<StudentResponseDTO>(studentService.getStudentById(studentId), HttpStatus.OK);
	    }
	    
	    
	    @ApiOperation(value = "update Student")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @PatchMapping("/{studentId}")
	    public ResponseEntity<?> updateStudent(@ApiParam(name =  "Update student object", value = "Update Student", required = true)
         @PathVariable("studentId") int studentId,@RequestBody StudentRequest studentRequest) {
	    	return new ResponseEntity<SuccessResponse>(studentService.updateStudent(studentId,studentRequest), HttpStatus.OK);
           
	    }
	    
	    
	   @ApiOperation(value = "Get Mark By Student Id/List of Marks in each subject for a Student")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @GetMapping("/{studentId}")
	    public ResponseEntity<?> getMarkByStudentId(@ApiParam(name =  "student Id", value = "Get Marks Info", required = true)
         @PathVariable("studentId") int studentId) {
           return new ResponseEntity<StudentMarksList>(studentService.getMarksByStudentId(studentId), HttpStatus.OK);
	    }
	    
	    
	    
	    
	    @ApiOperation(value = "Get List of Students for a Teacher")
	    @ApiResponses(value = {@ApiResponse(code = 200, message = DatabaseConstants.SUCCESS)})
	    @GetMapping("/{teacherId}")
	    public ResponseEntity<?> getStudentsByTeacherId(@ApiParam(name =  "Teacher Id", value = "Get Students for a Teacher", required = true)
         @PathVariable("teacherId") int teacherId) {
           return new ResponseEntity<TeacherStudentList>(studentService.getStudentsByTeacherId(teacherId), HttpStatus.OK);
	    }
	    
	    
	    
	
	
	
	

}
