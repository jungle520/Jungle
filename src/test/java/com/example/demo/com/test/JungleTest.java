package com.example.demo.com.test;

import com.example.demo.BbsApplication;
import com.jungle.RabbitMQ.Sender;
import com.jungle.utils.CRCUtil;
import org.junit.jupiter.api.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangjiang on 2019/10/28.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= BbsApplication.class)
public class JungleTest {


    @Autowired
    private Sender helloSender;



    @Test
    public void jungle(){
        System.out.println(CRCUtil.appendCrc16("5"));
    }


    @Test
    public void hello() throws Exception {
       // helloSender.send();
    }


    @Test
    public void oneToMany() {

        for(int i=0;i<10;i++){
            System.out.println("执行"+i);
            helloSender.send("hellomsg:"+i);
        }

    }

}
