package com.atez.inventory.manager.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

public class CustomError {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;
    private String path;
    private String type;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static final class SignErrorBuilder {

        private LocalDateTime timeStamp;
        private int status;
        private List<String> errors;
        private String message;
        private String detail;
        private String path;
        private String type;

        public static SignErrorBuilder anSignError() {
            return new SignErrorBuilder();
        }

        public SignErrorBuilder withTimestamp(LocalDateTime localDateTime) {
            this.timeStamp = localDateTime;
            return this;
        }

        public SignErrorBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public SignErrorBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public SignErrorBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public SignErrorBuilder withPath(String path) {
            this.path = path;
            return this;
        }

        public SignErrorBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public CustomError build() {
            var signError = new CustomError();
            signError.timestamp = this.timeStamp;
            signError.status = this.status;
            signError.message = this.message;
            signError.detail = detail;
            signError.path = this.path;
            signError.type = this.type;
            return signError;
        }

		public List<String> getErrors() {
			return errors;
		}

		public void setErrors(List<String> errors) {
			this.errors = errors;
		}
    }

}
