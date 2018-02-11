package com.express.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.pojo.Person;
import com.express.service.PersonService;

@Controller
public class PersonController {
	@Resource
	PersonService personService;
	//要转换成Json输出    @ResponseBody Person
	
	//根据@RequestMapping，跟方法的 返回类型无关系， 网址：http://127.0.0.1:8080/express/login
	
	@RequestMapping("/login")
	//登录
	public  @ResponseBody Person login(Model model,HttpServletRequest request){
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		Person person=new Person();
		person.setTel(tel);
		person.setPassword(password);
		
		Person isPerson=null;
		try {
			isPerson = personService.selectByPerson(person);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isPerson==null){
			model.addAttribute("info","error");
		}else{
			model.addAttribute("info","success");
			model.addAttribute("person",isPerson);
		}
		return isPerson ;	
	}
	
	@RequestMapping("/register")
	public  @ResponseBody int register(Model model,HttpServletRequest request){
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		Person person=new Person();
		person.setTel(tel);
		person.setPassword(password);
		person.setNickname(nickname);
		person.setBirth(birth);
		person.setSex(sex);
		
		int isRegister=0;
		try {
			isRegister = personService.insert(person);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isRegister!=1){
			model.addAttribute("info","error");
		}else{
			model.addAttribute("info","success");
			model.addAttribute("person",person);
		}
		return isRegister;	
	}
	
	//更换头像
	@RequestMapping("/updateIconUrl")
	public @ResponseBody Person updateIconUrl(Model model,HttpServletRequest request) throws Exception{
		String tel =request.getParameter("tel");
		String password =request.getParameter("password");
		String userIconUrl =request.getParameter("userIconUrl");
		
		Person person= new Person();
		person.setTel(tel);
		person.setPassword(password);
		person = personService.selectByPerson(person);
		
		person.setUserIconUrl(userIconUrl);
		//更新成功
		int result=personService.updateIconUrl(person);
		if(result!=0){
			//Person newPerson = personService.selectByPerson(person);
			model.addAttribute("person", person);
			return person;
		}else{
			model.addAttribute("person", null);
			return null;
		}
		
		
	}
	
	//更新自己信息
	@RequestMapping("/updateInfo")
	public @ResponseBody Person updateInfo(Model model,HttpServletRequest request) throws Exception{
		String tel =request.getParameter("tel");
		String password =request.getParameter("password");
		String nickname=request.getParameter("nickname");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		
		Person person= new Person();
		person.setTel(tel);
		person.setPassword(password);
		person = personService.selectByPerson(person);
		
		person.setBirth(birth);
		person.setNickname(nickname);
		person.setSex(sex);
		//更新成功
		int result=personService.updateInfo(person);
		if(result!=0){
			model.addAttribute("person", person);
			return person;
		}else{
			model.addAttribute("person", null);
			return null;
		}
		
		
	}
}
