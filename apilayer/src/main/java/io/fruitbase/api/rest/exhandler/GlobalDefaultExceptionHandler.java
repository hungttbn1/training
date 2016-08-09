package io.fruitbase.api.rest.exhandler;

import io.fruitbase.business.common.ErrorInfo;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * This class simply handles the following default exceptions:
 * NoSuchRequestHandlingMethodException 404 (Not Found)
 * HttpRequestMethodNotSupportedException 405 (Method Not Allowed)
 * HttpMediaTypeNotSupportedException 415 (Unsupported Media Type)
 * MissingServletRequestParameterException 400 (Bad Request)
 * ServletRequestBindingException 400 (Bad Request)
 * ConversionNotSupportedException 500 (Internal Server Error)
 * TypeMismatchException 400 (Bad Request) HttpMessageNotReadableException
 * 400(Bad Request) HttpMessageNotWritableException 500 (Internal Server Error)
 * MethodArgumentNotValidException 400 (Bad Request)
 * MissingServletRequestPartException 400 (Bad Request)
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler extends
		ResponseEntityExceptionHandler {

	private ErrorInfo message;

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(
			ConversionNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
			Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(
			HttpMessageNotWritableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(
			MissingServletRequestPartException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		message = new ErrorInfo(status.value(), ex.getMessage());
		return new ResponseEntity<Object>(message, headers, status);
	}
}
