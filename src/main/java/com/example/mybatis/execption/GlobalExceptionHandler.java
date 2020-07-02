package com.example.mybatis.execption;

import com.example.mybatis.util.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * @author 丿何以所乐丨
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(GlobalException.class)
	public ResultType handlerSgException(GlobalException e){
		logger.error("--- 已捕获异常 ---"+ e.getCode() +" "+ e );
		return ResultType.builder().code(e.getCode()).message(e.getMessage()).build();
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResultType handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return ResultType.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public ResultType handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResultType.error(e.getMessage());
	}
}
