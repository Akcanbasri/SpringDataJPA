package com.basri.SpringDataJPA.service;

import com.basri.SpringDataJPA.dto.request.CourseSaveRequest;
import com.basri.SpringDataJPA.dto.response.CourseResponse;

import java.util.List;

public interface ICourseService {

    CourseResponse saveCourse(CourseSaveRequest request);

    List<CourseResponse> findAll();
}
