package scm.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// TODO: DO WE NEED THIS?
@Component
public class InterceptorHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        // Following code is not required, we are setting data at gateway and retrieving
        // using RequestHeaderUtils
//        RequestContextHolder.currentRequestAttributes()
//                .setAttribute(
//                        RequestConstants.reqHeaderUserId,
//                        String.valueOf(request.getHeader(RequestConstants.reqHeaderUserId)),
//                        RequestAttributes.SCOPE_REQUEST);
//        RequestContextHolder.currentRequestAttributes()
//                .setAttribute(
//                        RequestConstants.reqHeaderUserName,
//                        String.valueOf(request.getHeader(RequestConstants.reqHeaderUserName)),
//                        RequestAttributes.SCOPE_REQUEST);
//        RequestContextHolder.currentRequestAttributes()
//                .setAttribute(
//                        RequestConstants.reqHeaderRoles,
//                        String.valueOf(request.getHeader(RequestConstants.reqHeaderRoles)),
//                        RequestAttributes.SCOPE_REQUEST);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception exception) {

    }
}