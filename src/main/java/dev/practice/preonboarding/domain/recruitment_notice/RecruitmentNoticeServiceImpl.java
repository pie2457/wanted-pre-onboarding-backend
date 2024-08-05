package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeServiceImpl implements RecruitmentNoticeService {
	private final RecruitmentNoticeStore recruitmentNoticeStore;
	private final RecruitmentNoticeTechStackMappingStore mappingStore;

	@Override
	@Transactional
	public void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId) {
		RecruitmentNotice recruitmentNotice = request.toEntity(companyId);
		RecruitmentNotice notice = recruitmentNoticeStore.save(recruitmentNotice);

		List<RecruitmentNoticeTechStackMapping> techStackMappings = request.getTechStacks().stream()
			.map(id -> new RecruitmentNoticeTechStackMapping(notice.getId(), id))
			.collect(Collectors.toList());
		mappingStore.saveAll(techStackMappings);
	}
}
