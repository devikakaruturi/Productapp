package com.capgemini.productapp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.repository.ProductRepository;
import com.capgemini.productapp.service.ProductService;
import com.capgemini.productapp.service.impl.ProductServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	private MockMvc mockMvc;
	/*@Autowired
	private ProductServiceImpl productServiceImpl;*/
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(productServiceImpl).build();
	}
	@Test
	public void testAddProduct() {
		System.out.println("in");
		Product product = new Product(123,"car","vechicle",600000.0);
		when(productRepository.save(product)).thenReturn(product);
		Product result = productServiceImpl.addProduct(product);
		assertEquals(result,product);
	}

}
