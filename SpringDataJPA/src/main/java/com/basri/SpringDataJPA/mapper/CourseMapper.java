package com.basri.SpringDataJPA.mapper;

import com.basri.SpringDataJPA.dto.request.CourseSaveRequest;
import com.basri.SpringDataJPA.dto.response.CourseResponse;
import com.basri.SpringDataJPA.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    Course courseSaveRequestToCourse(CourseSaveRequest request);

    CourseResponse courseToCourseResponse(Course course);

    List<CourseResponse> courseToCourseResponseList(List<Course> courses);
}