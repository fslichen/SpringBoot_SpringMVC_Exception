package evolution.controller;

import java.io.FileNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import evolution.controller.dto.ResponseDto;
import evolution.exception.AnyException;
import evolution.exception.ReflectException;

// It acts like @AspectJ for controllers.
// You don't have to write aspects for controllers any more because @ControllerAdvice is doing just that.
// @ControllerAdvice serves as an annotation driven interceptor. 
@ControllerAdvice
public class AnyControllerAdvice {
	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
	@ResponseBody// Instead of redirecting you to another web page, it returns JSON.
	public ResponseDto arrayIndexOutOfBoundsException(Exception e) {
		return new ResponseDto("Array Index out of Bounds Exception");
	}
	
	@ExceptionHandler(value = FileNotFoundException.class)
	public String fileNotFoundException(Exception e) {
		System.out.println("Error Message = " + e.getMessage());
		return "redirect:http://www.google.com?q=fileNotFoundException";
	}
	
	@ExceptionHandler(value = AnyException.class)
	public String anyException(Exception e) {
		System.out.println("Error Message = " + e.getMessage());
		return "redirect:http://www.google.com?q=anyException";
	}
	
	// Make full use of the exception, it contains lots of information.
	@ExceptionHandler(value = ReflectException.class)
	public String reflectException(Exception e) {
		System.out.println("Error Message = " + e.getMessage());
		StackTraceElement element = e.getStackTrace()[0];
		System.out.println("Class Name = " + element.getClassName() + " Method Name = " + element.getMethodName() 
			+ " File Name = " + element.getFileName() + " Line Number = " + element.getLineNumber() + " Cause = " + e.getCause());
		return "redirect:http://www.google.com?q=reflectException";
	}
}
