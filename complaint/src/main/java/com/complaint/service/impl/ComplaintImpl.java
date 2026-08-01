package com.complaint.service.impl;

import com.complaint.model.dto.ComplaintDto;
import com.complaint.model.dto.ComplaintRequest;
import com.complaint.model.dto.ComplaintRequestDto;
import com.complaint.model.entity.Complaint;
import com.complaint.repository.ComplaintRepository;
import com.complaint.service.ComplaintService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplaintImpl implements ComplaintService {
    private  final ComplaintRepository complaintRepository;
    private final ModelMapper modelMapper;

    public ComplaintImpl(ComplaintRepository complaintRepository,
                         ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.complaintRepository = complaintRepository;
    }

    @Override
    public List<ComplaintDto> saveComplaint(ComplaintRequest complaintRequest) {

        //TODO : check if person exists

        List<Complaint> listToSave = new ArrayList<>();

        for (ComplaintRequestDto complaintRequestDto : complaintRequest.getComplaintRequestDtoList()) {
            Complaint complaint = new Complaint();

            complaint.setStreet(complaintRequestDto.getStreet());
            complaint.setPinCode(complaintRequestDto.getPinCode());
            complaint.setCity(complaintRequestDto.getCity());
            complaint.setState(complaintRequestDto.getState());
            complaint.setCountry(complaintRequestDto.getCountry());
            complaint.setIssue(complaintRequestDto.getIssue());
            complaint.setDescription(complaintRequestDto.getDescription());
            complaint.setDepartment(complaintRequestDto.getDepartment());
            complaint.setPriority(complaintRequestDto.getPriority());
            complaint.setSubmittedOn(complaintRequestDto.getSubmittedOn());
            complaint.setResolvedOn(complaintRequestDto.getResolvedOn());
            complaint.setImageUrl(complaintRequestDto.getImageUrl());
            complaint.setStatus(complaintRequestDto.getStatus());
            complaint.setLatitude(complaintRequestDto.getLatitude());
            complaint.setLongitude(complaintRequestDto.getLongitude());
            complaint.setPersonId(complaintRequest.getPersonId());

            listToSave.add(complaint);

        }
        List<Complaint> savedComplaints = complaintRepository.saveAll(listToSave);
        return savedComplaints.stream().map(complaint -> modelMapper.map(complaint,ComplaintDto.class)).toList();
    }

    @Override
    public ComplaintDto updateComplaint(ComplaintRequest complaintDtoRequest) {
        return null;
    }

    @Override
    public ComplaintDto getSingleComplaint(Long id) {
        return null;
    }

    @Override
    public List<ComplaintDto> getAllComplaints() {
        return List.of();
    }

    @Override
    public void deleteComplaint(Long id) {

    }
}
