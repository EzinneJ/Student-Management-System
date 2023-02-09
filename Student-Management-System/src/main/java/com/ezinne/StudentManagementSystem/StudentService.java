package com.ezinne.StudentManagementSystem;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> updateStudent(Student student, Long studentId){
        return Optional.ofNullable(studentRepository.findById(studentId)
                .map(existingStudentDetails -> {
                    existingStudentDetails.setId(studentId);
                    existingStudentDetails.setFirstName(student.getFirstName());
                    existingStudentDetails.setLastName(student.getLastName());
                    existingStudentDetails.setEmail(student.getEmail());
                    return studentRepository.save(student);
                }).orElseThrow(IllegalArgumentException::new));

    }

}
