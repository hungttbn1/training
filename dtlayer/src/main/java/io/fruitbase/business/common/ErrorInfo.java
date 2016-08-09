package io.fruitbase.business.common;

import java.util.concurrent.atomic.AtomicInteger;

public class ErrorInfo {

	public static final AtomicInteger AUTOMIC_CODE = new AtomicInteger(1000);

	public static final int UNKNOWN_ERROR_CODE = AUTOMIC_CODE.getAndIncrement();

	private int code;
	private String message;

	public ErrorInfo(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * 
	 * 
	 * public static final ErrorInfo GENERAL_ERROR = new ErrorInfo(GENERAL_CODE,
	 * "Unknown error");
	 * 
	 * public static final ErrorInfo NOT_FOUND = new ErrorInfo(NOT_FOUND_CODE,
	 * "The requested resource is not available");
	 * 
	 * public static final ErrorInfo PAGE_INDEX_ERROR = new ErrorInfo(
	 * AUTOMIC_CODE.incrementAndGet(), "Page index can not be less than zero");
	 * 
	 * public static final ErrorInfo PAGE_SIZE_ERROR = new ErrorInfo(
	 * AUTOMIC_CODE.incrementAndGet(), "Page size can not be less than one");
	 * 
	 * public static final ErrorInfo URI_INVALID = new ErrorInfo(NOT_FOUND_CODE,
	 * "Request URI is invalid");
	 */
	
	public static final ErrorInfo INTERNAL_SERVER_ERROR = new ErrorInfo(
			UNKNOWN_ERROR_CODE,
			"INTERNAL SERVER ERROR");

	public static final ErrorInfo AVATAR_NOT_FOUND = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "AVATAR NOT FOUND");

	public static final ErrorInfo FULL_NAME_NULL = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "FULL NAME IS REQUIRED");

	public static final ErrorInfo EMAIL_INVALID = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "EMAIL IS INVALID");

	public static final ErrorInfo PASSWORD_NULL = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "PASSWORD IS REQUIRED");

	public static final ErrorInfo PHONE_NUMBER_NULL = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "PHONE NUMBER IS REQUIRED");

	public static final ErrorInfo EMAIL_IN_USE = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "EMAIL HAS BEEN TAKEN");

	public static final ErrorInfo PHONE_IN_USE = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "PHONE HAS BEEN TAKEN");

	public static final ErrorInfo LOGIN_FAILED = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(),
			"THE EMAIL OR PASSWORD IS INCORRECT");

	public static final ErrorInfo ACCESS_TOKEN_INVALID = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "ACCESS TOKEN IS INCORRECT");

	public static final ErrorInfo DEVICE_TOKEN_NULL = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(), "DEVICE TOKEN IS REQUIRED");

	public static final ErrorInfo PLATFORM_TYPE_INVALID = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(),
			"PLATFORM TYPE SHOULD BE 1 FOR IOS OR 2 FOR ANDROID");
	
	public static final ErrorInfo BAD_REQUEST = new ErrorInfo(
			AUTOMIC_CODE.incrementAndGet(),
			"REQUEST MUST BE VALID JSON");
	
}
