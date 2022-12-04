package com.nassau.proavancada.services;

import com.nassau.proavancada.dtos.student.CreateStudentDto;
import com.nassau.proavancada.dtos.student.UpdateStudentDto;
import com.nassau.proavancada.models.StudentModel;
import com.nassau.proavancada.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Page<StudentModel> listStudents (
            String name,
            String phone,
            String address,
            String document,
            PageRequest pagination
    ) {
        return this.studentRepository.findAllFiltered(name, phone, address, document, pagination);
    }
    public StudentModel detailStudent (int id) {
        Optional<StudentModel> student = this.studentRepository.findById(id);

        if (student.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return student.get();
    }

    public StudentModel createStudent (CreateStudentDto studentDto) {
        StudentModel student = new StudentModel(
                studentDto.getName(),
                studentDto.getPhone(),
                studentDto.getAddress(),
                studentDto.getDocument()
        );

        return this.studentRepository.save(student);
    }

    public StudentModel updateStudent (int id, UpdateStudentDto studentDto) {
        StudentModel student = this.detailStudent(id);

        if (studentDto.getName() != null) student.setName(studentDto.getName());
        if (studentDto.getPhone() != null) student.setPhone(studentDto.getPhone());
        if (studentDto.getAddress() != null) student.setAddress(studentDto.getAddress());
        if (studentDto.getDocument() != null) student.setDocument(studentDto.getDocument());

        return this.studentRepository.save(student);
    }

    public StudentModel deleteStudent (int id) {
        StudentModel student = this.detailStudent(id);
        this.studentRepository.deleteById(id);

        return student;
    }
}
