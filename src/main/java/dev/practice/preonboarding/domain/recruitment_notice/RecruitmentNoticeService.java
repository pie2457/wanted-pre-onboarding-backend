package dev.practice.preonboarding.domain.recruitment_notice;

public interface RecruitmentNoticeService {

	void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId);

	void modifyRecruitmentNotice(
		RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest request, Long recruitmentId);
}
