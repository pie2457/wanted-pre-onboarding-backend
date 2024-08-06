package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class RecruitmentNoticeCommand {

	@Getter
	@Builder
	@ToString
	public static class RegisterRecruitmentNoticeRequest {
		private final String position;
		private final String content;
		private final int compensation;
		private final List<Long> techStacks;

		public RecruitmentNotice toEntity(Long companyId) {
			return RecruitmentNotice.builder()
				.companyId(companyId)
				.position(position)
				.content(content)
				.compensation(compensation)
				.build();
		}
	}

	@Getter
	@Builder
	@ToString
	public static class ModifyRecruitmentNoticeRequest {
		private final String position;
		private final String content;
		private final int compensation;
		private final List<Long> techStacks;
	}
}
