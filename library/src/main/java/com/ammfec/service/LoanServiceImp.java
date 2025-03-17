package com.ammfec.service;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class LoanServiceImp implements LoanService {
    RestTemplate restTemplate = new RestTemplate();

    @Value("${library.loans.url-base}")
    private String baseUrl;

    @Override
    public LoanApplicationsResponse getAllLoanApplications() {
        log.info("called getAllLoanApplications to loan service {}", baseUrl);
        ResponseEntity<LoanApplicationsResponse> response = restTemplate.getForEntity( baseUrl + "/loan-applications", LoanApplicationsResponse.class);
        return response.getBody();
    }

    @Override
    public LoanApplicationResponse getLoanApplication(Integer id) {
        log.info("called getLoanApplication to loan service {}", baseUrl);
        ResponseEntity<LoanApplicationResponse> response = restTemplate.getForEntity( baseUrl + "/loan-applications/" + id, LoanApplicationResponse.class);
        return response.getBody();
    }
}
