package com.yetgim.ecommerce.aop.manager;


import com.yetgim.ecommerce.aop.tables.Performance;
import com.yetgim.ecommerce.aop.tables.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@RequiredArgsConstructor
public class PerformanceAspect {

    private final PerformanceRepository repository;

    @Around("@annotation(com.yetgim.ecommerce.aop.annotations.PerformanceLogger)")
    public Object measurePerformance(ProceedingJoinPoint pjp) throws Throwable {

        String methodName = ((MethodSignature) pjp.getSignature())
                .getName();


        long start = System.nanoTime();
        Object result = pjp.proceed();
        long end = System.nanoTime();

        double durationSeconds = (end - start) / 1_000_000;

        Performance performance = new Performance();
        performance.setMethodName(methodName);
        performance.setDurationSeconds(durationSeconds);
        performance.setExecutedAt(LocalDateTime.now());

        repository.save(performance);

        return result;

    }

}
