package com.express.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.pojo.Collections;
import com.express.pojo.Product;
import com.express.service.CollectionsService;
import com.express.service.ProductService;
import com.express.utils.MySortList;

@Controller
public class CollectionsController {
	@Resource
	CollectionsService  collectionsService;
	@Resource
	ProductService productService;
//个人收藏
	@RequestMapping("/likeProduct")
	public @ResponseBody String likeProduct(Model model,HttpServletRequest request) throws Exception{
		int productid=Integer.parseInt( request.getParameter("productId") );
		String tel=request.getParameter("tel");
		Collections collections=new Collections();
		collections.setProductid(productid);
		collections.setTel(tel);
		int result=collectionsService.insert(collections);
		String message=null;
		if(result==1){
			message="收藏成功";
			model.addAttribute("message", message);
		}else{
			message="收藏失败";
			model.addAttribute("message", message);
		}
		return message;
		
	}

//收藏的列表
	@RequestMapping("/likeList")
	public  @ResponseBody List<Product> likeList(Model model,HttpServletRequest request) throws Exception{
		String tel = request.getParameter("tel");
		List<Product> productList=productService.selectByTel(tel);
		//排序(到序)
		 MySortList<Product> msList = new MySortList<Product>();
	     msList.sortByMethod(productList, "getProductid", true); 
	     
		model.addAttribute("productList", productList);
		return productList;
		
			
	}

}
