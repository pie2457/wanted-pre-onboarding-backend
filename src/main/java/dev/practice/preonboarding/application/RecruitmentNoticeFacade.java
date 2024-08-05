package dev.practice.preonboarding.application;

import org.springframework.stereotype.Service;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeCommand;
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
}
