package com.dongnao.jack.dynamicDataSource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

import com.dongnao.jack.annotation.TargetDataSource;

/** 
 * @Description 这个类是一个切面类，做的事情就是动态的把数据源放入到ThreadLocal中去 
 * @ClassName   DataSourceAspectJ 
 * @Date        2017年10月14日 下午9:29:29 
 * @Author      动脑学院-jack
 */

@Aspect
@Order(-1)
public class DataSourceAspectJ {
    
    /** 
     * @Description TODO 
     * @param @param joinPoint 参数 
     * @return void 返回类型  
     * @throws 
     */
    
    @Before(value = "execution(* com.dongnao.jack.service..*.*(..))")
    //advice 这是一个增强或者通知
    public void before(JoinPoint joinPoint) {
        System.out.println("before advice!");
        
        //1、获取我们的被代理类
        Object target = joinPoint.getTarget();
        
        //获取方法名称
        String targetMehtodName = joinPoint.getSignature().getName();
        
        //2、拿到被代理类的接口
        Class<?>[] interfacezz = target.getClass().getInterfaces();
        
        //3、拿被代理类的方法的入参
        Class<?>[] paramTypeszz = ((MethodSignature)joinPoint.getSignature()).getMethod()
                .getParameterTypes();
        
        for (Class<?> intfzz : interfacezz) {
            try {
                Method intfMethod = intfzz.getMethod(targetMehtodName,
                        paramTypeszz);
                
                if (intfMethod != null) {
                    if (intfMethod.isAnnotationPresent(TargetDataSource.class)) {
                        TargetDataSource data = intfMethod.getAnnotation(TargetDataSource.class);
                        HandleDataSource.pubDataSource(data.value());
                    }
                    else {
                        HandleDataSource.pubDataSource("write");
                    }
                }
                else {
                    continue;
                }
            }
            catch (NoSuchMethodException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
