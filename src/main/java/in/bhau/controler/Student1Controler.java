package in.bhau.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.bhau.entity.Student1;
import in.bhau.service.Student1Service;

@RestController
public class Student1Controler {
	
	@Autowired
	private Student1Service service;
	
	@GetMapping(value = "/students", produces = "application/json")
	public List<Student1> getStudents(){
		List<Student1> students = service.findAllStudents();
		return students;
	}
	
	@GetMapping(value = "/student", produces = "application/json")
	public Optional<Student1> getStudent() {
		Optional<Student1> student = service.findStudent(10);
		System.out.println(student);
		return student;
	}
	
	@PostMapping(value = "/student", produces = "text/plain" , consumes = "application/json")
	public ResponseEntity<String> saveStudent(@RequestBody Student1 student){
		System.out.println(student);
		service.saveStudent(student);
		String msg = "Student Successfully Added";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/student", produces = "text/plain" , consumes = "application/json")
	public String updateStudent(@RequestBody Student1 student) {
		Optional<Student1> findStudent = service.findStudent(student.getSid());
//		System.out.println(student.getSid());
		if(findStudent.isPresent()) {
			findStudent.get().setSname("Amol");
			findStudent.get().setSmail("amol@gmail.com");
			service.saveStudent(findStudent.get());
			return "Student Updated...";
		}
		return "Student Not Found...";
	}
	
	@DeleteMapping(value = "/student/{sid}", produces = "text/plain")
	public String deleteStudent(@PathVariable("sid") Integer sid) {
		service.deleteStudent(sid);
		return "Student Deleted...";
	}
	
	

}
