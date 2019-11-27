package cn.kgc.ssm.controller;

import cn.kgc.ssm.bean.User;
import cn.kgc.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
    @Resource
    private UserService userService;

    @RequestMapping("/dologin.html")
    public  String dologin(@RequestParam("userCode") String userCode,
                           @RequestParam("userPassword") String userPassword,
                           HttpServletRequest request,
                           HttpSession session){
        User user = userService.getUserByUserCode(userCode);
        if (user == null){
             throw  new RuntimeException("局部异常测试.....");
        }
        return "";
        }
    @ExceptionHandler(value = {RuntimeException.class})
    public  String handlerException(RuntimeException e, HttpServletRequest req){
        req.setAttribute("error",e);
        return "error";
    }
}
