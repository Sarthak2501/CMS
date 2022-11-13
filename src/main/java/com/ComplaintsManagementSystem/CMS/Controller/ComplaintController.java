package com.ComplaintsManagementSystem.CMS.Controller;

import com.ComplaintsManagementSystem.CMS.Model.Complaint;
import com.ComplaintsManagementSystem.CMS.Model.Employee;
import com.ComplaintsManagementSystem.CMS.Service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/complaints")
public class ComplaintController {

    @Autowired
    private final ComplaintService complaintService;


    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

//
//    public ComplaintController(ComplaintService complaintService) {
//        this.complaintService = complaintService;
//    }

    @GetMapping("")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok().body(complaintService.findAllComplaints());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Complaint> getComplaintById(@PathVariable long id) {
        return ResponseEntity.ok().body(complaintService.findComplaintById(id));
    }

    @PostMapping("")
    public ResponseEntity <Complaint> sendComplain(@RequestBody Complaint complaint) {
        return ResponseEntity.ok().body(complaintService.fileComplain(complaint));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Complaint> updateComplain(@PathVariable long id, @RequestBody Complaint complaint) {
        complaint.setComplaintId(id);
        return ResponseEntity.ok().body(complaintService.updateComplain(complaint));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        boolean isDeleted = complaintService.deleteComplain(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}


