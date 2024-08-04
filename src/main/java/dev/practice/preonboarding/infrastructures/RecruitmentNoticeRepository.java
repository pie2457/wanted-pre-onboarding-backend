package dev.practice.preonboarding.infrastructures;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
}
