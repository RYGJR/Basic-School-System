package demo.softdevproject.demo.controller;

import java.util.List;

import demo.softdevproject.demo.model.Teacher;
import demo.softdevproject.demo.model.TeacherClass;
import demo.softdevproject.demo.service.TeacherClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherClassController {

    @Autowired
    private TeacherClassService teacherClassService;

    // display list of students
    @GetMapping("/teacher_class")
    public String viewHomePage(Model model) {
        return findPaginated2(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewTeacherClassForm")
    public String showNewTeacherClassForm(Model model) {
        // create model attribute to bind form data
        TeacherClass teacherClass = new TeacherClass();
        model.addAttribute("teacherClass", teacherClass);
        return "new_teacherclass";
    }

    @PostMapping("/saveTeacherClass")
    public String saveTeacherClass(@ModelAttribute("teacherClass") TeacherClass teacherClass) {
        // save student to database
        teacherClassService.saveTeacherClass(teacherClass);
        return "redirect:/teacher_class";
    }

    @GetMapping("/showFormForUpdateTeacherClass/{id}")
    public String showFormForUpdateTeacherClass(@PathVariable ( value = "id") long id, Model model) {

        // get student from the service
        TeacherClass teacherClass = teacherClassService.getTeacherClassById(id);

        // set student as a model attribute to pre-populate the form
        model.addAttribute("teacherClass", teacherClass);
        return "update_teacherclass";
    }

    @GetMapping("/deleteTeacherClass/{id}")
    public String deleteTeacherClass(@PathVariable (value = "id") long id) {

        // call delete student method
        this.teacherClassService.deleteTeacherClassById(id);
        return "redirect:/teacher_class";
    }




    @GetMapping("/page2/{pageNo}")
    public String findPaginated2(@PathVariable (value = "pageNo2") int pageNo2,
                                 @RequestParam("sortField2") String sortField2,
                                 @RequestParam("sortDir2") String sortDir2,
                                 Model model) {
        int pageSize = 5;

        Page<TeacherClass> page = teacherClassService.findPaginated2(pageNo2, pageSize, sortField2, sortDir2);
        List<TeacherClass> teacherClass = page.getContent();

        model.addAttribute("currentPage2", pageNo2);
        model.addAttribute("totalPages2", page.getTotalPages());
        model.addAttribute("totalItems2", page.getTotalElements());

        model.addAttribute("sortField2", sortField2);
        model.addAttribute("sortDir2", sortDir2);
        model.addAttribute("reverseSortDir2", sortDir2.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTeacherClass", teacherClass);
        return "index2"; //index3 to view in student
    }
}
