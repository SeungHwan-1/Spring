package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;
import org.w3c.dom.ls.LSOutput;

import java.util.Map;

@Aspect
@Component
public class LogginAspect {

    /*
    * @Aspect
    * - pointcut 과 advice 를 하나의 클래스 단위로 정의하기 이ㅜ한
    * 어노테이션이다.
    *
    * 조인 포인트 - aop 에서 특정한 실행 지점을 의미한다.
    * 종류
    *   메소드 호출 = 특정 메소드가 호출될 때
    *   메소드 실행 = 특정 메소드의 실행이 완료된 후
    *   예외 발생 = 특정 메소드 내에서 예외가 발생할 때
    *   필드 접근 = 객체의 필드에 접근할 때
    *
    * pointcut = 특정 조건에 의해 필터링 된 조인포인트
    * 수 많은 조인포인트 중에 특정 메소드만 횡단 공통기능을 수행하기 위해 사용한다.
    * advice = 횡단 관심에 해당하는 공통 기능의 코드
     */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    //pointcut = 관심 조인포인트를 결정하여 어드바이스가 실행되는 시기를 제어한다.
    //excution = 메소드 실행 조인 포인트를 매칭한다.
    //excution(*리턴타입.이름(파라미터))
    //*Service.*(..) = 매개변수가 0개 이상인 모든 메소드
    //*Service.*(*) = 매개변수가 1개 이상인 모든 메소드
    //*Service.*(*,*) = 매개변수가 2개 이상인 모든 메소드
    //서비스가 어노테이션 서비스
    //성능진단 로그찍고 예외처리하구
    public void logpointCut() {
        System.out.println("이거진짜실행안되나");
    }

    @Before("LogginAspect.logpointCut()") //바로위에 가르킴
    public void logBefore(JoinPoint joinPoint) {
            //현재 실행 중인 타깃 객체를 반환
        System.out.println("before joinpoint.getTarget(): " + joinPoint.getTarget());
        //호출된 메소드의 시그니처 반환 시그니처는 그 경로에서 함수
        System.out.println("before joinPoint.getSignature(): " + joinPoint.getSignature());


        if(joinPoint.getArgs().length > 0) {
            System.out.println("before joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }
    @After("logpointCut()") //서비스 끝난거.
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("after joinpoint.getTarget(): " + joinPoint.getTarget());
        System.out.println("after joinPoint.getSignature(): " + joinPoint.getSignature());

        if(joinPoint.getArgs().length > 0) {
            System.out.println("after joinPoint.getArgs()[0]: " + joinPoint.getArgs()[0]);
        }
    }
    // aop 가 적용될 메소드가 에러 없이 정상적으로 실행된 이후 실행
    @AfterReturning(pointcut = "logpointCut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After returning result: " + result);
//         if(result != null && result instanceof Map) {
//             ((Map<Integer,MemberDTO>)result).put(100, new MemberDTO(100,"가공한값"));
//         }

                  }

     @AfterThrowing(pointcut = "logpointCut()", throwing = "exception")
     public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("After throwing exception: " + exception);
     }


     /*
     * Around Advice는 가장 강력한 어드바이스다.
     * 이 어드바이스는 조인포인트를 완전히 장악한다.
     * 따라서 앞에 살펴 본 어드바이스 모두 Around   어드바이스로 조합할 수 있다..
     * 매개변수는 ProceedingJoinPoint로 고정되어 있다.
     * JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
     *
      */
    @Around("logpointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //메소드 실행전 로그 출력 그전에
        System.out.println("Around Before :" + joinPoint.getSignature().getName());

        //원본 메소드 실행 프로시드를 써줘야원본실행이된다. 여기서 제어할수있다.
        //실행되면서 비포 설정한것도 실행되고
        Object result = joinPoint.proceed();
        if(result != null && result instanceof Map) {

            ((Map<Integer,MemberDTO>)result).put(100,new MemberDTO(100,"반환 값 가능"));


        }

        //메소드 실행 후 로그 출력 프로시드를 만나야
        System.out.println("Around After :" + joinPoint.getSignature().getName());
        System.out.println(result);
        //결과 반환
        return result;
    }


}
