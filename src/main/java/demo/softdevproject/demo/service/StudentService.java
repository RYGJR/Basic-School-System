package demo.softdevproject.demo.service;

import java.util.List;

import demo.softdevproject.demo.model.Student;
import org.springframework.data.domain.Page;

public interface StudentService {
    List<Student> getAllStudent();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
