package dev.practice.preonboarding.domain.recruitment_notice_tech_stack;

import java.util.List;

public interface RecruitmentNoticeTechStackMappingReader {

	List<RecruitmentNoticeTechStackMapping> findByRecruitmentNoticeId(Long recruitmentNoticeId);

	List<RecruitmentNoticeTechStackMapping> findAll();
}
