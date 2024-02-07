package in.bhau.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import in.bhau.entity.Student1;

@Service
public interface Student1Service {

	public List<Student1> findAllStudents();
	
	public Optional<Student1> findStudent(Integer sid);
	
	public void saveStudent(Student1 student);
	
	public void deleteStudent(Integer sid);

}
