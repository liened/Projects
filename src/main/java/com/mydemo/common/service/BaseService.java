package com.mydemo.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service基类
 */
@Transactional(readOnly = true)
@Slf4j
public class BaseService {

    //TODO 权限过滤等
}
