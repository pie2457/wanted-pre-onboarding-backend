package dev.practice.preonboarding.domain.recruitment_notice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitmentNoticeTechStackMapping {

	@EmbeddedId
	private RecruitmentNoticeTechStackMappingId mappingId;

	public RecruitmentNoticeTechStackMapping(Long recruitmentNoticeId, Long techStackId) {
		this.mappingId = RecruitmentNoticeTechStackMappingId.builder()
			.recruitmentNoticeId(recruitmentNoticeId)
			.techStackId(techStackId)
			.build();
	}
}
