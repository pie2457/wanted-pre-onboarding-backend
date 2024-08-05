package dev.practice.preonboarding.infrastructures;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeTechStackMapping;

public interface RecruitmentNoticeTechStackMappingRepository
	extends JpaRepository<RecruitmentNoticeTechStackMapping, Long> {
}
