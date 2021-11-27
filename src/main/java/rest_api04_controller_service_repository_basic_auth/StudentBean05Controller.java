package rest_api04_controller_service_repository_basic_auth;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBean05Controller {
	
	private StudentBean05Service studentService;

	@Autowired
	public StudentBean05Controller(StudentBean05Service studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping(path="/allStudents")
	public List<StudentBean05> getAllStudents(){
		return studentService.listStudents();
	}
	
	@GetMapping(path="/allStudents/{id}")
	public StudentBean05 getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping(path="/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable Long id) {
		return studentService.deleteStudentById(id);
	}	
	
	@PutMapping(path="/updateStudentFully/{id}")
	public StudentBean05 fullyUpdateStudentById(@PathVariable Long id, @Validated @RequestBody StudentBean05 newStudent) {
		return studentService.fullyUpdateStudent(id, newStudent);
	}
	
	@PatchMapping(path="/updateStudentPartially/{id}")
	public StudentBean05 partiallyUpdateStudentById(@PathVariable Long id, @Validated @RequestBody StudentBean05 newStudent) {
		return studentService.partiallyUpdateStudent(id, newStudent);
	}	
	
	@PostMapping(path="/addNewStudent")
	public StudentBean05 postStudent(@Validated @RequestBody StudentBean05 newStudent) throws ClassNotFoundException, SQLException {
		return studentService.addNewStudent(newStudent);
	}

}
