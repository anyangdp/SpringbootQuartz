package com.sq.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sq.domain.QrtzTrigger;

public interface QrtzTriggerDao extends CrudRepository<QrtzTrigger, Long>{
	
	List<QrtzTrigger> findAll();
	
}
