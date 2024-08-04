package dev.practice.preonboarding.domain.recruitment_notice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecruitmentNotice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long companyId;
	private String position;
	private String content;
	private int compensation;

	@Builder
	public RecruitmentNotice(Long companyId, String position, String content, int compensation) {
		this.companyId = companyId;
		this.position = position;
		this.content = content;
		this.compensation = compensation;
	}
}
