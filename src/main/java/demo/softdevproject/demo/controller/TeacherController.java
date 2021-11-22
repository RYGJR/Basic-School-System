package demo.softdevproject.demo.controller;

import java.util.List;

import demo.softdevproject.demo.model.Teacher;
import demo.softdevproject.demo.service.TeacherService;
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
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // display list of teachers
    @GetMapping("/admin_teacher")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/showNewTeacherForm")
    public String showNewTeacherForm(Model model) {
        // create model attribute to bind form data
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "new_teacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        // save teacher to database
        teacherService.saveTeacher(teacher);
        return "redirect:/admin_teacher";
    }

    @GetMapping("/showFormForUpdateTeacher/{id}")
    public String showFormForUpdateTeacher(@PathVariable ( value = "id") long id, Model model) {

        // get teacher from the service
        Teacher teacher = teacherService.getTeacherById(id);

        // set teacher as a model attribute to pre-populate the form
        model.addAttribute("teacher", teacher);
        return "update_teacher";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable (value = "id") long id) {

        // call delete teacher method
        this.teacherService.deleteTeacherById(id);
        return "redirect:/admin_teacher";
    }


    @GetMapping("/page1/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo1") int pageNo1,
                                @RequestParam("sortField1") String sortField1,
                                @RequestParam("sortDir1") String sortDir1,
                                Model model) {
        int pageSize = 5;

        Page<Teacher> page = teacherService.findPaginated(pageNo1, pageSize, sortField1, sortDir1);
        List<Teacher> listTeachers = page.getContent();

        model.addAttribute("currentPage1", pageNo1);
        model.addAttribute("totalPages1", page.getTotalPages());
        model.addAttribute("totalItems1", page.getTotalElements());

        model.addAttribute("sortField1", sortField1);
        model.addAttribute("sortDir1", sortDir1);
        model.addAttribute("reverseSortDir1", sortDir1.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTeachers", listTeachers);
        return "index1";
    }
}
