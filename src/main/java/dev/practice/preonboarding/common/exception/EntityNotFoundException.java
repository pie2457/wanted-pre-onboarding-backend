package dev.practice.preonboarding.common.exception;

import dev.practice.preonboarding.common.response.ErrorCode;

public class EntityNotFoundException extends BaseException {

	public EntityNotFoundException() {
		super(ErrorCode.COMMON_ENTITY_NOT_FOUND);
	}
}
