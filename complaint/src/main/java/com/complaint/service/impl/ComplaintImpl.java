package com.complaint.service.impl;

import com.complaint.exception.ResourceNotFoundException;
import com.complaint.model.dto.ComplaintDto;
import com.complaint.model.dto.ComplaintRequest;
import com.complaint.model.dto.ComplaintRequestDto;
import com.complaint.model.entity.Complaint;
import com.complaint.repository.ComplaintRepository;
import com.complaint.service.ComplaintService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ComplaintImpl implements ComplaintService {
    Logger log= LoggerFactory.getLogger(ComplaintImpl.class);
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
//        List<Complaint> listToSave = new ArrayList<>();
//
//        for (ComplaintRequestDto complaintRequestDto : complaintRequest.getComplaintRequestDtoList()) {
//            Complaint complaint = new Complaint();
//
//            complaint.setStreet(complaintRequestDto.getStreet());
//            complaint.setPinCode(complaintRequestDto.getPinCode());
//            complaint.setCity(complaintRequestDto.getCity());
//            complaint.setState(complaintRequestDto.getState());
//            complaint.setCountry(complaintRequestDto.getCountry());
//            complaint.setIssue(complaintRequestDto.getIssue());
//            complaint.setDescription(complaintRequestDto.getDescription());
//            complaint.setDepartment(complaintRequestDto.getDepartment());
//            complaint.setPriority(complaintRequestDto.getPriority());
//            complaint.setSubmittedOn(complaintRequestDto.getSubmittedOn());
//            complaint.setResolvedOn(complaintRequestDto.getResolvedOn());
//            complaint.setImageUrl(complaintRequestDto.getImageUrl());
//            complaint.setStatus(complaintRequestDto.getStatus());
//            complaint.setLatitude(complaintRequestDto.getLatitude());
//            complaint.setLongitude(complaintRequestDto.getLongitude());
//            complaint.setPersonId(complaintRequest.getPersonId());
//
//            listToSave.add(complaint);
//
//        }
        List<Complaint> listToSave= this.saveOrUpdateComplaintRequest(complaintRequest);
        List<Complaint> savedComplaints = complaintRepository.saveAll(listToSave);
        return savedComplaints.stream().map(complaint -> modelMapper.map(complaint,ComplaintDto.class)).toList();
    }

    @Override
    public List<ComplaintDto>  updateComplaint(ComplaintRequest complaintRequest) {
        //TODO : check if person exists
        List<Complaint> complaintByPersonId = complaintRepository.findAllByPersonId(complaintRequest.getPersonId());
        if (complaintByPersonId.isEmpty()){
            log.info("No Complaint found for this person {}",complaintRequest.getPersonId());
            log.info("Creating new complaint for this person {}",complaintRequest.getPersonId());

        }
        List<Complaint> listToUpdate= this.saveOrUpdateComplaintRequest(complaintRequest);
        List<Long> upcomingNonNullIds = listToUpdate.stream().map(Complaint::getId).filter(Objects::nonNull).toList();
        List<Long> existingIds = complaintByPersonId.stream().map(Complaint::getId).toList();
        List<Long> idsToDelete = existingIds.stream().filter(id-> !upcomingNonNullIds.contains(id)).toList();
        if (!idsToDelete.isEmpty()){
            complaintRepository.deleteAllById(idsToDelete);
        }
       List<Complaint> updatedComplaints= complaintRepository.saveAll(listToUpdate);
        return updatedComplaints.stream().map(complaint -> modelMapper.map(complaint, ComplaintDto.class)).toList();
    }

    @Override
    public ComplaintDto getSingleComplaint(Long id) {
        Complaint complaint= complaintRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Complaint not found with id: "+id));

        return modelMapper.map(complaint, ComplaintDto.class);
    }

    @Override
    public List<ComplaintDto> getAllComplaints() {

        List<Complaint> all = complaintRepository.findAll();
        if(all.isEmpty()){
            throw new ResourceNotFoundException("No Complaint found");
        }
        return all.stream().map(complaint -> modelMapper.map(complaint, ComplaintDto.class)).toList();
    }

    @Override
    public void deleteComplaint(Long id) {
        Complaint complaint= complaintRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Complaint not found with id: "+id));
        complaintRepository.delete(complaint);

    }
    private List<Complaint> saveOrUpdateComplaintRequest(ComplaintRequest complaintRequest){
        List<Complaint> listToSave = new ArrayList<>();

        for (ComplaintRequestDto complaintRequestDto : complaintRequest.getComplaintRequestDtoList()) {
            Complaint complaint = new Complaint();
            complaint.setId(complaintRequestDto.getId() != null ? complaintRequestDto.getId() : null);
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
        return listToSave;

    }
}
