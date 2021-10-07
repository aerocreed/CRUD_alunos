package br.com.springboot.controller;

import br.com.springboot.model.User;
import br.com.springboot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AppController {
    @Autowired
    private UserServices userServices;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<User> listUser = userServices.listAll();
        model.addAttribute("users", listUser);
        return "index";
    }

    @RequestMapping("/new")
    public String newStudent(Model model){
        User user = new User();
        model.addAttribute(user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute ("user") User user){
        userServices.save(user);
        return "redirect:/";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable (name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userServices.get(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("delete/{id}")
    public String deleteUserPage(@PathVariable (name="id") Long id){
        userServices.delete(id);
        return "redirect:/";
    }
}
