package dev.practice.preonboarding.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompanyApplicationHistoryId implements Serializable {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private UserAccount userAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recruitment_notice_id")
	private RecruitmentNotice recruitmentNotice;
}
