package com.express.dao;

import java.util.List;

import com.express.pojo.Person;
import com.express.pojo.Product;

public interface ProductCustomMapper extends ProductMapper {
   
    List<Product> selectProducts() throws Exception;
    
    List<Product> selectMyProducts(Person person) throws Exception;
    
    //个人收藏列表
	  List<Product> selectByTel(String tel) throws Exception;

   
}