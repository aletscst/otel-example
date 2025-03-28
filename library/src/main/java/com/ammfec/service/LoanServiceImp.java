package com.ammfec.service;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;
import com.ammfec.web_client.LoanClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanServiceImp implements LoanService {

    @Autowired
    private LoanClient loanClient;

    @Override
    public LoanApplicationsResponse getAllLoanApplications() {
        log.info("called getAllLoanApplications to loan service");
        ResponseEntity<LoanApplicationsResponse> response = loanClient.getLoanApplications();
        return response.getBody();
    }

    @Override
    public LoanApplicationResponse getLoanApplication(Integer id) {
        log.info("called getLoanApplication to loan service");
        ResponseEntity<LoanApplicationResponse> response = loanClient.getLoanApplication(id);
        return response.getBody();
    }
}
