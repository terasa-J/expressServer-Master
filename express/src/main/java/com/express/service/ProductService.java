package com.express.service;

import java.util.List;

import com.express.pojo.Collections;
import com.express.pojo.Person;
import com.express.pojo.Product;

public interface ProductService {
	//获得快递信息列表
	 List<Product> selectProducts() throws Exception;
	
	 //增加 快递
	 int addProduct(Product product) throws Exception;
	 //获得个人快递
	 List<Product> selectMyProducts(Person person) throws Exception;
	 //删除发布的快递
	 int deleteByPrimaryKey(Integer productid)throws Exception;
	 
	  //个人收藏列表
	  List<Product> selectByTel(String tel) throws Exception;
}
