package dev.practice.preonboarding.domain.recruitment_notice_tech_stack;

import java.util.List;

public interface RecruitmentNoticeTechStackMappingStore {

	List<RecruitmentNoticeTechStackMapping> saveAll(List<RecruitmentNoticeTechStackMapping> mapping);
}
