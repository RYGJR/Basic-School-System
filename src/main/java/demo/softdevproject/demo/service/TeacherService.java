package demo.softdevproject.demo.service;

import java.util.List;

import demo.softdevproject.demo.model.Teacher;
import org.springframework.data.domain.Page;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(long id);
    void deleteTeacherById(long id);
    Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
