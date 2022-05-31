package com.api.hospital;

import com.api.hospital.service.intf.PraiseAndCollectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@Slf4j
@SpringBootTest
class HospitalApplicationTests {


	@Resource
	PraiseAndCollectService praiseAndCollectService;

	@Test
	void contextLoads() {
		System.out.println(praiseAndCollectService.deletePraiseByArticleId(3));
		System.out.println(praiseAndCollectService.getCollectByPatientId(1));
	}

}
