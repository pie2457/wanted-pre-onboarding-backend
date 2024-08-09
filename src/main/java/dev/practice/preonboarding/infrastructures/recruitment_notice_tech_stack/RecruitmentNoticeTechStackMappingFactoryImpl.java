package dev.practice.preonboarding.infrastructures.recruitment_notice_tech_stack;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.practice.preonboarding.domain.company.Company;
import dev.practice.preonboarding.domain.company.CompanyReader;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeInfo;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingFactory;
import dev.practice.preonboarding.domain.recruitment_notice_tech_stack.RecruitmentNoticeTechStackMappingReader;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecruitmentNoticeTechStackMappingFactoryImpl implements RecruitmentNoticeTechStackMappingFactory {
	private final RecruitmentNoticeTechStackMappingReader mappingReader;
	private final CompanyReader companyReader;

	@Override
	public List<RecruitmentNoticeInfo.RecruitmentNoticeList> generateRecruitmentNoticeDetails(
		List<RecruitmentNotice> recruitmentNotices) {

		// 채용공고 ID에 대한 기술 스택 ID 리스트를 생성
		Map<Long, List<Long>> techStackPool = mappingReader.findAll().stream()
			.collect(Collectors.groupingBy(
				mapping -> mapping.getMappingId().getRecruitmentNoticeId(),
				Collectors.mapping(mapping -> mapping.getMappingId().getTechStackId(), Collectors.toList())
			));

		// 회사 정보를 매핑하기 위한 맵을 생성
		Map<Long, Company> companyPool = companyReader.findAllByIdIn(
				recruitmentNotices.stream()
					.map(RecruitmentNotice::getCompanyId)
					.collect(Collectors.toList())
			).stream()
			.collect(Collectors.toMap(Company::getId, company -> company));

		// RecruitmentNoticeInfo.RecruitmentNoticeList 리스트 생성
		return recruitmentNotices.stream()
			.map(notice -> new RecruitmentNoticeInfo.RecruitmentNoticeList(
				notice,
				companyPool.get(notice.getCompanyId()),
				techStackPool.getOrDefault(notice.getId(), Collections.emptyList())
			))
			.collect(Collectors.toList());
	}
}
