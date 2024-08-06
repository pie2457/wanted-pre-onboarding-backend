package dev.practice.preonboarding.infrastructures.recruitment_notice;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.common.exception.EntityNotFoundException;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeReaderImpl implements RecruitmentNoticeReader {
	private final RecruitmentNoticeRepository recruitmentNoticeRepository;

	@Override
	public RecruitmentNotice findByRecruitmentNoticeId(Long recruitmentId) {
		return recruitmentNoticeRepository.findById(recruitmentId)
			.orElseThrow(EntityNotFoundException::new);
	}
}
