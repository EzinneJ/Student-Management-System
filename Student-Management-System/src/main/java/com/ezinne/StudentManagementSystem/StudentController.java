package com.ezinne.StudentManagementSystem;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String StudentList(Model model) {
        model.addAttribute("students", studentService.studentList());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{studentId}")
    public String editStudent(@PathVariable Long studentId, Model model) {
        model.addAttribute("student", studentService.findById(studentId));
        return "edit_student";
    }

    @PostMapping("/students/{studentId}")
    public String updateStudent(@PathVariable Long studentId, @ModelAttribute("student") Student student) {
        studentService.updateStudent(student, studentId);
        return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}
