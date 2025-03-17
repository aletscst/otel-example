package com.ammfec.controller;

import com.ammfec.dto.response.LoanApplicationResponse;
import com.ammfec.dto.response.LoanApplicationsResponse;
import com.ammfec.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/loans")
public class LoansController {
    @Autowired
    private LoanService loanService;

    @GetMapping("/applications")
    public ResponseEntity<LoanApplicationsResponse> getAllLoanApplications() {
        log.info("getAllLoanApplications from library controller");
        return ResponseEntity.ok(loanService.getAllLoanApplications());
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<LoanApplicationResponse> getLoanApplication(@PathVariable Integer id) {
        log.info("getLoanApplication from library controller");
        return ResponseEntity.ok(loanService.getLoanApplication(id));
    }
}
