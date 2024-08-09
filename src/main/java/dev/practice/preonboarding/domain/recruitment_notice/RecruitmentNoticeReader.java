package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

public interface RecruitmentNoticeReader {

	RecruitmentNotice findByRecruitmentNoticeId(Long recruitmentId);

	boolean existsByRecruitmentId(Long recruitmentId);

	List<RecruitmentNotice> findAll();
}
