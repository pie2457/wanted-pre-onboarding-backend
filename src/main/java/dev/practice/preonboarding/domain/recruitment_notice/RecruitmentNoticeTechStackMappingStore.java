package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

public interface RecruitmentNoticeTechStackMappingStore {

	List<RecruitmentNoticeTechStackMapping> saveAll(List<RecruitmentNoticeTechStackMapping> mapping);
}
