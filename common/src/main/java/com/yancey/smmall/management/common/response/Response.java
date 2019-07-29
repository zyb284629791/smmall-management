package com.yancey.smmall.management.common.response;

import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Optional;


public class Response<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;

	private String message;

	@Nullable
	private final T data;


	public Response(@Nullable T data, Integer code, String message) {
		this.data = data;
		this.code = code;
		this.message = message;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public static DataBuilder instance() {
		return Builder.getInstance();
	}

	public  interface DataBuilder {

		DataBuilder code(Integer code);

		DataBuilder message(String message);

		DataBuilder result(HttpResponseEnum httpResponseEnum);

		<T> Response<T> data(@Nullable T data);

		<T> Response<T> build();
	}

	private final static class Builder implements DataBuilder {


		private static final Integer DEFAULT_CODE = 200;

		private static final String DEFAULT_MESSAGE = "success";

		private transient Integer code = DEFAULT_CODE;

		private transient String message = DEFAULT_MESSAGE;

		public static Builder getInstance() {
			return  new Builder();
		}

		public Builder() {
		}

		public DataBuilder code(Integer code) {
			this.code = code;
			return this;
		}

		public DataBuilder message(String message) {
			this.message = message;
			return this;
		}

		public DataBuilder result(HttpResponseEnum httpResponseEnum) {
			this.code = Optional.ofNullable(httpResponseEnum.getCode()).orElse(DEFAULT_CODE);
			this.message = Optional.ofNullable(httpResponseEnum.getMessage()).orElse(DEFAULT_MESSAGE);
			return this;
		}

		public <T> Response<T> build() {
			return data(null);
		}

		@Override
		public <T> Response<T> data(@Nullable T data) {
			return new Response<>(data, this.code, this.message);
		}

	}

}
