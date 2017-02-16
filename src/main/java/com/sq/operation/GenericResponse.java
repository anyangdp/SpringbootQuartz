package com.sq.operation;

import lombok.Data;

/**
 * @author william
 *
 */
@Data
public class GenericResponse {

	@Data
	public class Error {
		private String code;

		private String message;
	}

	private boolean result = true;

	private Error error;

	private Object data;
}
