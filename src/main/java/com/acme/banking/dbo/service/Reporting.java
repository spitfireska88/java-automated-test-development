package com.acme.banking.dbo.service;

import com.acme.banking.dbo.BranchRepository;
import com.acme.banking.dbo.domain.Branch;

public class Reporting {
    private BranchRepository branchRepository;

    public Reporting(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    /**
     * @return Markdown report for all branches, clients, accounts
     */
    public String getReport() {
        return null;
    }
}
