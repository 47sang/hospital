package com.api.hospital;

import com.api.hospital.mapper.PraiseAndCollectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@Slf4j
@SpringBootTest
class HospitalApplicationTests {


	@Resource
	PraiseAndCollectMapper praiseAndCollectMapper;

	@Test
	void contextLoads() {

	}

}
