package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.StudentSaveRequest;
import com.basri.SpringDataJPA.dto.response.StudentResponse;
import com.basri.SpringDataJPA.entity.Student;
import com.basri.SpringDataJPA.exception.StudentAgeException;
import com.basri.SpringDataJPA.mapper.StudentMapper;
import com.basri.SpringDataJPA.repository.IStudentRepository;
import com.basri.SpringDataJPA.service.IStudentService;
import com.basri.SpringDataJPA.util.AgeCalculatorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
