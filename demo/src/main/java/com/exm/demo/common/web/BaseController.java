package com.exm.demo.common.web;

import com.exm.demo.common.entity.Result;
import com.exm.demo.common.persistence.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制器支持类
 * @author ThinkGem
 * @version 2013-3-23
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());


	public Result successResult(Object object, Page page) {
		Result result = new Result();
		result.setStatus("200");
		result.setObject(object);
		result.setPager(page);
		return result;
	}

	public Result successResult(Object object) {
		Result result = new Result();
		result.setStatus("200");
		result.setObject(object);
		return result;
	}

	public Result errorResult(String message) {
		Result result = new Result();
		result.setStatus("300");
		result.setMessage(message);
		return result;
	}
}
