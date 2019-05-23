package com.csmz.kaoqing.web.commer;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrivilegeAspect {
	//private final static Logger logger = LoggerFactory.getLogger(PrivilegeAspect.class);

	//拦截条件
//	@Pointcut("execution(public * com.csmz.kaoqing.web.controller.*(..))")
//	public void log() {}
	
//	@Around("log()")
//	public Object signVerification(ProceedingJoinPoint p) throws Throwable{
//	    Privilege pri = new Privilege();
//	    if (pri.Verification())//已经登录
//	    {
//	        return p.proceed();//继续执行被拦截的方法
//	    }else {//未登录
//	        //构建JSON 
//	        String response = "{\"signin\":0}";
//	        return response;
//	    }
//	}
	
	//@Around("execution(* com.csmz.kaoqing.web.controller.*(..))")
	public Object around(ProceedingJoinPoint p) throws Throwable {
		//before
		long t = System.currentTimeMillis();
		System.out.println("around_before");
		//被代理的部分(分隔开前后)
		Object r = p.proceed();
		
		//after
		System.out.println("around_after");
		t = System.currentTimeMillis() - t; 
		System.out.printf("程序执行：%s 方法 -----> 耗时：%d ms \n", p.getSignature(), t);
		
		return r;
	}

}
