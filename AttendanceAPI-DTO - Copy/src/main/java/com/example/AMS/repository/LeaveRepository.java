package com.example.AMS.repository;

import com.example.AMS.Entities.LeaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, Long>
{
    List<LeaveEntity> findByStudentId(int studentId);
    // You can add custom query methods if needed
}
