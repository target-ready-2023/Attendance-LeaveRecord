package com.example.AMS.service;

import com.example.AMS.Entities.LeaveEntity;

import java.util.List;

public interface LeaveService {
    List<LeaveEntity> getLeavesByStudentId(int studentId);

    List<LeaveEntity> getAllLeaves();
    LeaveEntity getLeaveById(Long id);
    LeaveEntity createLeave(LeaveEntity leave);
    LeaveEntity updateLeave(long id, LeaveEntity leave);
    void deleteLeave(long id);
}
