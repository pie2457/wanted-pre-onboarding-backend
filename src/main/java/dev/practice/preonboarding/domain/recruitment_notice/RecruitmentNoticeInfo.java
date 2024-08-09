package dev.practice.preonboarding.domain.recruitment_notice;

import java.util.List;

import dev.practice.preonboarding.domain.company.Company;
import lombok.Getter;
import lombok.ToString;

public class RecruitmentNoticeInfo {

	@Getter
	@ToString
	public static class RecruitmentNoticeList {
		private final Long recruitmentNoticeId;
		private final String companyName;
		private final String country;
		private final String region;
		private final String recruitmentNoticePosition;
		private final int recruitmentNoticeCompensation;
		private final List<Long> techStacks;

		public RecruitmentNoticeList(RecruitmentNotice recruitmentNotice, Company company, List<Long> techStacks) {
			this.recruitmentNoticeId = recruitmentNotice.getId();
			this.companyName = company.getName();
			this.country = company.getCountry();
			this.region = company.getRegion();
			this.recruitmentNoticePosition = recruitmentNotice.getPosition();
			this.recruitmentNoticeCompensation = recruitmentNotice.getCompensation();
			this.techStacks = techStacks;
		}
	}
}
