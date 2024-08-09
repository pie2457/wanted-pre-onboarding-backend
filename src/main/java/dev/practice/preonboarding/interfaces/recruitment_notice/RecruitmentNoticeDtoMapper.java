package dev.practice.preonboarding.interfaces.recruitment_notice;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeCommand;
import dev.practice.preonboarding.domain.recruitment_notice.RecruitmentNoticeInfo;

@Mapper(
	componentModel = "spring",
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface RecruitmentNoticeDtoMapper {

	RecruitmentNoticeCommand.RegisterRecruitmentNoticeRequest of(
		RecruitmentNoticeDto.RegisterRecruitmentNoticeRequest request);

	RecruitmentNoticeCommand.ModifyRecruitmentNoticeRequest of(
		RecruitmentNoticeDto.ModifyRecruitmentNoticeRequest request);

	RecruitmentNoticeDto.RecruitmentNoticeListResponse of(
		RecruitmentNoticeInfo.RecruitmentNoticeList recruitmentNoticeList);

	RecruitmentNoticeDto.DetailsRecruitmentNoticeResponse of(
		RecruitmentNoticeInfo.DetailsRecruitmentNotice detailsRecruitmentNotice);
}
