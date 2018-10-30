package me.ermias.demo;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String home(Model model){
        Student student = new Student();
        student.setNickName("Ermiji");
        student.setRealname("Ermias");
        student.seteAddress("@gmail.com");

        Course course = new Course();
        course.setCourseName("Physics");
        course.setDescription("Course taken by...");

        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        student.setCourses(courses);

        studentRepository.save(student);

        model.addAttribute("students", studentRepository.findAll());
        return "home";
    }
}
