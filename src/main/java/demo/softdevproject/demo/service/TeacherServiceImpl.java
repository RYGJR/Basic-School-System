package demo.softdevproject.demo.service;


import java.util.List;
import java.util.Optional;

import demo.softdevproject.demo.model.Teacher;
import demo.softdevproject.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(long id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        Teacher teacher = null;
        if (optional.isPresent()) {
            teacher = optional.get();
        } else {
            throw new RuntimeException(" Teacher not found for id :: " + id);
        }
        return teacher;
    }

    @Override
    public void deleteTeacherById(long id) {
        this.teacherRepository.deleteById(id);
    }

    @Override
    public Page<Teacher> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.teacherRepository.findAll(pageable);
    }
}