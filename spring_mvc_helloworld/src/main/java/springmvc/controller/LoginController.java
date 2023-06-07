package springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model){
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        if (username.equals("admin")&& password.equals("123456")){
            model.addAttribute("name",username);
            return "welcome";
        }else
            return "error";
    }

    @RequestMapping("/getMessage")
    public void getMessage(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);

        response.getWriter().println(username);
        response.getWriter().println(password);
    }

    @RequestMapping("/getMvc")
    public ModelAndView getMvc(){
        ModelAndView mvc = new ModelAndView();
        //向请求域中共享数据
        mvc.addObject("test","hello,ModelAndView");
        //设置视图，实现页面跳转
        mvc.setViewName("success");
        return mvc;
    }


    /*@RequestMapping("/getRE")
    public ResponseEntity getRE(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");

        return ResponseEntity.ok(user);

        //return ResponseEntity.ok(new User("admin","123456"));

    }*/

    @RequestMapping(value = "/getRE", method = RequestMethod.GET)
    public ResponseEntity<String> getRE() throws InterruptedException {
        return new ResponseEntity<>("success.", HttpStatus.OK);
    }
}
