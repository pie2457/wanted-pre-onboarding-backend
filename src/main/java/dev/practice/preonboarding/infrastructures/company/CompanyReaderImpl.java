package dev.practice.preonboarding.infrastructures.company;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.common.exception.EntityNotFoundException;
import dev.practice.preonboarding.domain.company.Company;
import dev.practice.preonboarding.domain.company.CompanyReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CompanyReaderImpl implements CompanyReader {
	private final CompanyRepository companyRepository;

	@Override
	public List<Company> findAllByIdIn(List<Long> companyIds) {
		return companyRepository.findByIdIn(companyIds);
	}

	@Override
	public Company findById(Long companyId) {
		return companyRepository.findById(companyId)
			.orElseThrow(EntityNotFoundException::new);
	}
}
