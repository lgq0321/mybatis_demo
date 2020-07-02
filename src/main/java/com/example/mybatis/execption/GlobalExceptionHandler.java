package com.example.mybatis.execption;

import com.example.mybatis.util.ResultTypeMy;
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
	public ResultTypeMy handlerSgException(GlobalException e){
		logger.error("--- 已捕获异常 ---"+ e.getCode() +" "+ e );
		return ResultTypeMy.builder().code(e.getCode()).message(e.getMessage()).build();
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public ResultTypeMy handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return ResultTypeMy.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public ResultTypeMy handleException(Exception e){
		logger.error(e.getMessage(), e);
		return ResultTypeMy.error(e.getMessage());
	}
}
