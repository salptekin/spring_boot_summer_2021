package rest_api04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentBean05Service {
	
	private StudentBean05Repository studentRepo;
	
	@Autowired
	public StudentBean05Service(StudentBean05Repository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	public List<StudentBean05> listStudents(){
		return studentRepo.findAll();
	}
	
	public StudentBean05 getStudentById(Long id) {
		
		if(studentRepo.findById(id).isPresent()) {
			return studentRepo.findById(id).get();
		}else {
			return new StudentBean05();
		}
		
	}

}
