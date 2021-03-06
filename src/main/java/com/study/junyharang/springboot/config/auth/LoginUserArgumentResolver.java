package com.study.junyharang.springboot.config.auth;

import com.study.junyharang.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor @Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;

        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
        
    } // supportsParameter 끝

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {

        return httpSession.getAttribute("user");
    } // resolveArgument() 끝
} // class 끝
