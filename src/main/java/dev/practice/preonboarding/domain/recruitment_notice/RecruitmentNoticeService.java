package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

public interface RecruitmentNoticeService {

	void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId);

	void modifyRecruitmentNotice(
		RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest request, Long recruitmentId);

	void deleteRecruitmentNotice(Long recruitmentId);

	List<RecruitmentNoticeInfo.RecruitmentNoticeList> findAllRecruitmentNotice();

	RecruitmentNoticeInfo.DetailsRecruitmentNotice detailsRecruitmentNotice(Long recruitmentNoticeId);
}
