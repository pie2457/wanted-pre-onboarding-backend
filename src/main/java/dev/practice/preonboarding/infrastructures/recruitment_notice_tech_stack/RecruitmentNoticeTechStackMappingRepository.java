package dev.practice.preonboarding.infrastructures.recruitment_notice_tech_stack;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;

public interface RecruitmentNoticeTechStackMappingRepository
	extends JpaRepository<RecruitmentNoticeTechStackMapping, Long> {
}
