package com.sq.dao;

import org.springframework.data.repository.CrudRepository;

import com.sq.domain.QrtzCronTrigger;
import com.sq.domain.QrtzCronTriggerPK;

public interface QrtzCronTriggersDao extends CrudRepository<QrtzCronTrigger, QrtzCronTriggerPK> {
	
	QrtzCronTrigger findById(QrtzCronTriggerPK id);
	
}
