package sk.spring.active;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 通知类
 */
@Aspect
public class MyActive {

	//前置通知：     目标方法运行之前调用
	@Before("execution(* sk.spring.service.impl.*ServiceImpl.*(..))")
	public void before (){
		System.out.println("前置通知");
	}

	//后置通知(如果出现异常不会调用) : 在目标方法运行之后调用
	@AfterReturning("execution(* sk.spring.service.impl.*ServiceImpl.*(..))")
	public void afterReturnning(){
		System.out.println("后置通知：出问题别找我了");
	}

	//环绕通知 : 在目标方法之前和之后都调用
	@Around("execution(* sk.spring.service.impl.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知之前的部分!!");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知之后的部分!!");
		return proceed;
	}

	//异常拦截通知 : 如果出现异常,就会调用
	@AfterThrowing("execution(* sk.spring.service.impl.*ServiceImpl.*(..))")
	public void afterThrowing(){
		System.out.println("异常通知");
	}

	//后置通知(无论是否出现 异常都会调用) : 在目标方法运行之后调用
	@After("execution(* sk.spring.service.impl.*ServiceImpl.*(..))")
	public void afterFinally(){
		System.out.println("后置通知：出不出异常，都得调我");
	}


}
