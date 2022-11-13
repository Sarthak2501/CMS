package com.ComplaintsManagementSystem.CMS.Repository;

import com.ComplaintsManagementSystem.CMS.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComplainRepository extends JpaRepository<Complaint,Long> {

}
