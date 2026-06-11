package com.basri.SpringDataJPA.controller;

import com.basri.SpringDataJPA.dto.request.CourseSaveRequest;
import com.basri.SpringDataJPA.dto.request.DepartmentSaveRequest;
import com.basri.SpringDataJPA.dto.response.CourseResponse;
import com.basri.SpringDataJPA.dto.response.DepartmentResponse;
import com.basri.SpringDataJPA.dto.response.EmployeeResponse;
import com.basri.SpringDataJPA.repository.CourseRepository;
import com.basri.SpringDataJPA.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
@Tag(name = "Course Controller", description = "Operations related to Course Management")
public class CourseController {
    private final ICourseService courseService;

    @PostMapping()
    @Operation(summary = "Save a new Course", description = "Adds a new Course to the system and returns the saved Course's details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Course successfully saved"),
    })
    public ResponseEntity<CourseResponse> saveDepartment(@Valid @RequestBody CourseSaveRequest request) {
        CourseResponse response = courseService.saveCourse(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping()
    @Operation(summary = "Find all courses" , description = "Find all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Gets all courses"),
    })
    public ResponseEntity<List<CourseResponse>> findAllDepartments() {
        List<CourseResponse> responses = courseService.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
