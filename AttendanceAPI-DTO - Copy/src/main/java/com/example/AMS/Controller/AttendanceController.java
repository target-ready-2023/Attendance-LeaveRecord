package com.example.AMS.Controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.AMS.Entities.AttendanceEntity;
import com.example.AMS.dto.request.AttendanceRequest;
import com.example.AMS.dto.request.AttendanceUpdateRequest;

import com.example.AMS.dto.response.AttendanceResponse;
import com.example.AMS.service.AttendanceService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/attendance")
public class AttendanceController  implements AttendanceService{
    private final AttendanceService attendanceService;


    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }


    @GetMapping("/")
    public List<AttendanceResponse> findAllAttendance()
    {
        return attendanceService.findAllAttendance();
    }

    @GetMapping("/{id}")
    public Optional<AttendanceEntity> findById(@PathVariable("id") Long id) {
        return attendanceService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable("id") Long id) {
        attendanceService.deleteAttendance(id);
    }

    @PostMapping()
    public AttendanceResponse saveAttendance(@RequestBody AttendanceRequest attendanceRequest) {
        return attendanceService.saveAttendance(attendanceRequest);

    }
    @PutMapping("/{id}")
    public AttendanceResponse updateAttendance(@RequestBody AttendanceRequest attendanceRequest, @PathVariable Long id) {
        return attendanceService.updateAttendance(attendanceRequest, id);
    }
    @PostMapping("/")
    @Override
    public List<AttendanceResponse> saveAllAttendance(@RequestBody List<AttendanceRequest> attendanceRequestList) {
        return attendanceService.saveAllAttendance(attendanceRequestList);
    }
    @PutMapping("/")
    @Override
    public List<AttendanceResponse> updateAllAttendance(@RequestBody List<AttendanceUpdateRequest> attendanceUpdateRequestList) {
        return attendanceService.updateAllAttendance(attendanceUpdateRequestList);
    }

    @GetMapping("/students/by-id-DateRange")
    public List<AttendanceResponse> getBystudentidindaterange(@RequestParam int studentId, @RequestParam LocalDate startdate, @RequestParam LocalDate enddate){
        return attendanceService.getBystudentidindaterange(studentId, startdate, enddate);
    }

    @GetMapping("/class/by-id-DateRange")
    public List<AttendanceResponse> getByclassIDindaterange(@RequestParam String classId, @RequestParam LocalDate startdate, @RequestParam LocalDate enddate) {
        return attendanceService.getByclassIDindaterange(classId, startdate, enddate);
    }

    @GetMapping("/update")
    @Override
    public List<AttendanceResponse> getByclassIDanddate(@RequestParam String classId, @RequestParam LocalDate date) {
        return attendanceService.getByclassIDanddate(classId,date);
    }

}