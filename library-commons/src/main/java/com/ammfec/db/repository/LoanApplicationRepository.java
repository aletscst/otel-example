package com.ammfec.db.repository;

import com.ammfec.db.model.LoanApplicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplicationModel, Integer> {
}
