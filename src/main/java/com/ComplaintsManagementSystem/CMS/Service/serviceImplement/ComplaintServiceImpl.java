package com.ComplaintsManagementSystem.CMS.Service.serviceImplement;

import com.ComplaintsManagementSystem.CMS.Model.Complaint;
import com.ComplaintsManagementSystem.CMS.Model.Employee;
import com.ComplaintsManagementSystem.CMS.Repository.ComplainRepository;
import com.ComplaintsManagementSystem.CMS.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private  ComplainRepository complainRepository;

    @Override
    public List<Complaint> findAllComplaints() {
        return complainRepository.findAll();
    }

    @Override
    public Complaint findComplaintById(long id) {
        Optional<Complaint> complain = complainRepository.findById(id);
        if(complain.isPresent()) {
            return complain.get();
        }
        return null;
    }

    @Override
    public Complaint fileComplain(Complaint complaint) {
        return complainRepository.save(complaint);

    }

    @Override
    public Complaint updateComplain(Complaint complaint) {
        Optional<Complaint> complainDb = complainRepository.findById(complaint.getComplaintId());
        if(complainDb.isPresent()) {
            Complaint cmp = complainDb.get();
            cmp.setComplaintId(complaint.getComplaintId());
            cmp.setComplainerName(complaint.getComplainerName());
            cmp.setComplainDescription(complaint.getComplainDescription());
            cmp.setComplainType(complaint.getComplainType());
            cmp.setComplainStatus(complaint.getComplainStatus());
            return complainRepository.save(cmp);
        }
        return null;
    }

    @Override
    public boolean deleteComplain(long id) {
        return false;
    }
}
