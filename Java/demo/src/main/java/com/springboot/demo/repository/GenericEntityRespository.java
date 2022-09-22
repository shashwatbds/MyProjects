package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.demo.entity.GenericEntity;

public interface GenericEntityRespository extends JpaRepository<GenericEntity, Long>{

}
