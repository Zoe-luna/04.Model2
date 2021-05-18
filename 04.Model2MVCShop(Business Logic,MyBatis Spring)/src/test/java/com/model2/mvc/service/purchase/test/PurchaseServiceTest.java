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

/*
 *	FileName :  PurchaseServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	// ==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	@Test
	public void testAddPurchase() throws Exception {
		Purchase purchase = new Purchase();
		User user = new User();
		Product prod = new Product();
		
		user.setUserId("user01");
		prod.setProdNo(10030);
		
		purchase.setTranNo(10020);
		purchase.setReceiverName("�Ϸ�");
		purchase.setTranCode("5");
		purchase.setTranNo(50);

		purchaseService.addPurchase(purchase);

		// product = productService.getProduct(10000);

		// ==> console Ȯ��
		// System.out.println(user);

		// ==> API Ȯ��
		Assert.assertEquals("user01", purchase.getBuyer().getUserId());
		Assert.assertEquals(10030, prod.getProdNo());
		Assert.assertEquals("�Ϸ�", purchase.getReceiverName());
		Assert.assertEquals("5", purchase.getTranCode());
		Assert.assertEquals(50, purchase.getTranNo());
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
