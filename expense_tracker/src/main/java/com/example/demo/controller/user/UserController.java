package com.example.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	@Autowired
	UserServiceImpl usi;
	
	@CrossOrigin
	@PostMapping("login")
	public ModelAndView login(String username, String password, HttpSession session) {
		User user = usi.loginUser(username, password);
		if (user!=null) {
			session.setAttribute("U", user);
			return new ModelAndView("loginSuccess");
		} else {
			return new ModelAndView("loginError");
		}
	}
	
}