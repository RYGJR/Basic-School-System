package demo.softdevproject.demo.repository;

import demo.softdevproject.demo.model.TeacherClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherClassRepository extends JpaRepository<TeacherClass, Long> {
}
