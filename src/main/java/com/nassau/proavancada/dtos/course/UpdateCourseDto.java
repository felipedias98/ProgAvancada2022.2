package com.nassau.proavancada.dtos.course;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateCourseDto {
    @Size(min = 1, max = 45, message = "Course name must be 1 to 45 characters")
    private String name;

    private Float attendance = Float.valueOf(0);

    private Float attendanceTotal;

    @Size(min = 1, max = 20, message = "Course shift must be 1 to 20 characters")
    private String shift;

    private Float value;

    @Size(max = 7, message = "Class days must be 1 to 7 days of week")
    private String[] days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public Float getAttendanceTotal() {
        return attendanceTotal;
    }

    public void setAttendanceTotal(float attendanceTotal) {
        this.attendanceTotal = attendanceTotal;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String[] getDays() {
        return days;
    }

    public void setDays(String[] days) {
        this.days = days;
    }
}
