package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * springMVC数据响应方式1
     *
     * @return
     */
    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save running....");
        return "success";
    }

    /**
     * springMVC数据响应方式2
     *
     * @return
     */
    @RequestMapping("/quick2")
    public ModelAndView save2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "李四");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * springMVC数据响应方式3
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "王五");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * springMVC数据响应方式4
     *
     * @param model
     * @return
     */
    @RequestMapping("/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "赵六");
        return "success";
    }

    /**
     * springMVC数据响应方式5
     *
     * @param request
     * @return
     */
    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "王大锤");
        return "success";
    }

    /**
     * springMVC回写数据
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello world");
    }

    /**
     * 添加ResponseBody注解，标志为此方法为回写数据，不做视图处理
     *
     * @return
     */
    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() {
        return "hello world";
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"李四\",\"password\":18}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws JsonProcessingException {
        User user = new User();
        user.setAge(30);
        user.setName("李四");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping("/quick10")
    @ResponseBody
    public User save10() {
        User user = new User();
        user.setAge(10);
        user.setName("王五");
        return user;
    }

    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }
}
