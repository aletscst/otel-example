package com.ammfec.service;

import com.ammfec.dto.request.LoanApplicationRequest;
import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;

public interface LoanApplicationService {
    LoanApplicationsResponse getLoanApplications();

    LoanApplicationResponse getLoanApplication(Integer id);

    LoanApplicationResponse createLoanApplication(LoanApplicationRequest loanApplicationRequest);

    LoanApplicationResponse updateLoanApplication(Integer id, LoanApplicationRequest loanApplicationRequest);
}
