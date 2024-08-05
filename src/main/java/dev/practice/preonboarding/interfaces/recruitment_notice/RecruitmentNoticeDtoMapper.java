package dev.practice.preonboarding.interfaces.recruitment_notice;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeCommand;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RecruitmentNoticeDtoMapper {

	RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest of(
		RecruitmentNoticeDto.RegisterRecruitmentNoticeRequest request);
}
