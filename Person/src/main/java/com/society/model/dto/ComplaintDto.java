package com.society.model.dto;


import com.society.model.enums.Priority;
import com.society.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class ComplaintDto {

    private Long id;
    private Long personId;
    private String street;
    private Long pinCode;
    private String city;
    private String state;
    private String country;
    private String issue;
    @Column(length = 1000)
    private String description;
    private String department;
    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.MEDIUM;
    private LocalDateTime submittedOn = LocalDateTime.now();
    private LocalDateTime resolvedOn;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;
    private Double latitude;
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public LocalDateTime getResolvedOn() {
        return resolvedOn;
    }

    public void setResolvedOn(LocalDateTime resolvedOn) {
        this.resolvedOn = resolvedOn;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public ComplaintDto() {

    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", personId=" + personId +
                ", street='" + street + '\'' +
                ", pinCode=" + pinCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", issue='" + issue + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                ", priority=" + priority +
                ", submittedOn=" + submittedOn +
                ", resolvedOn=" + resolvedOn +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public ComplaintDto(Long id, Long personId, String street, Long pinCode, String city, String state, String country, String issue, String description, String department, Priority priority, LocalDateTime submittedOn, LocalDateTime resolvedOn, String imageUrl, Status status, Double latitude, Double longitude) {
        this.id = id;
        this.personId = personId;
        this.street = street;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.issue = issue;
        this.description = description;
        this.department = department;
        this.priority = priority;
        this.submittedOn = submittedOn;
        this.resolvedOn = resolvedOn;
        this.imageUrl = imageUrl;
        this.status = status;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
