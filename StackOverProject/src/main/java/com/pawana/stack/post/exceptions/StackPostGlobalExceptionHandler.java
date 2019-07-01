package com.pawana.stack.post.exceptions;

import java.util.Date;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.pawana.stack.post.util.APIResponse;
import com.pawana.stack.post.util.ErrorInfo;
import com.pawana.stack.post.util.Status;

@RestControllerAdvice
public class StackPostGlobalExceptionHandler<T> {
	@ExceptionHandler(ModelNotFoundException.class)
	public APIResponse<T> handleEntityExceptiion(ModelNotFoundException ex){
		APIResponse<T> api=new APIResponse<T>();
		
		 ErrorInfo errorInfo=new ErrorInfo();
		 errorInfo.setErrorCode(ex.getErrorCode());
		 errorInfo.setErrorMessage(ex.getErrorMessage());
		 api.getErrorInfo().add(errorInfo);
		return api;
		
	}
	
   @ExceptionHandler(Exception.class)
  public   APIResponse<T> handleException(Exception ex){
	   APIResponse<T> api=new APIResponse<T>();
	  
	   
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode("222");
		errorInfo.setErrorMessage(ex.getMessage());
		api.getErrorInfo().add(errorInfo);
		return api;
   }
  

  }
