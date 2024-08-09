package dev.practice.preonboarding.infrastructures.recruitment_notice;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.common.exception.EntityNotFoundException;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeReaderImpl implements RecruitmentNoticeReader {
	private final RecruitmentNoticeRepository recruitmentNoticeRepository;

	@Override
	public RecruitmentNotice findById(Long recruitmentId) {
		return recruitmentNoticeRepository.findById(recruitmentId)
			.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public boolean existsByRecruitmentId(Long recruitmentId) {
		return recruitmentNoticeRepository.existsById(recruitmentId);
	}

	@Override
	public List<RecruitmentNotice> findAll() {
		return recruitmentNoticeRepository.findAll();
	}

	@Override
	public List<RecruitmentNotice> findAllByCompanyId(Long companyId) {
		return recruitmentNoticeRepository.findByCompanyId(companyId);
	}
}
