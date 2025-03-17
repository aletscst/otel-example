package com.ammfec.service;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;

public interface LoanService {
    LoanApplicationsResponse getAllLoanApplications();

    LoanApplicationResponse getLoanApplication(Integer id);
}
