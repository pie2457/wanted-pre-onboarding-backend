package dev.practice.preonboarding.infrastructures.recruitment_notice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;

public interface RecruitmentNoticeRepository extends JpaRepository<RecruitmentNotice, Long> {
	@Override
	Optional<RecruitmentNotice> findById(Long recruitmentId);

	List<RecruitmentNotice> findByCompanyId(Long companyId);
}
