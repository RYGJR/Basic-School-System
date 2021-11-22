package demo.softdevproject.demo.service;

import java.util.List;

import demo.softdevproject.demo.model.TeacherClass;
import org.springframework.data.domain.Page;

public interface TeacherClassService {
    List<TeacherClass> getAllTeacherClass();
    void saveTeacherClass(TeacherClass teacherClass);
    TeacherClass getTeacherClassById(long id);
    void deleteTeacherClassById(long id);
    Page<TeacherClass> findPaginated2(int pageNo2, int pageSize2, String sortField2, String sortDirection2);
}