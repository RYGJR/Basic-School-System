package demo.softdevproject.demo.service;

import java.util.List;
import java.util.Optional;

import demo.softdevproject.demo.model.TeacherClass;
import demo.softdevproject.demo.repository.TeacherClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TeacherClassServiceImpl implements TeacherClassService {

    @Autowired
    private TeacherClassRepository teacherClassRepository;

    @Override
    public List<TeacherClass> getAllTeacherClass() {
        return teacherClassRepository.findAll();
    }

    @Override
    public void saveTeacherClass(TeacherClass teacherClass) {
        this.teacherClassRepository.save(teacherClass);
    }

    @Override
    public TeacherClass getTeacherClassById(long id) {
        Optional<TeacherClass> optional = teacherClassRepository.findById(id);
        TeacherClass teacherClass = null;
        if (optional.isPresent()) {
            teacherClass = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return teacherClass;
    }

    @Override
    public void deleteTeacherClassById(long id) {
        this.teacherClassRepository.deleteById(id);
    }

    @Override
    public Page<TeacherClass> findPaginated2(int pageNo2, int pageSize2, String sortField2, String sortDirection2) {
        Sort sort = sortDirection2.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField2).ascending() :
                Sort.by(sortField2).descending();

        Pageable pageable = PageRequest.of(pageNo2 - 1, pageSize2, sort);
        return this.teacherClassRepository.findAll(pageable);
    }
}