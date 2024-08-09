package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

public interface RecruitmentNoticeReader {

	RecruitmentNotice findById(Long recruitmentId);

	boolean existsByRecruitmentId(Long recruitmentId);

	List<RecruitmentNotice> findAll();

	List<RecruitmentNotice> findAllByCompanyId(Long companyId);
}
