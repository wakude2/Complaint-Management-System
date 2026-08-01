package com.complaint.controller;

import com.complaint.model.dto.ComplaintDto;
import com.complaint.model.dto.ComplaintRequest;
import com.complaint.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService){
        this.complaintService=complaintService;
    }
    @PostMapping("/save")
    public ResponseEntity<List<ComplaintDto>> saveComplaint(@RequestBody ComplaintRequest complaintDto){
        List<ComplaintDto> response = complaintService.saveComplaint(complaintDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<List<ComplaintDto>> updateComplaint(@RequestBody ComplaintRequest complaintDto){
        List<ComplaintDto> response = complaintService.updateComplaint(complaintDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-complaints")
    public ResponseEntity<List<ComplaintDto>> getAllComplaints(){
        List<ComplaintDto> response = complaintService.getAllComplaints();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/{complaintId}")
    public ResponseEntity<ComplaintDto> getSingleComplaint(@PathVariable Long complaintId){
        ComplaintDto response = complaintService.getSingleComplaint(complaintId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{complaintId}")
    public ResponseEntity<String> deleteComplaint(@PathVariable Long complaintId){
        complaintService.deleteComplaint(complaintId);
        return new ResponseEntity<>("Complaint deleted Successfully",HttpStatus.OK);
    }
}
