package com.demo.spring.mongo.spark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private QueryDataService queryDataService;

	@Override
	public double getDuration(String sno) {
		log.info("testing logging with lombok");
		return queryDataService.queryData(sno);
	}

}
