package com.nassau.proavancada.services;

import com.nassau.proavancada.dtos.course.CreateCourseDto;
import com.nassau.proavancada.dtos.course.UpdateCourseDto;
import com.nassau.proavancada.repositories.CourseRepository;
import com.nassau.proavancada.models.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Page<CourseModel> listCourses (String name, Float attendance, Float attendanceTotal, Float value, String shift, String incomingDays, PageRequest pagination) {
        CourseModel course = new CourseModel();

        if (incomingDays != null) {
            course.setDays(incomingDays.split(","));
        }

        return this.courseRepository.findAllFiltered(
                name,
                attendance,
                attendanceTotal,
                value,
                shift,
                course.isSun() ? true : null,
                course.isMon() ? true : null,
                course.isTues() ? true : null,
                course.isWed() ? true : null,
                course.isThurs() ? true : null,
                course.isFri() ? true : null,
                course.isSat() ? true : null,
                pagination
        );


    }

    public CourseModel detailCourse (int id) {
        Optional<CourseModel> course = this.courseRepository.findById(id);

        if (course.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return course.get();
    }

    public CourseModel createCourse (CreateCourseDto createCourseDto) {
        CourseModel course = new CourseModel(
                createCourseDto.getName(),
                createCourseDto.getAttendance(),
                createCourseDto.getAttendanceTotal(),
                createCourseDto.getShift(),
                createCourseDto.getValue()
        );

        course.setDays(createCourseDto.getDays());
        return this.courseRepository.save(course);
    }

    public CourseModel updateCouse (int id, UpdateCourseDto updateCourseDto) {
        CourseModel course = this.detailCourse(id);

        if (updateCourseDto.getName() != null) course.setName(updateCourseDto.getName());
        if (updateCourseDto.getAttendance() != null) course.setAttendance(updateCourseDto.getAttendance());
        if (updateCourseDto.getAttendanceTotal() != null) course.setAttendanceTotal(updateCourseDto.getAttendanceTotal());
        if (updateCourseDto.getValue() != null) course.setValue(updateCourseDto.getValue());
        if (updateCourseDto.getShift() != null) course.setShift(updateCourseDto.getShift());

        if (updateCourseDto.getDays() != null) {
            course.resetDays();
            course.setDays(updateCourseDto.getDays());
        }

        return this.courseRepository.save(course);
    }

    public CourseModel deleteCourse (int id) {
        CourseModel course = this.detailCourse(id);
        this.courseRepository.deleteById(course.getCourseId());

        return course;
    }
}
