package dev.practice.preonboarding.infrastructures;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeTechStackMappingStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeTechStackMappingStoreImpl implements RecruitmentNoticeTechStackMappingStore {
	private final RecruitmentNoticeTechStackMappingRepository mappingRepository;

	@Override
	public List<RecruitmentNoticeTechStackMapping> saveAll(List<RecruitmentNoticeTechStackMapping> mappings) {
		return mappingRepository.saveAll(mappings);
	}
}
