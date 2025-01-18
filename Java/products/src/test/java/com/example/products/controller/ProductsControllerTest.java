package com.example.products.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @WebMvcTest is a specialized annotation in Spring Boot used for testing Spring MVC components,
 * specifically controllers. It focuses on the web layer and configures only the necessary components for MVC testing,
 * making it lightweight and faster compared to loading the entire application context.
 *
 * @WebMvcTest(ProductsController.class) tells Spring Boot to configure only the ProductsController and related MVC components.
 * */
@WebMvcTest(ProductsController.class)
class ProductsControllerTest {

    /**
     * MockMvc is used to perform HTTP requests and verify the responses.
     * */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Purpose: Adds or replaces a bean in the Spring application context with a mock.
     * Usage: Ideal for integration tests where you need to test the interaction with the Spring context but want to mock specific beans.
     * */
    @MockitoBean
    private ProductService productService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Building MockWebMVc using web application context
     * */
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();//Loading mock application context
    }

    @Test
    void getAllProducts_shouldCombineJsonResponses() throws Exception {
        mockMvc.perform(
                get("/products").contentType(MediaType.APPLICATION_JSON))//This will call /products endpoint in ProductsController
                .andExpect(status().isOk());
    }
}
