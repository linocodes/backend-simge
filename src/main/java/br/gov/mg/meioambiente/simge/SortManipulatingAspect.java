package br.gov.mg.meioambiente.simge;
import org.aspectj.lang.ProceedingJoinPoint;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.springframework.data.domain.PageRequest;  
import org.springframework.data.domain.Sort;  
import org.springframework.stereotype.Component;

import java.util.Arrays;  
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.StreamSupport;

@Aspect
@Component
public class SortManipulatingAspect {

    @Around("execution(public * org.springframework.data.repository.PagingAndSortingRepository+.*(..))")
    public Object enableIgnoreCaseSorting(ProceedingJoinPoint joinPoint) throws Throwable {

        return joinPoint.proceed(
                Arrays.stream(joinPoint.getArgs()).map(SortManipulatingAspect::sortWithIgnoreCase).toArray()
        );
    }

    private static Object sortWithIgnoreCase(Object arg) {
        if (arg instanceof PageRequest) {
            return pageRequestIgnoreCaseSort((PageRequest)arg);
        } else {
            return arg;
        }

    }

    private static PageRequest pageRequestIgnoreCaseSort(PageRequest pageRequest) {
        return new PageRequest(
                pageRequest.getPageNumber(),
                pageRequest.getPageSize(),
                pageRequest.getSort() != null ? new Sort(toOrderStream(pageRequest.getSort())) : null
        );
    }

    private static List<Sort.Order> toOrderStream(Sort sort) {
        return StreamSupport.stream(sort.spliterator(), false)
                .map(Sort.Order::ignoreCase)
                .collect(Collectors.toList());
    }

}