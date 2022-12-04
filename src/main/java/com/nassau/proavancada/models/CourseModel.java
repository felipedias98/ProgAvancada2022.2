package com.nassau.proavancada.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(length = 45)
    private String name;

    @Column()
    private float attendance;

    @Column()
    private float attendanceTotal;

    @Column(length = 20)
    private String shift;

    @Column()
    private float value;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean sun;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean mon;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean tues;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean wed;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean thurs;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean fri;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column()
    @ColumnDefault("0")
    private boolean sat;

    public CourseModel() {}

    public CourseModel(String name, float attendance, float attendanceTotal, String shift, float value) {
        this.name = name;
        this.attendance = attendance;
        this.attendanceTotal = attendanceTotal;
        this.shift = shift;
        this.value = value;
    }

    public CourseModel(int courseId, String name, float attendance, float attendanceTotal, String shift, float value, boolean sun, boolean mon, boolean tues, boolean wed, boolean thurs, boolean fri, boolean sat) {
        this.courseId = courseId;
        this.name = name;
        this.attendance = attendance;
        this.attendanceTotal = attendanceTotal;
        this.shift = shift;
        this.value = value;
        this.sun = sun;
        this.mon = mon;
        this.tues = tues;
        this.wed = wed;
        this.thurs = thurs;
        this.fri = fri;
        this.sat = sat;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public float getAttendanceTotal() {
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void resetDays () {
        this.setSun(false);
        this.setMon(false);
        this.setTues(false);
        this.setWed(false);
        this.setThurs(false);
        this.setFri(false);
        this.setSat(false);
    }

    public void setDays(String[] days) {
        for (int i = 0; i < days.length; i++) {
            switch (days[i].toLowerCase()) {
                case "sunday":
                case "sun": {
                    this.setSun(true);
                    break;
                }
                case "monday":
                case "mon": {
                    this.setMon(true);
                    break;
                }
                case "tuesday":
                case "tue":
                case "tues": {
                    this.setTues(true);
                    break;
                }
                case "wednesday":
                case "wed": {
                    this.setWed(true);
                    break;
                }
                case "thursday":
                case "thu":
                case "thurs": {
                    this.setThurs(true);
                    break;
                }
                case "friday":
                case "fri": {
                    this.setFri(true);
                    break;
                }
                case "saturday":
                case "sat": {
                    this.setSat(true);
                    break;
                }
            }
        }
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTues() {
        return tues;
    }

    public void setTues(boolean tues) {
        this.tues = tues;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThurs() {
        return thurs;
    }

    public void setThurs(boolean thurs) {
        this.thurs = thurs;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }
}
