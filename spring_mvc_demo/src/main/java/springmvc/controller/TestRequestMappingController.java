package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
* 1、@RequestMapping注解的位置
* @RequestMapping标识一个类：设置映射请求的请求路径的初始信息
* @RequestMapping标识一个方法：设置映射请求请求路径的具体信息
*
* 2、@RequestMapping注解的value属性
* @RequestMapping注解的value属性通过请求的请求地址匹配请求映射
* @RequestMapping注解的value属性是一个字符串类型的数组，表示该请求映射能够匹配多个请求地址所对应的请求
* @RequestMapping注解的value属性必须设置，至少通过请求地址匹配请求映射
*
* 3、@RequestMapping注解的method属性
* @RequestMapping注解的method属性通过请求的请求方式（get或post）匹配请求映射
* @RequestMapping注解的method属性是一个RequestMethod类型的数组，表示该请求映射能够匹配多种请求方式的请求
* 若当前请求的请求地址满足请求映射的value属性，但是请求方式不满足method属性，则浏览器报错
* 405：Request method 'POST' not supported
* SpringMVC中提供了@RequestMapping的派生注解
> 处理get请求的映射-->@GetMapping
> 处理post请求的映射-->@PostMapping
> 处理put请求的映射-->@PutMapping
> 处理delete请求的映射-->@DeleteMapping
*
* 4、@RequestMapping注解的params属性（了解）
* @RequestMapping注解的params属性通过请求的请求参数匹配请求映射
* @RequestMapping注解的params属性是一个字符串类型的数组，可以通过四种表达式设置请求参数和请求映射的匹配关系
>"param"：要求请求映射所匹配的请求必须携带param请求参数
>"!param"：要求请求映射所匹配的请求必须不能携带param请求参数
>"param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
>"param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
*
* 5、@RequestMapping注解的headers属性（了解）
* @RequestMapping注解的headers属性通过请求的请求头信息匹配请求映射
* @RequestMapping注解的headers属性是一个字符串类型的数组，可以通过四种表达式设置请求头信息和请求映射的匹配关系
> "header"：要求请求映射所匹配的请求必须携带header请求头信息
> "!header"：要求请求映射所匹配的请求必须不能携带header请求头信息
> "header=value"：要求请求映射所匹配的请求必须携带header请求头信息且header=value
> "header!=value"：要求请求映射所匹配的请求必须携带header请求头信息且header!=value
* 若当前请求满足@RequestMapping注解的value和method属性，但是不满足headers属性，此时页面显示404错误，即资源未找到
*
* 6、SpringMVC支持ant风格的路径
>？：表示任意的单个字符
>*：表示任意的0个或多个字符
>**：表示任意层数的任意目录
* 注意：在使用**时，只能使用**写在双斜线中，前后不能有任何的其他字符
*
* 7、SpringMVC支持路径中的占位符（重点）
* 方式：/deleteUser?id=1
* rest方式：/user/delete/1
* SpringMVC路径中的占位符常用于RESTful风格中，当请求路径中将某些数据通过路径的方式传输到服
> 务器中，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在
> 通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
* */

@Controller
//@RequestMapping("/demo")
public class TestRequestMappingController {

    //此时请求映射所映射的请求的请求路径为：/demo/hello
    @RequestMapping(value = {"/hello","/abc"},
                    method = {RequestMethod.POST,RequestMethod.GET},
                    //params = {"username","!password","age=20"},
                    headers = {"referer"}
    )
    public String hello(){
        return "success";
    }

    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id,@PathVariable("username") String username){
        System.out.println("id:" + id + ",username:" + username);
        return "success";
    }
}
