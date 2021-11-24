package rest_api02_controller_service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class StudentBean03Service {
	
	List<StudentBean03> listOfStd = List.of(
												new StudentBean03(101L, "Ali Can", "ac@gmail.com", LocalDate.of(2002, 3, 12)),
												new StudentBean03(102L, "Mary Star", "ms@gmail.com", LocalDate.of(1996, 5, 21)),
												new StudentBean03(103L, "Veli Han", "vh@gmail.com", LocalDate.of(2011, 7, 5)),
												new StudentBean03(104L, "Angie Star", "as@gmail.com", LocalDate.of(1997, 10, 11))
			                               );
	
	public List<StudentBean03> getListOfStudents(){
		return listOfStd;
	}
	
	public StudentBean03 getStudentById(Long id) {
		
		if(listOfStd.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()) {
			return new StudentBean03();
		}
		return listOfStd.stream().filter(t->t.getId()==id).findFirst().get();
		
	}

}
