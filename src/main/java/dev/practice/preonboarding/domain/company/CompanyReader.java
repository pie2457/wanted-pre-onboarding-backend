package dev.practice.preonboarding.domain.company;

import java.util.List;

public interface CompanyReader {

	List<Company> findAllByIdIn(List<Long> companyIds);
}
