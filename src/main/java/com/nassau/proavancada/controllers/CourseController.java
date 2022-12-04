package com.nassau.proavancada.controllers;

import com.nassau.proavancada.dtos.course.CreateCourseDto;
import com.nassau.proavancada.dtos.course.UpdateCourseDto;
import com.nassau.proavancada.dtos.student.UpdateStudentDto;
import com.nassau.proavancada.models.CourseModel;
import com.nassau.proavancada.models.StudentModel;
import com.nassau.proavancada.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    CourseController (CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<CourseModel> listCourses (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Float attendance,
            @RequestParam(required = false) Float attendanceTotal,
            @RequestParam(required = false) Float value,
            @RequestParam(required = false) String shift,
            @RequestParam(required = false) String days
    ) {
        PageRequest pagination = PageRequest.of(page, limit);
        return this.courseService.listCourses(name, attendance, attendanceTotal, value, shift, days, pagination);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CourseModel detailCourse (@PathVariable(value="id") String id) {
        return this.courseService.detailCourse(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseModel createCouse (@Valid @RequestBody CreateCourseDto course) {
        return this.courseService.createCourse(course);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public CourseModel updateCourse (@PathVariable(value="id") String id, @Valid @RequestBody UpdateCourseDto courseDto) {
        return this.courseService.updateCouse(Integer.parseInt(id), courseDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public CourseModel deleteCourse (@PathVariable(value="id") String id) {
        return this.courseService.deleteCourse(Integer.parseInt(id));
    }
}
