package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.CourseResponse;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Course;
import com.basri.SpringDataJPA.entity.Student;
import com.basri.SpringDataJPA.exception.HomeNotFoundException;
import com.basri.SpringDataJPA.exception.StudentAgeException;
import com.basri.SpringDataJPA.exception.StudentNotFoundException;
import com.basri.SpringDataJPA.mapper.StudentMapper;
import com.basri.SpringDataJPA.repository.CourseRepository;
import com.basri.SpringDataJPA.repository.ICustomerRepository;
import com.basri.SpringDataJPA.repository.IStudentRepository;
import com.basri.SpringDataJPA.service.IStudentService;
import com.basri.SpringDataJPA.util.AgeCalculatorUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private final IStudentRepository studentRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final StudentMapper studentMapper;

    @Override
    @Transactional
    public StudentResponse saveStudent(StudentSaveRequest request) {

        int age = AgeCalculatorUtil.calculateAge(request.getBirthDate());

        if (age < 18) {
            throw new StudentAgeException(
                    "Öğrenci 18 yaşından küçük olamaz. Hesaplanan Yaş: " + age
            );
        }

        List<Course> courses = courseRepository.findAllById(request.getCourseIds());

        if (courses.size() != request.getCourseIds().size()) {
            throw new RuntimeException("Bazı kurslar bulunamadı");
        }

        Student student = studentMapper.toEntity(request);
        student.setCourses(courses);

        return studentMapper.toResponse(
                studentRepository.save(student)
        );
    }

    @Override
    public List<StudentResponse> findAll() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.toResponseList(students);
    }

    @Override
    public List<StudentResponse> findByNameAndSurname(String name, String surname) {
        if (name != null && surname != null) {
            List<Student> students = studentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
            if (students.isEmpty()) {
                throw new StudentNotFoundException(
                        "Student not found with name: " + name + " and surname: " + surname);
            }
            return studentMapper.toResponseList(students);
        } else if (name != null) {
            List<Student> students = studentRepository.findByNameIgnoreCase(name);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student not found with name: " + name);
            }
            return studentMapper.toResponseList(students);
        } else if (surname != null) {
            List<Student> students = studentRepository.findBySurnameIgnoreCase(surname);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student not found with surname: " + surname);
            }
            return studentMapper.toResponseList(students);
        }
        throw new StudentNotFoundException("At least one of 'name' or 'surname' must be provided.");
    }

    @Override
    public StudentResponse findById(int id) {
        return Optional.ofNullable(studentRepository.findById(id))
                .map(studentMapper::toResponse)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with given id : " + id));
    }

    @Override
    public StudentResponse deleteById(int id) {
        Student student = Optional.ofNullable(studentRepository.findById(id))
                .orElseThrow(() -> new StudentNotFoundException("Student not found with given id : " + id));

        studentRepository.delete(student);
        return studentMapper.toResponse(student);
    }

    @Override
    public StudentResponse updateStudent(int id, StudentSaveRequest request) {
        Optional<Student> student = Optional.ofNullable(studentRepository.findById(id));
        if (student.isPresent()) {
            student.get().setName(request.getName());
            student.get().setSurname(request.getSurname());
            student.get().setBirthDate(request.getBirthDate());
            studentRepository.save(student.get());
            return studentMapper.toResponse(student.get());
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
}
