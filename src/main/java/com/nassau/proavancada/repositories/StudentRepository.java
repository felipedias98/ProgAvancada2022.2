package com.nassau.proavancada.repositories;

import com.nassau.proavancada.models.StudentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
    @Query("SELECT s FROM StudentModel s WHERE " +
            "(?1 IS NULL OR s.name LIKE %?1%) AND " +
            "(?2 IS NULL OR s.phone LIKE %?2%) AND " +
            "(?3 IS NULL OR s.address LIKE %?3%) AND " +
            "(?4 IS NULL OR s.document = ?4)")
    Page<StudentModel> findAllFiltered(
            String name,
            String phone,
            String address,
            String document,
            PageRequest pagination
    );
}
