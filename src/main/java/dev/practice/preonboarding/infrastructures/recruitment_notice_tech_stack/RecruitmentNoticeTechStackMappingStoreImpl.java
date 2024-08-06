package dev.practice.preonboarding.infrastructures.recruitment_notice_tech_stack;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeTechStackMappingStoreImpl implements RecruitmentNoticeTechStackMappingStore {
	private final RecruitmentNoticeTechStackMappingRepository mappingRepository;

	@Override
	public List<RecruitmentNoticeTechStackMapping> saveAll(List<RecruitmentNoticeTechStackMapping> mappings) {
		return mappingRepository.saveAll(mappings);
	}

	@Override
	public void deleteAllByRecruitmentNoticeId(Long recruitmentNoticeId) {
		mappingRepository.deleteAllByRecruitmentNoticeId(recruitmentNoticeId);
	}
}
