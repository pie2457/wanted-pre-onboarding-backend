package dev.practice.preonboarding.common.exception;

import dev.practice.preonboarding.common.response.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseException extends RuntimeException {
	private ErrorCode errorCode;

	public BaseException(ErrorCode errorCode) {
		super(errorCode.getErrorMsg());
		this.errorCode = errorCode;
	}
}
