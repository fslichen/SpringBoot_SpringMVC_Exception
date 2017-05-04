package evolution.controller.dto;

public class ResponseDto {
	private String message;

	@Override
	public String toString() {
		return "ResponseDto [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseDto(String message) {
		super();
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
