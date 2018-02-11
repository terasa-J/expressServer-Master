package com.express.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.express.pojo.Person;
import com.express.pojo.Product;
import com.express.service.CollectionsService;
import com.express.service.PersonService;
import com.express.service.ProductService;

import com.express.utils.MySortList;

@Controller
public class ProductController {
	@Resource
	ProductService productService;
	@Resource
	CollectionsService collectionsService;
	
	//根据@RequestMapping，跟方法的 返回类型无关系， 网址：http://127.0.0.1:8080/express/productList
	//获得快递信息列表
	@RequestMapping("/productList")
	public  @ResponseBody List<Product> productList(Model model) throws Exception{
		List<Product> productList = null;
		productList = productService.selectProducts();
		
		//排序(到序)
		 MySortList<Product> msList = new MySortList<Product>();
	     msList.sortByMethod(productList, "getProductid", true);  

		model.addAttribute("productList",productList);
		return productList;
	}
	
	//添加快递
	@RequestMapping("/addProduct")
	public @ResponseBody int addProduct(Model model,HttpServletRequest request) throws Exception{
		
		String content = request.getParameter("content");
		String cid = request.getParameter("cid");
		String nickname = request.getParameter("nickname");
		String price = request.getParameter("price");
		String productUrl = request.getParameter("productUrl");
		String tel = request.getParameter("tel");   //发布者电话
		String phone = request.getParameter("phone");   //联系人电话
		String userIconUrl = request.getParameter("userIconUrl");
		String createat = request.getParameter("createat");
		String school = request.getParameter("school");
		
		
		Product product=new Product();
		product.setContent(content);
		product.setCid(Integer.parseInt(cid));
		product.setNickname(nickname);
		product.setPrice(price);
		product.setProductUrl(productUrl);
		product.setCreateat(createat);
		product.setTel(tel);
		product.setPhone(phone);
		product.setUserIconUrl(userIconUrl);
		product.setSchool(school);
		
		int num =0;
		num=productService.addProduct(product);
		
		model.addAttribute("num",num);
		
		return num;
		
	}
	
	//获得个人发布快递
	@RequestMapping("/myProduct")
	public  @ResponseBody List<Product> myProduct(Model model,HttpServletRequest request) throws Exception{
		Person person =new Person();
		String tel=request.getParameter("tel");
		person.setTel(tel);
		List<Product> productList = null;
		productList = productService.selectMyProducts(person);
		
		//排序(到序)
		 MySortList<Product> msList = new MySortList<Product>();
	     msList.sortByMethod(productList, "getProductid", true);  

		model.addAttribute("productList",productList);
		return productList;
	}

	//删除个人发布的快递
	@RequestMapping("/delMyProduct")
	public  @ResponseBody String delMyProduct(Model model,HttpServletRequest request) throws Exception{
		Person person =new Person();
		String id=request.getParameter("productid");
		String del=request.getParameter("del");
		int productid=Integer.parseInt(id);
		int isDel=0;
		if("我的发布".equals(del)){
			isDel=productService.deleteByPrimaryKey(productid);
		}else if("我的收藏".equals(del)){
			isDel=collectionsService.deleteByProductId(productid);
		}
		
		String message = null;
		if(isDel==1){
			message="删除成功";
			model.addAttribute("message",message);
		}else{
			message="删除失败";
			model.addAttribute("message",message);
		}
		return message;
	}

}
