package com.express.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.express.dao.PersonCustomMapper;
import com.express.dao.ProductCustomMapper;
import com.express.pojo.Person;
import com.express.pojo.Product;
import com.express.service.PersonService;
import com.express.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService  {
	@Resource
	ProductCustomMapper productCustomMapper;

	@Override
	public List<Product> selectProducts() throws Exception {
		
		return productCustomMapper.selectProducts();
	}

	@Override
	public int addProduct(Product product) throws Exception {
		return productCustomMapper.insert(product);
	}

	@Override
	public List<Product> selectMyProducts(Person person) throws Exception {
		return productCustomMapper.selectMyProducts(person);
	}

	@Override
	public int deleteByPrimaryKey(Integer productid) throws Exception {
		return productCustomMapper.deleteByPrimaryKey(productid);
	}

	@Override
	public List<Product> selectByTel(String tel) throws Exception {
		return productCustomMapper.selectByTel(tel);
	}



}
