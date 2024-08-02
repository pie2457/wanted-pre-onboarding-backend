package dev.practice.preonboarding.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyApplicationHistory {

	@EmbeddedId
	private CompanyApplicationHistoryId companyApplicationHistoryId;
}
