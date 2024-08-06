package dev.practice.preonboarding.domain.recruitment_notice;

import static org.mockito.BDDMockito.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import dev.practice.preonboarding.domain.DomainTestSupport;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingStore;

@DisplayName("비즈니스 로직 - 채용공고")
class RecruitmentNoticeServiceImplTest extends DomainTestSupport {

	@Mock
	private RecruitmentNoticeStore recruitmentNoticeStore;
	@Mock
	private RecruitmentNoticeTechStackMappingStore mappingStore;
	@InjectMocks
	private RecruitmentNoticeServiceImpl recruitmentNoticeService;

	@DisplayName("채용공고 등록에 성공한다.")
	@Test
	void given_whenRegisterRecruitmentNotice_thenSuccess() {
		// given
		var request = RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest.builder()
			.content("신입 인턴 구합니다.")
			.compensation(1000000)
			.position("백엔드")
			.techStacks(List.of(1L, 2L))
			.build();

		long companyId = 1L;
		given(recruitmentNoticeStore.save(any())).willReturn(request.toEntity(companyId));
		given(mappingStore.saveAll(any())).willReturn(List.of(
			new RecruitmentNoticeTechStackMapping(1L, 1L),
			new RecruitmentNoticeTechStackMapping(1L, 2L)
		));

		// when
		recruitmentNoticeService.registerRecruitmentNotice(request, companyId);

		// then
		then(recruitmentNoticeStore).should(times(1)).save(any());
		then(mappingStore).should(times(1)).saveAll(any());
	}
}
