package com.ammfec.controller;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;
import com.ammfec.service.LoanApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {
    @Autowired
    private LoanApplicationService loanApplicationService;

    @GetMapping
    public ResponseEntity<LoanApplicationsResponse> getLoanApplications() {
        log.info("getting loan applications");
        return ResponseEntity.ok(loanApplicationService.getLoanApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplicationResponse> getLoanApplicationById(@PathVariable Integer id) {
        log.info("getting loan application with id {}", id);
        return ResponseEntity.ok(loanApplicationService.getLoanApplication(id));
    }
}
