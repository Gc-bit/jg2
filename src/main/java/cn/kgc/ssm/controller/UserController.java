package cn.kgc.ssm.controller;

import cn.kgc.ssm.bean.User;
import cn.kgc.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //tologin
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/dologin.html")
    public  String dologin(@RequestParam("userCode") String userCode,
                           @RequestParam("userPassword") String userPassword,
                           HttpServletRequest request,
                           HttpSession session){
        User user = userService.getUserByUserCode(userCode);
        if (user == null){
            request.setAttribute("error","用户名错误");
            return "login";
        }else{
            if (!user.getUserPassword().equals(userPassword)){
                request.setAttribute("error","密码错误");
                return "login";
            }else{
                session.setAttribute("userSession",user);
                return "redirect:/user/main.html";
            }
        }

    }
    @RequestMapping("/main.html")
    public String main(HttpServletRequest request,HttpSession session){
        Object userSession = session.getAttribute("userSession");
        if (userSession != null){
            return "frame";
        }

        request.setAttribute("error","请先登录");
        return "login";
    }

    @RequestMapping("/userList")
    public String providerList(){
        return "userlist";
    }
    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
        }
