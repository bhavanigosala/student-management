package com.kaivale.student.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kaivale.student.management.domain.response.StudentMarksResponseDTO;
import com.kaivale.student.management.domain.response.TeacherStudent;
import com.kaivale.student.management.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
	

	@Query(value="select"
			+ " s.first_name as firstName, "
			+ "s.last_name as lastName, "
			+ "sj.title as subjectName, "
			+ "m.mark as marks from STUDENT s join MARKS m ON "
			+ "s.id=m.student_id join  SUBJECT ON sj.id=m.subject_id and s.id:=id",nativeQuery=true)
	List<StudentMarksResponseDTO> getStudentMarks(@Param("id")int id);
	
	
	
	
	
	
   @Query(value="select s.id as studentId,st.teacher_id as teacherId from TEACHER_SUBJECT st join Marks m on st.subject_id =m.subject_id "
   		+ "join SUBJECT s on s.id=m.student_id and "
   		+ "st.teacher_id:=teacherId ")
	List<TeacherStudent> getStudentsByTeacherId(@Param("teacherId")int teacherId);
	
	
}


