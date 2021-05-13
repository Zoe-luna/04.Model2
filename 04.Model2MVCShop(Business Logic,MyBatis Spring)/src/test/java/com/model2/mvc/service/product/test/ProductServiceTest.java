package com.model2.mvc.service.product.test;


import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		product.setPrice(50000);
		product.setProdNo(10008);
		product.setProdDetail("testProdDetail");
		product.setProdName("testProd");
		
		productService.addProduct(product);
		
		//product = productService.getProduct(10000);

		//==> console Ȯ��
		//System.out.println(user);
		
		//==> API Ȯ��
		Assert.assertEquals("testProd", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals(10008, product.getProdNo());
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
//		//==> �ʿ��ϴٸ�...
//		product.setPrice(50000);
//		product.setProdDetail("testProdDetail");
//		product.setProdName("testProd");
//		product.setProdNo(10008);
		
		product = productService.getProduct(10020);

		//==> console Ȯ��
		//System.out.println(user);
		
		//==> API Ȯ��
		Assert.assertEquals("testProd", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals(10020, product.getProdNo());

		Assert.assertNotNull(productService.getProduct(10001));
		//Assert.assertNotNull(userService.getUser("user05"));
	}
	
	@Test
		 public void testUpdateProduct() throws Exception{
			 
			Product product = productService.getProduct(10020);
			Assert.assertNotNull(product);
			
			Assert.assertEquals("testProd", product.getProdName());
			Assert.assertEquals("testProdDetail", product.getProdDetail());
			Assert.assertEquals(50000, product.getPrice());
			Assert.assertEquals(10020, product.getProdNo());
			
			product.setProdName("testProdupdated");
			product.setProdDetail("testProdDetailupdated");
			product.setPrice(80000);
			
			productService.updateProduct(product);
			
			product = productService.getProduct(10020);
			Assert.assertNotNull(product);
			
			//==> console Ȯ��
			//System.out.println(user);
				
			//==> API Ȯ��
			Assert.assertEquals("testProdupdated", product.getProdName());
			Assert.assertEquals("testProdDetailupdated", product.getProdDetail());
			Assert.assertEquals(80000, product.getPrice());
			Assert.assertEquals(10020, product.getProdNo());
		 }
}
