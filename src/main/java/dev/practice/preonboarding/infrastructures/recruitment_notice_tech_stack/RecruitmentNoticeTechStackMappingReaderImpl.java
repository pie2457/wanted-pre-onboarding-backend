package dev.practice.preonboarding.infrastructures.recruitment_notice_tech_stack;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeTechStackMappingReaderImpl implements RecruitmentNoticeTechStackMappingReader {
	private final RecruitmentNoticeTechStackMappingRepository mappingRepository;

	@Override
	public List<RecruitmentNoticeTechStackMapping> findByRecruitmentNoticeId(Long recruitmentNoticeId) {
		return mappingRepository.findByMappingId_RecruitmentNoticeId(recruitmentNoticeId);
	}

	@Override
	public List<RecruitmentNoticeTechStackMapping> findAll() {
		return mappingRepository.findAll();
	}
}
