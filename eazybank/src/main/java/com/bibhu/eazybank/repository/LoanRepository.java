package com.bibhu.eazybank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.bibhu.eazybank.model.Loans;

@Repository
public interface LoanRepository extends JpaRepository<Loans, Long> {

    @PreAuthorize("hasRole('ROOT')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
