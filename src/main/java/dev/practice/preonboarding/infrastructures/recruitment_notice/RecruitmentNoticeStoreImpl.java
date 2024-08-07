package dev.practice.preonboarding.infrastructures.recruitment_notice;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeStoreImpl implements RecruitmentNoticeStore {
	private final RecruitmentNoticeRepository recruitmentNoticeRepository;

	@Override
	public RecruitmentNotice save(RecruitmentNotice recruitmentNotice) {
		return recruitmentNoticeRepository.save(recruitmentNotice);
	}
}
