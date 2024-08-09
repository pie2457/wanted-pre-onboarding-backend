package dev.practice.preonboarding.application;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeCommand;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeInfo;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeFacade {
	private final RecruitmentNoticeService recruitmentNoticeService;

	public void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId) {
		recruitmentNoticeService.registerRecruitmentNotice(request, companyId);
	}

	public void modifyRecruitmentNotice(
		RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest request, Long recruitmentId) {
		recruitmentNoticeService.modifyRecruitmentNotice(request, recruitmentId);
	}

	public void deleteRecruitmentNotice(Long recruitmentNoticeId) {
		recruitmentNoticeService.deleteRecruitmentNotice(recruitmentNoticeId);
	}

	public List<RecruitmentNoticeInfo.RecruitmentNoticeList> findAllRecruitmentNotice() {
		return recruitmentNoticeService.findAllRecruitmentNotice();
	}

	public RecruitmentNoticeInfo.DetailsRecruitmentNotice detailsRecruitmentNotice(Long recruitmentNoticeId) {
		return recruitmentNoticeService.detailsRecruitmentNotice(recruitmentNoticeId);
	}
}
