package com.nassau.proavancada.repositories;

import com.nassau.proavancada.models.CourseModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<CourseModel, Integer> {
    @Query("SELECT c FROM CourseModel c WHERE " +
            "(?1 IS NULL OR c.name LIKE %?1%) AND " +
            "(?2 IS NULL OR c.attendance = ?2) AND " +
            "(?3 IS NULL OR c.attendanceTotal = ?3) AND " +
            "(?4 IS NULL OR c.value = ?4) AND " +
            "(?5 IS NULL OR c.shift LIKE %?5%) AND " +
            "(?6 IS NULL OR c.sun = 1) AND " +
            "(?7 IS NULL OR c.mon = 1) AND " +
            "(?8 IS NULL OR c.tues = 1) AND " +
            "(?9 IS NULL OR c.wed = 1) AND " +
            "(?10 IS NULL OR c.thurs = 1) AND " +
            "(?11 IS NULL OR c.fri = 1) AND " +
            "(?11 IS NULL OR c.sat = 1)")
    Page<CourseModel> findAllFiltered(
            String name,
            Float attendance,
            Float attendanceTotal,
            Float value,
            String shift,
            Boolean sun,
            Boolean mon,
            Boolean tues,
            Boolean wed,
            Boolean thurs,
            Boolean fri,
            Boolean sat,
            PageRequest pagination
    );
}
