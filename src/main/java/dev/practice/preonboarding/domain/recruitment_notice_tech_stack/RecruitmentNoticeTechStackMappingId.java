package dev.practice.preonboarding.domain.recruitment_notice_tech_stack;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class RecruitmentNoticeTechStackMappingId implements Serializable {

	private Long recruitmentNoticeId;
	private Long techStackId;

	@Builder
	public RecruitmentNoticeTechStackMappingId(Long recruitmentNoticeId, Long techStackId) {
		this.recruitmentNoticeId = recruitmentNoticeId;
		this.techStackId = techStackId;
	}
}
