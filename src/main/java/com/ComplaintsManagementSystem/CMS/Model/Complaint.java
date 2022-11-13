package com.ComplaintsManagementSystem.CMS.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@Entity
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long complaintId;

    private String complainerName;

    private String complainType;

    private String complainDescription;

    private Boolean complainStatus;

    public Complaint() {
    }

    public Complaint(String complainerName, String complainType, String complainDescription, Boolean complainStatus) {
        this.complainerName = complainerName;
        this.complainType = complainType;
        this.complainDescription = complainDescription;
        this.complainStatus = complainStatus;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplainerName() {
        return complainerName;
    }

    public void setComplainerName(String complainerName) {
        this.complainerName = complainerName;
    }

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
    }

    public String getComplainDescription() {
        return complainDescription;
    }

    public void setComplainDescription(String complainDescription) {
        this.complainDescription = complainDescription;
    }

    public Boolean getComplainStatus() {
        return complainStatus;
    }

    public void setComplainStatus(Boolean complainStatus) {
        this.complainStatus = complainStatus;
    }
}

