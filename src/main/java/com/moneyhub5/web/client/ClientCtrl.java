package com.moneyhub5.web.client;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moneyhub5.web.cmm.IConsumer;
import com.moneyhub5.web.cmm.IFunction;
import com.moneyhub5.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/client")
@Log4j//sysout 같은 녀석이다.
public class ClientCtrl<T> {
	private static final Logger logger = LoggerFactory.getLogger(ClientCtrl.class);
	@Autowired Client client;
//	@Autowired ClientServiceImpl clientService;
	@Autowired Printer printer;
	@Autowired ClientMapper clientMapper;
	@Autowired Map<String, Object> map;
	
	@GetMapping("/{cid}/exist")
	public Map<?, ?> existId(@PathVariable String cid){
		printer.accept("exist들어옴"+cid);
		IFunction<String, Integer> p = o -> clientMapper.existId(cid);
		map.clear();
		map.put("msg",(p.apply(cid)==0) ?  "SUCCESS" :  "FAIL");		
		return map;
	}
	
//	@PostMapping("/")//아이디의 유무로 판단
//	public Client join(@RequestBody Client param) {			
////		logger.info("AJAX 가 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
//		printer.accept("람다 프린터가 출력한 값" + param.getCid() + "," + param.getPwd());
//		user.setCid(param.getCid());
//		user.setCid(param.getPwd());
////		clientService.join(param);
////		logger.info("map에 담긴 아이디 와 비번 {}" , user.toString());
//		return user;
//	}
	
//	@PostMapping("/")//아이디의 유무로 판단
//	public String join(@RequestBody Client param) {			
//		logger.info("AJAX 가 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
////		IConsumer c = new IConsumer() {	
//		new IConsumer() {	
//			@Override
//			public void accept(Object o) {
//				clientMapper.insertClient(param);
//			}
//		};
//		return "SUCCESS";
//	}
	
	@PostMapping("/")//아이디의 유무로 판단
	public Map<?, ?> join(@RequestBody Client param) {	
		printer.accept("join들어옴" + param.toString());
		logger.info("AJAX 가 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
		IConsumer<Client> c = t -> clientMapper.insertClient(param);	
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
	
//	@PostMapping("/login")
//	public Client login(@RequestBody Client param) {
////		IFunction f = new IFunction() {
////			
////			@Override
////			public Object apply(Object o) {				
////				return clientMapper.selecByIdPw(param);
////			}
////		};
////		Client c = (Client) f.apply(param);
//		Client c = (Client) (new IFunction() {
//			
//			@Override
//			public Object apply(Object o) {				
//				return clientMapper.selecByIdPw(param);
//			}
//		}).apply(param);
//		return c;
//	}
	
//	@PostMapping("/login")
//	public Object login(@RequestBody Client param) {
//		return new IFunction() {
//			@Override
//			public Object apply(Object o) {				
//				return clientMapper.selecByIdPw(param);
//			}
//		}.apply(param);
//	}
	
//	@PostMapping("/login")
//	public Client login(@RequestBody Client param) {
//		IFunction f = o -> clientMapper.selecByIdPw(param);			
//		return (Client) f.apply(param);
//	}
	
//	@PostMapping("/login")
//	public Object login(@RequestBody Client param) {
//		IFunction f = o -> clientMapper.selecByIdPw(param);			
//		return f.apply(param);
//	}
	
	@PostMapping("/{cid}")
	public Client login(@PathVariable String cid, @RequestBody Client param) {
		logger.info("AJAX 가 보낸 아이디 와 비번 {}" , param.getCid() + "," + param.getPwd());
		IFunction<Client, Client> f = t -> clientMapper.selecByIdPw(param);			
		return f.apply(param);
	}
	
	@GetMapping("/{cid}")
	public Client searchClient(@PathVariable String cid, @RequestBody Client param) {
		IFunction<Client, Client> f = t -> clientMapper.selecByIdPw(param);			
		return f.apply(param);
	}
	
	@PutMapping("/{cid}")
	public String updateClient(@PathVariable String cid, @RequestBody Client param) {
		IConsumer<Client> c = t -> clientMapper.insertClient(param);		
		return "SUCCESS";
	}
	
	@DeleteMapping("/{cid}")
	public String removeClient(@PathVariable String cid, @RequestBody Client param) {
		IConsumer<Client> c = t -> clientMapper.insertClient(param);	
		c.accept(param);
		return "SUCCESS";
	}
	
	
	
}
