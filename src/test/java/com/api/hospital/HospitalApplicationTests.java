package com.api.hospital;

import com.api.hospital.service.intf.AritcleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HospitalApplicationTests {

	@Resource
	AritcleService aritcleService;

	@Test
	void contextLoads() {

	}

}
