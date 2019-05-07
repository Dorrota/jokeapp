package guru.springframework.joke.exception;

public class DorotaNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public DorotaNotFoundException(String msg) {
		this.msg  = msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
