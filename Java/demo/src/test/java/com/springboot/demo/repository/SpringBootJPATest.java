package com.springboot.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.demo.entity.GenericEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringBootJPATest {
	
	@Autowired
	private GenericEntityRespository genericEntityRepository;
	
	@Test
	public void gievnGenericEntityRepository_whenSaveAndRetrieveEntity_thenOK() {
		
		GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity(1l, "test"));
		GenericEntity foundEntity = genericEntityRepository.findById(genericEntity.getId()).get();
		assertNotNull(foundEntity);
		assertEquals(genericEntity.getValue(), foundEntity.getValue());
	}
	

}
