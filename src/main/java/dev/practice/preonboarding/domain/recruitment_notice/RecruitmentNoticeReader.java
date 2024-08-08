package dev.practice.preonboarding.domain.recruitment_notice;

public interface RecruitmentNoticeReader {

	RecruitmentNotice findByRecruitmentNoticeId(Long recruitmentId);

	boolean existsByRecruitmentId(Long recruitmentId);
}
