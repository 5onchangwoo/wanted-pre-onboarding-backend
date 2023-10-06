package com.preonboarding.backend.company.model.repository;

import com.preonboarding.backend.company.model.domain.entity.Company;
import com.preonboarding.backend.company.model.domain.vo.CompanyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, CompanyId> {
}
