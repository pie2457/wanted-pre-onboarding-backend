package dev.practice.preonboarding.domain.recruitment_notice;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeServiceImpl implements RecruitmentNoticeService {
	private final RecruitmentNoticeStore recruitmentNoticeStore;

	@Override
	public void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId) {
		RecruitmentNotice recruitmentNotice = request.toEntity(companyId);
		recruitmentNoticeStore.save(recruitmentNotice);
	}
}
