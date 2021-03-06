package rest_api04_controller_service_repository_basic_auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentBean05Repository extends JpaRepository<StudentBean05, Long>{
	
	Optional<StudentBean05> findStudentBean05ByEmail(String email);

}
