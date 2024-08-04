package dev.practice.preonboarding.interfaces.recruitment_notice;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.practice.preonboarding.application.RecruitmentNoticeFacade;
import dev.practice.preonboarding.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruit")
public class RecruitmentNoticeApiController {
	private final RecruitmentNoticeFacade recruitmentNoticeFacade;
	private final RecruitmentNoticeDtoMapper recruitmentNoticeDtoMapper;

	@PostMapping
	public CommonResponse registerRecruitmentNotice(
		@RequestBody @Valid RecruitmentNoticeDto.RegisterRecruitmentNoticeRequest request) {
		var command = recruitmentNoticeDtoMapper.of(request);
		recruitmentNoticeFacade.registerRecruitmentNotice(command, request.getCompanyId());
		return CommonResponse.success(null, "OK");
	}
}
