package evolution.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import evolution.exception.AnyException;

@RestController
public class AnyController {
	@GetMapping("/throw")
	public void throwException() {
		throw new AnyException();
	}
	
	@GetMapping("/arithmetic")
	public void arithmetic() {
		int i = 1 / 0;
	}
	
	// Attach it to the base controller if necessary.
	// The exception string is printed directly to the browser.
	// It's suitable for creating a custom error response.
	// You can set the exception string like "redirect:" to redirect to another web page if you are using @Controller rather than @RestController.
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(Exception e) {
		return "An Arithemetic Exception is Discovered by Chen";
	}
	
	@GetMapping("/pointer")
	public void pointer() {
		String string = null;
		string.length();
	}
	
	// The exception string shows up on the browser in a white-label-error format.
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "A Null Pointer Exception is discovered by Chen")
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException(Exception e) {
		return "An Arithemetic Exception is Discovered by Chen";
	}
	
	@GetMapping("/array")
	public void array() {
		int[] a = new int[1];
		int b = a[1];
	}
	
	@GetMapping("/file")
	public void file() throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(new File("AnyFile.txt"));
	}
}
