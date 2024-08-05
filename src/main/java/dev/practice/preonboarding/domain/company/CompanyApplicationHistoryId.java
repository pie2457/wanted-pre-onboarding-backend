package dev.practice.preonboarding.domain.company;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompanyApplicationHistoryId implements Serializable {

	private Long userAccountId;
	private Long recruitmentNoticeId;
}
