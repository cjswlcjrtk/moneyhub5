package com.moneyhub.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moneyhub.web.domains.ClientDTO;
import com.moneyhub.web.serviceimpls.ClientServiceImpl;


@Controller
@RequestMapping("/client/*")
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
//	@Autowired AdminServiceImpl adminService;
	@Autowired ClientDTO user;
	@Autowired ClientServiceImpl clientService;
	
	
	@PostMapping("/join")
	public @ResponseBody ClientDTO join(@RequestBody ClientDTO param) {			
		logger.info("AJAX 가 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
		user.setCid(param.getCid());
		user.setCid(param.getPwd());
		clientService.join(param);
		logger.info("map에 담긴 아이디 와 비번 {}" , user.toString());
		return user;
	}
	@PostMapping("/login")
	public @ResponseBody ClientDTO login(@RequestBody ClientDTO param) {
		logger.info("AJAX Login이 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
		user.setCid(param.getCid());
		user.setPwd(param.getPwd());
		logger.info("user에 담긴 사용자 {}" , user.toString());
		return clientService.login(param);
	}
	
	
	
	
	
	
}
