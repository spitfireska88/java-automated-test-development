package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Branch;

import java.util.Collection;

public interface BranchRepository {
    Collection<Branch> getBranches();
}
