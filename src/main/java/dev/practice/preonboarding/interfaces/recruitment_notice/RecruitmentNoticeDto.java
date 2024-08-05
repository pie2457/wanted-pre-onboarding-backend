package dev.practice.preonboarding.interfaces.recruitment_notice;

import static lombok.AccessLevel.*;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class RecruitmentNoticeDto {

	@Getter
	@Setter(value = PROTECTED)
	@ToString
	public static class RegisterRecruitmentNoticeRequest {
		@NotNull(message = "companyId 는 필수값 입니다.")
		private Long companyId;
		@NotBlank(message = "position 는 필수값 입니다.")
		private String position;
		@NotBlank(message = "content 는 필수값 입니다.")
		private String content;
		@Positive(message = "compensation 는 필수값 입니다.")
		private int compensation;
		@NotNull(message = "techStack 는 필수값 입니다.")
		private List<Long> techStacks;
	}
}
