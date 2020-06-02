package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Branch;
import com.acme.banking.dbo.service.Reporting;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportingTest {
    @Test
    public void shouldGetZeroReportWhenBranchAndClientEmpty() {
        BranchRepository branchRepositoryStub = mock(BranchRepository.class);
        Branch branchStub = mock(Branch.class);
        when(branchStub.getClients()).thenReturn(Collections.emptySet());
        when(branchRepositoryStub.getBranches()).thenReturn(Arrays.asList(branchStub));

        Reporting reportingSut = new Reporting(branchRepositoryStub);

        final String report = reportingSut.getReport();

        assertThat(report)
                .contains("# TEST BRANCH")
                .contains("## [empty]");
    }
}
