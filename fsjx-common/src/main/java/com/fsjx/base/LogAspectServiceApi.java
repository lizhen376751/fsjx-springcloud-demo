package com.fsjx.base;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
/**
 * @Aspect 注解 使之成为切面类
 * @Component把切面类加入到IOC容器中
 */
@Aspect
@Component
public class LogAspectServiceApi {
	private static final Logger log = LoggerFactory.getLogger(LogAspectServiceApi.class);
	private JSONObject jsonObject = new JSONObject();

	// 申明一个切点 里面是 execution表达式
	@Pointcut("execution(public * com.fsjx.service..*.*(..))")
	//public 方法的，*所有返回类型，com.fsjx.service所有包下面的（..*包含本类和子类），.*表示所有方法（如果写成service*（）表示所有以service开头的方法）
	//最后括号里面的..表示任意参数
	private void controllerAspect() {
	}

	// 请求method前打印内容
	@Before(value = "controllerAspect()")
	public void methodBefore(JoinPoint joinPoint) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		log.info("===============请求内容===============");
		try {
			// 打印请求内容
			log.info("请求地址:" + request.getRequestURL().toString());
			log.info("请求方式:" + request.getMethod());
			log.info("请求类方法:" + joinPoint.getSignature());
			log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
		}
		log.info("===============请求内容===============");
	}

	// 在方法执行完结后打印返回内容
	@AfterReturning(returning = "o", pointcut = "controllerAspect()")
	public void methodAfterReturing(Object o) {
		log.info("--------------返回内容----------------");
		try {
			log.info("Response内容:" + jsonObject.toJSONString(o));
		} catch (Exception e) {
			log.error("###LogAspectServiceApi.class methodAfterReturing() ### ERROR:", e);
		}
		log.info("--------------返回内容----------------");
	}
}
