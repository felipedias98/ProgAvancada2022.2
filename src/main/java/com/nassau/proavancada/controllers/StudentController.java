package com.nassau.proavancada.controllers;

import com.nassau.proavancada.dtos.student.CreateStudentDto;
import com.nassau.proavancada.dtos.student.UpdateStudentDto;
import com.nassau.proavancada.models.StudentModel;
import com.nassau.proavancada.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    StudentController (StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<StudentModel> listStudents (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String document
    ) {
        PageRequest pagination = PageRequest.of(page, limit);
        return this.studentService.listStudents(name, phone, address, document, pagination);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public StudentModel detailStudent (@PathVariable(value="id") String id) {
        return this.studentService.detailStudent(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentModel createStudent (@Valid @RequestBody CreateStudentDto student) {
        return this.studentService.createStudent(student);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PATCH)
    public StudentModel updateStudent (@PathVariable(value="id") String id, @Valid @RequestBody UpdateStudentDto studentDto) {
        return this.studentService.updateStudent(Integer.parseInt(id), studentDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public StudentModel deleteStudent (@PathVariable(value="id") String id) {
        return this.studentService.deleteStudent(Integer.parseInt(id));
    }
}
