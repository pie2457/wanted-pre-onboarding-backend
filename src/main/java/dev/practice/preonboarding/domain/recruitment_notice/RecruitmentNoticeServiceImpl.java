package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.practice.preonboarding.common.exception.EntityNotFoundException;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMapping;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingStore;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecruitmentNoticeServiceImpl implements RecruitmentNoticeService {
	private final RecruitmentNoticeStore recruitmentNoticeStore;
	private final RecruitmentNoticeTechStackMappingStore mappingStore;
	private final RecruitmentNoticeReader recruitmentNoticeReader;

	@Override
	@Transactional
	public void registerRecruitmentNotice(
		RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest request, Long companyId) {
		RecruitmentNotice recruitmentNotice = request.toEntity(companyId);
		RecruitmentNotice notice = recruitmentNoticeStore.save(recruitmentNotice);

		createRecruitmentNoticeMapping(request.getTechStacks(), notice.getId());
	}

	@Override
	@Transactional
	public void modifyRecruitmentNotice(
		RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest request, Long recruitmentId) {
		RecruitmentNotice recruitmentNotice =
			recruitmentNoticeReader.findByRecruitmentNoticeId(recruitmentId);
		recruitmentNotice.modify(request);

		mappingStore.deleteAllByRecruitmentNoticeId(recruitmentId);

		createRecruitmentNoticeMapping(request.getTechStacks(), recruitmentId);
	}

	private void createRecruitmentNoticeMapping(List<Long> techStacks, Long notice) {
		List<RecruitmentNoticeTechStackMapping> techStackMappings = techStacks.stream()
			.map(id -> new RecruitmentNoticeTechStackMapping(notice, id))
			.collect(Collectors.toList());
		mappingStore.saveAll(techStackMappings);
	}

	@Override
	@Transactional
	public void deleteRecruitmentNotice(Long recruitmentId) {
		if (!recruitmentNoticeReader.existsByRecruitmentId(recruitmentId)) {
			throw new EntityNotFoundException();
		}
		recruitmentNoticeStore.delete(recruitmentId);
		mappingStore.deleteAllByRecruitmentNoticeId(recruitmentId);
	}
}
