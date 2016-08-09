package io.fruitbase.business.common;


public class FruitBaseException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private ErrorInfo error;

	public FruitBaseException(ErrorInfo error) {
		super(error.getMessage());
		this.setError(error);
	}

	public FruitBaseException(ErrorInfo error, ErrorInfo... param) {
		error.setMessage(String.format(error.getMessage(), param));
		this.setError(error);
	}

	public ErrorInfo getError() {
		return error;
	}

	public void setError(ErrorInfo error) {
		this.error = error;
	}
}
