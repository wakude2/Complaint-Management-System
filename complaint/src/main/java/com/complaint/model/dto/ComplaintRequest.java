package com.complaint.model.dto;

import java.util.List;

public class ComplaintRequest {
    private Long personId;
    private List<ComplaintRequestDto> complaintRequestDto;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List<ComplaintRequestDto> getComplaintRequestDtoList() {
        return complaintRequestDto;
    }

    public void setComplaintRequestDto(List<ComplaintRequestDto> complaintRequestDto) {
        this.complaintRequestDto = complaintRequestDto;
    }
}
