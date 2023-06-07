package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
* SpringMVC获取请求参数
* 1、通过ServletAPI获取
* 将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
* 2、通过控制器方法的形参获取请求参数
* 在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，在
 DispatcherServlet中就会将请求参数赋值给相应的形参
* 3、@RequestParam
* @RequestParam是将请求参数和控制器方法的形参创建映射关系
* @RequestParam注解一共有三个属性：value、required、defaultValue
* 4、@RequestHeader
* @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
* 5、@CookieValue
* @CookieValue是将cookie数据和控制器方法的形参创建映射关系
* 6、通过POJO获取请求参数
* 可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实体类中的属性名一致，
* 那么请求参数就会为此属性赋值
* 7、解决获取请求参数的乱码问题
* 解决获取请求参数的乱码问题，可以使用SpringMVC提供的编码过滤器CharacterEncodingFilter，但是必须在web.xml中进行注册
* */

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",required = false,defaultValue = "hello")
                                       String username, String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId:" + jsessionId);
        System.out.println("username:" + username + ",password:" + password);
        System.out.println("referer:" + referer);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }
}
