package com.example.demo;

import com.jungle.RabbitMQ.Sender;
import com.jungle.utils.CRCUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BbsApplication.class)
public class BbsApplicationTests {

	@Autowired
	private Sender helloSender;

	@Test
	void contextLoads() {
	}

	@Test
	public void jungle(){
		System.out.println(CRCUtil.appendCrc16("5"));
	}


	@Test
	public void hello() throws Exception {
		//helloSender.send();
	}
}
