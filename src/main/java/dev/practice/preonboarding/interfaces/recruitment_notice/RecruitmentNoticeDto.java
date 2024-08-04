package dev.practice.preonboarding.interfaces.recruitment_notice;

import static lombok.AccessLevel.*;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
		@NotBlank(message = "recruitPosition 는 필수값 입니다.")
		private String recruitPosition;
		@NotBlank(message = "recruitContent 는 필수값 입니다.")
		private String recruitContent;
		@NotBlank(message = "recruitCompensation 는 필수값 입니다.")
		private int recruitCompensation;
		@NotBlank(message = "companyId 는 필수값 입니다.")
		private List<Integer> techStacks;
	}
}
