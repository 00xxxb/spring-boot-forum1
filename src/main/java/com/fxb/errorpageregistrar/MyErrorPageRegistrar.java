package com.fxb.errorpageregistrar;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class MyErrorPageRegistrar implements ErrorPageRegistrar {

    /**
     *这个方法，添加具体的错误处理逻辑（类似web.xml里面配置错误处理方法），这也是一种全局的异常处理
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //具体的错误码错误异常页面
        ErrorPage e400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/templates/front/400.html");
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/templates/front/404.html");
//        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
        //这里还可以添加自定义异常以及指定处理页面之类的
       // System.out.println("你给我发送了没有");
        registry.addErrorPages(e400,e404);
    }
}