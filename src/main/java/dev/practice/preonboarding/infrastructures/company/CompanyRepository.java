package dev.practice.preonboarding.infrastructures.company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.preonboarding.domain.company.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	List<Company> findByIdIn(List<Long> companyIds);
}
