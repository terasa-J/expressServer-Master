package com.express.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.pojo.Category;
import com.express.service.CategoryService;

@Controller
public class CategoryController {
	@Resource
	CategoryService categoryService;
	//查询分类
	@RequestMapping("/queryCategory")
	public @ResponseBody Category selectByPrimaryKey(Model model,HttpServletRequest request) throws Exception{
		int cid=Integer.parseInt( request.getParameter("cid") );
		Category category=categoryService.selectByPrimaryKey(cid);
		model.addAttribute("category", category);
		return category ;
		
		
	}

}
