package com.ComplaintsManagementSystem.CMS.Service;

import com.ComplaintsManagementSystem.CMS.Model.Complaint;
import com.ComplaintsManagementSystem.CMS.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComplaintService {

    List<Complaint> findAllComplaints();

    Complaint findComplaintById(long id);

    Complaint fileComplain(Complaint complaint);

    Complaint updateComplain(Complaint complaint);

    boolean deleteComplain(long id);

}
