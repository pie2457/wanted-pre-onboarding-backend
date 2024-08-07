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
	void given_whenRegisterRecruitmentNotice_thenSuccess() {
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
	void given_whenModifyRecruitmentNotice_thenSuccess() {
		// given
		RecruitmentNotice recruitmentNotice = Mockito.spy(RecruitmentNotice.class);
		when(recruitmentNotice.getId()).thenAnswer((Answer<Long>)invocationOnMock -> 1L);
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

	private RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest createModifyRecruitmentNotice() {
		return RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest.builder()
			.content("신입 백엔드 인턴 구합니다.")
			.compensation(1500000)
			.position("백엔드")
			.techStacks(List.of(1L, 2L, 3L))
			.build();
	}
}
