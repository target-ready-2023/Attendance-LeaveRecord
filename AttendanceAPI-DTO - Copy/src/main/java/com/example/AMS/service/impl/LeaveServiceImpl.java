package com.example.AMS.service.impl;

import com.example.AMS.Entities.LeaveEntity;
import com.example.AMS.repository.LeaveRepository;
import com.example.AMS.service.AttendanceService;
import com.example.AMS.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    @Qualifier("attendanceServiceImpl")
    private AttendanceService attendanceService;

    @Override
    public List<LeaveEntity> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public LeaveEntity getLeaveById(Long id) {
        Optional<LeaveEntity> leave = leaveRepository.findById(id);
        return leave.orElse(null);
    }

    @Override
    public LeaveEntity createLeave(LeaveEntity leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public LeaveEntity updateLeave(long id, LeaveEntity leave) {
        if (leaveRepository.existsById(id)) {
            leave.setLeaveId(id);
            return leaveRepository.save(leave);
        }
        return null;
    }

    @Override
    public List<LeaveEntity> getLeavesByStudentId(int studentId){
        return leaveRepository.findByStudentId(studentId);
    }
    @Override
    public void deleteLeave(long id) {
        leaveRepository.deleteById(id);
    }
}
