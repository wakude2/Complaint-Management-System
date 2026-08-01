package com.complaint.service;

import com.complaint.model.dto.ComplaintDto;
import com.complaint.model.dto.ComplaintRequest;

import java.util.List;

public interface ComplaintService {

    List<ComplaintDto> saveComplaint(ComplaintRequest complaintRequest);

    ComplaintDto updateComplaint(ComplaintRequest complaintRequest);

    ComplaintDto getSingleComplaint(Long id);

    List<ComplaintDto> getAllComplaints();

    void deleteComplaint(Long id);
}
