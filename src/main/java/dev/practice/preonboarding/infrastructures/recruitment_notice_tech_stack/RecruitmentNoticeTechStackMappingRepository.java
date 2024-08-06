package dev.practice.preonboarding.infrastructures.recruitment_notice_tech_stack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;

public interface RecruitmentNoticeTechStackMappingRepository
	extends JpaRepository<RecruitmentNoticeTechStackMapping, Long> {

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from RecruitmentNoticeTechStackMapping mapping "
		+ "where mapping.mappingId.recruitmentNoticeId = :recruitmentNoticeId")
	void deleteAllByRecruitmentNoticeId(Long recruitmentNoticeId);
}
