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
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
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

		//==> console 확인
		//System.out.println(user);
		
		//==> API 확인
		Assert.assertEquals("testProd", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals(10008, product.getProdNo());
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
//		//==> 필요하다면...
//		product.setPrice(50000);
//		product.setProdDetail("testProdDetail");
//		product.setProdName("testProd");
//		product.setProdNo(10008);
		
		product = productService.getProduct(10020);

		//==> console 확인
		//System.out.println(user);
		
		//==> API 확인
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
			
			//==> console 확인
			//System.out.println(user);
				
			//==> API 확인
			Assert.assertEquals("testProdupdated", product.getProdName());
			Assert.assertEquals("testProdDetailupdated", product.getProdDetail());
			Assert.assertEquals(80000, product.getPrice());
			Assert.assertEquals(10020, product.getProdNo());
		 }
}
