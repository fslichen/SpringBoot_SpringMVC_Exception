package evolution.controller;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// It acts like @AspectJ for controllers.
// You don't have to write aspects for controllers any more because @ControllerAdvice is doing just that.
// @ControllerAdvice serves as an annotation driven interceptor. 
@ControllerAdvice
public class AnyControllerAdvice {
	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
	public String arrayIndexOutOfBoundsException(Exception e) {
		return "redirect:http://www.google.com?q=arrayIndexOutOfBoundsException";
	}
	
	@ExceptionHandler(value = FileNotFoundException.class)
	public String fileNotFoundException(Exception e) {
		System.out.println("Error Message = " + e.getMessage());
		return "redirect:http://www.google.com?q=fileNotFoundException";
	}
}
