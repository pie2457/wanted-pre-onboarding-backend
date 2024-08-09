package dev.practice.preonboarding.domain.recruitment_notice_tech_stack;

import java.util.List;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNotice;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeInfo;

public interface RecruitmentNoticeTechStackMappingFactory {

	List<RecruitmentNoticeInfo.RecruitmentNoticeList> generateRecruitmentNoticesWithDetails(
		List<RecruitmentNotice> recruitmentNotices);

	RecruitmentNoticeInfo.DetailsRecruitmentNotice generateDetailsRecruitmentNotice(
		RecruitmentNotice recruitmentNotice);
}
