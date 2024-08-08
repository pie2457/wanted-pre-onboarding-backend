package dev.practice.preonboarding.domain.recruitment_notice;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import dev.practice.preonboarding.common.exception.EntityNotFoundException;
import dev.practice.preonboarding.domain.DomainTestSupport;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingStore;

@DisplayName("비즈니스 로직 - 채용공고")
class RecruitmentNoticeServiceImplTest extends DomainTestSupport {
	private static final long COMPANY_ID = 1L;

	@Mock
	private RecruitmentNoticeStore recruitmentNoticeStore;
	@Mock
	private RecruitmentNoticeTechStackMappingStore mappingStore;
	@Mock
	private RecruitmentNoticeReader recruitmentNoticeReader;
	@InjectMocks
	private RecruitmentNoticeServiceImpl recruitmentNoticeService;

	@DisplayName("채용공고 등록에 성공한다.")
	@Test
	void givenRegisterRequest_whenRegisterRecruitmentNotice_thenSuccess() {
		// given
		var request = createRegisterRecruitmentNotice();

		given(recruitmentNoticeStore.save(any())).willReturn(request.toEntity(COMPANY_ID));
		given(mappingStore.saveAll(any())).willReturn(List.of(
			new RecruitmentNoticeTechStackMapping(1L, 1L),
			new RecruitmentNoticeTechStackMapping(1L, 2L)
		));

		// when
		recruitmentNoticeService.registerRecruitmentNotice(request, COMPANY_ID);

		// then
		then(recruitmentNoticeStore).should(times(1)).save(any());
		then(mappingStore).should(times(1)).saveAll(any());
	}

	private RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest createRegisterRecruitmentNotice() {
		return RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest.builder()
			.content("인턴 구합니다")
			.compensation(1000000)
			.position("백엔드")
			.techStacks(List.of(1L, 2L))
			.build();
	}

	@DisplayName("채용공고 수정에 성공한다.")
	@Test
	void givenModifyRequest_whenModifyRecruitmentNotice_thenSuccess() {
		// given
		RecruitmentNotice recruitmentNotice = getSpyRecruitmentNotice();
		given(recruitmentNoticeReader.findByRecruitmentNoticeId(1L)).willReturn(recruitmentNotice);

		// when
		var modifyRequest = createModifyRecruitmentNotice();
		recruitmentNoticeService.modifyRecruitmentNotice(modifyRequest, recruitmentNotice.getId());

		// then
		ArgumentCaptor<List<RecruitmentNoticeTechStackMapping>> captor = ArgumentCaptor.forClass(List.class);

		then(mappingStore).should().saveAll(captor.capture());
		then(recruitmentNoticeReader).should(times(1)).findByRecruitmentNoticeId(recruitmentNotice.getId());
		then(mappingStore).should(times(1)).deleteAllByRecruitmentNoticeId(recruitmentNotice.getId());

		assertAll(
			() -> assertThat(recruitmentNotice.getContent()).isEqualTo(modifyRequest.getContent()),
			() -> assertThat(recruitmentNotice.getCompensation()).isEqualTo(modifyRequest.getCompensation()),
			() -> assertThat(captor.getValue()).hasSize(modifyRequest.getTechStacks().size())
		);
	}

	private RecruitmentNotice getSpyRecruitmentNotice() {
		RecruitmentNotice recruitmentNotice = Mockito.spy(RecruitmentNotice.class);
		when(recruitmentNotice.getId()).thenAnswer((Answer<Long>)invocationOnMock -> 1L);
		return recruitmentNotice;
	}

	private RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest createModifyRecruitmentNotice() {
		return RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest.builder()
			.content("신입 백엔드 인턴 구합니다.")
			.compensation(1500000)
			.position("백엔드")
			.techStacks(List.of(1L, 2L, 3L))
			.build();
	}

	@DisplayName("채용공고 삭제에 성공한다.")
	@Test
	void givenRecruitmentNoticeId_whenDeleteRecruitmentNotice_thenSuccess() {
		// given
		RecruitmentNotice recruitmentNotice = getSpyRecruitmentNotice();
		given(recruitmentNoticeReader.existsByRecruitmentId(recruitmentNotice.getId())).willReturn(true);

		// when
		recruitmentNoticeService.deleteRecruitmentNotice(recruitmentNotice.getId());

		// then
		then(recruitmentNoticeReader).should(times(1)).existsByRecruitmentId(recruitmentNotice.getId());
		then(recruitmentNoticeStore).should(times(1)).delete(recruitmentNotice.getId());
		then(mappingStore).should(times(1)).deleteAllByRecruitmentNoticeId(recruitmentNotice.getId());
	}

	@DisplayName("이미 삭제된 채용공고를 삭제하려고 하면 에러가 발생한다.")
	@Test
	void givenRecruitmentNoticeId_whenDeleteRecruitmentNotice_thenThrowsException() {
		// given
		RecruitmentNotice recruitmentNotice = getSpyRecruitmentNotice();
		given(recruitmentNoticeReader.existsByRecruitmentId(recruitmentNotice.getId())).willReturn(false);

		// when & then
		assertThatThrownBy(
			() -> recruitmentNoticeService.deleteRecruitmentNotice(recruitmentNotice.getId()))
			.isInstanceOf(EntityNotFoundException.class);

		then(recruitmentNoticeReader).should(times(1)).existsByRecruitmentId(recruitmentNotice.getId());
		then(recruitmentNoticeStore).should(times(0)).delete(recruitmentNotice.getId());
		then(mappingStore).should(times(0)).deleteAllByRecruitmentNoticeId(recruitmentNotice.getId());
	}
}
