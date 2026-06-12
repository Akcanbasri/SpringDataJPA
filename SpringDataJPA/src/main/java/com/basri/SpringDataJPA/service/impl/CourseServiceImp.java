package com.basri.SpringDataJPA.service.impl;

import com.basri.SpringDataJPA.dto.request.CourseSaveRequest;
import com.basri.SpringDataJPA.dto.response.CourseResponse;
import com.basri.SpringDataJPA.entity.Course;
import com.basri.SpringDataJPA.mapper.CourseMapper;
import com.basri.SpringDataJPA.repository.CourseRepository;
import com.basri.SpringDataJPA.service.ICourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements ICourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    @Transactional
    public CourseResponse saveCourse(CourseSaveRequest request) {
        Course course = courseMapper.courseSaveRequestToCourse(request);
         Course savedCourse =  courseRepository.save(course);
        return courseMapper.courseToCourseResponse(savedCourse);
    }

    @Override
    public List<CourseResponse> findAll() {
        return courseMapper.courseToCourseResponseList(courseRepository.findAll());
    }
}
