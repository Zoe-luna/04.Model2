package com.model2.mvc.service.purchase.test;

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
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

/*
 *	FileName :  PurchaseServiceTest.java
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	// ==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Test
	public void testAddPurchase() throws Exception {
		Purchase purchase = new Purchase();
		User user = new User();
		Product prod = new Product();
		
		user.setUserId("user01");
		prod.setProdNo(10030);
		
		purchase.setReceiverName("하루");
		purchase.setTranCode("5");

		purchaseService.addPurchase(purchase);

		// System.out.println(user);

		// ==> API 확인
		Assert.assertEquals("user01", purchase.getBuyer().getUserId());
		Assert.assertEquals(10030, prod.getProdNo());
		Assert.assertEquals("하루", purchase.getReceiverName());
		Assert.assertEquals("5", purchase.getTranCode());
	}

	// @Test
	public void testGetProduct() throws Exception {

	}

	// @Test
	public void testUpdateProduct() throws Exception {

	}

	// @Test
	public void testGetProductListAll() throws Exception {

	}

	// @Test
	public void testGetProductListByProdNo() throws Exception {

	}
}
