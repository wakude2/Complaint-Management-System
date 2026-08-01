package com.complaint.controller;

import com.complaint.model.dto.ComplaintDto;
import com.complaint.model.dto.ComplaintRequest;
import com.complaint.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
