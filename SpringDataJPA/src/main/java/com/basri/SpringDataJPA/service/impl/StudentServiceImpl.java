package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import com.basri.SpringDataJPA.exception.StudentAgeException;
import com.basri.SpringDataJPA.exception.StudentNotFoundException;
import com.basri.SpringDataJPA.mapper.StudentMapper;
import com.basri.SpringDataJPA.repository.IStudentRepository;
import com.basri.SpringDataJPA.service.IStudentService;
import com.basri.SpringDataJPA.util.AgeCalculatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository IStudentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse saveStudent(StudentSaveRequest request) {
        // 1. Business Logic / Validation using Util
        int age = AgeCalculatorUtil.calculateAge(request.getBirthDate());
        if (age < 18) {
            // Throwing Custom Exception
            throw new StudentAgeException("Öğrenci 18 yaşından küçük olamaz. Hesaplanan Yaş: " + age);
        }

        // 2. Conversion using Mapper (DTO -> Entity)
        Student student = studentMapper.toEntity(request);

        // 3. Save to database
        Student savedStudent = IStudentRepository.save(student);

        // 4. Conversion using Mapper (Entity -> DTO)
        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> findAll() {
        List<Student> students = IStudentRepository.findAll();
        return studentMapper.toResponseList(students);
    }

    @Override
    public List<StudentResponse> findByNameAndSurname(String name, String surname) {
        if (name != null && surname != null) {
            List<Student> students = IStudentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
            if (students.isEmpty()) {
                throw new StudentNotFoundException(
                        "Student not found with name: " + name + " and surname: " + surname);
            }
            return studentMapper.toResponseList(students);
        } else if (name != null) {
            List<Student> students = IStudentRepository.findByNameIgnoreCase(name);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student not found with name: " + name);
            }
            return studentMapper.toResponseList(students);
        } else if (surname != null) {
            List<Student> students = IStudentRepository.findBySurnameIgnoreCase(surname);
            if (students.isEmpty()) {
                throw new StudentNotFoundException("Student not found with surname: " + surname);
            }
            return studentMapper.toResponseList(students);
        }
        throw new StudentNotFoundException("At least one of 'name' or 'surname' must be provided.");
    }

    @Override
    public StudentResponse findById(int id) {
        Optional<Student> student = Optional.ofNullable(IStudentRepository.findById(id));
        return student.map(studentMapper::toResponse).orElse(null);
    }

    @Override
    public StudentResponse deleteById(int id) {
        Optional<Student> student = Optional.ofNullable(IStudentRepository.findById(id));
        if (student.isPresent()) {
            IStudentRepository.deleteById(id);
            return studentMapper.toResponse(student.get());
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }

    @Override
    public StudentResponse updateStudent(int id, StudentSaveRequest request) {
        Optional<Student> student = Optional.ofNullable(IStudentRepository.findById(id));
        if (student.isPresent()) {
            student.get().setName(request.getName());
            student.get().setSurname(request.getSurname());
            student.get().setBirthDate(request.getBirthDate());
            IStudentRepository.save(student.get());
            return studentMapper.toResponse(student.get());
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
}
