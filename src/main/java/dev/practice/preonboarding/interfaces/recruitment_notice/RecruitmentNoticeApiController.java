package dev.practice.preonboarding.interfaces.recruitment_notice;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.practice.preonboarding.application.RecruitmentNoticeFacade;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeInfo;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitment")
public class RecruitmentNoticeApiController {
	private final RecruitmentNoticeFacade recruitmentNoticeFacade;
	private final RecruitmentNoticeDtoMapper recruitmentNoticeDtoMapper;

	@PostMapping
	public ResponseEntity<Void> registerRecruitmentNotice(
		@RequestBody @Valid RecruitmentNoticeDto.RegisterRecruitmentNoticeRequest request) {
		var command = recruitmentNoticeDtoMapper.of(request);
		recruitmentNoticeFacade.registerRecruitmentNotice(command, request.getCompanyId());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{recruitmentId}")
	public ResponseEntity<Void> modifyRecruitmentNotice(
		@PathVariable Long recruitmentId,
		@RequestBody @Valid RecruitmentNoticeDto.ModifyRecruitmentNoticeRequest request) {
		var command = recruitmentNoticeDtoMapper.of(request);
		recruitmentNoticeFacade.modifyRecruitmentNotice(command, recruitmentId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{recruitmentId}")
	public ResponseEntity<Void> deleteRecruitmentNotice(@PathVariable Long recruitmentId) {
		recruitmentNoticeFacade.deleteRecruitmentNotice(recruitmentId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<RecruitmentNoticeDto.RecruitmentNoticeListResponse>> findAllRecruitmentNotices() {
		List<RecruitmentNoticeInfo.RecruitmentNoticeList> recruitmentNotices =
			recruitmentNoticeFacade.findAllRecruitmentNotice();
		List<RecruitmentNoticeDto.RecruitmentNoticeListResponse> response = recruitmentNotices.stream()
			.map(recruitmentNoticeList -> recruitmentNoticeDtoMapper.of(recruitmentNoticeList))
			.collect(Collectors.toList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{recruitmentId}")
	public ResponseEntity<RecruitmentNoticeDto.DetailsRecruitmentNoticeResponse> detailsRecruitmentNotice(
		@PathVariable Long recruitmentId) {
		RecruitmentNoticeInfo.DetailsRecruitmentNotice detailsRecruitmentNotice
			= recruitmentNoticeFacade.detailsRecruitmentNotice(recruitmentId);
		RecruitmentNoticeDto.DetailsRecruitmentNoticeResponse response = recruitmentNoticeDtoMapper.of(
			detailsRecruitmentNotice);
		return ResponseEntity.ok().body(response);
	}
}
