package in.bhau.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bhau.entity.Student1;
import in.bhau.repo.Student1Repository;

@Service
public class Student1ServiceImpl implements Student1Service {
	
	@Autowired
	private Student1Repository customerRepo;

	@Override
	public List<Student1> findAllStudents() {
		List<Student1> findAll = customerRepo.findAll();
		return findAll;
	}

	@Override
	public Optional<Student1> findStudent(Integer sid) {
		Optional<Student1> findById = customerRepo.findById(sid);
		return findById;
	}

	@Override
	public void saveStudent(Student1 student) {
		customerRepo.save(student);
	}

	@Override
	public void deleteStudent(Integer sid) {
		customerRepo.deleteById(sid);
	}

}
