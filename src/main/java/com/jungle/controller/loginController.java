package com.jungle.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.jungle.service.SysUserService;
import com.jungle.serviceimpl.SysUserserviceimpl;

import com.jungle.utils.CRCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by wangjiang on 2019/10/22.
 */

@Controller
public class loginController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(loginController.class);

    @Autowired
    private SysUserserviceimpl sysUserservice;

    @Autowired
    private Producer captchaProducer;

    @RequestMapping("/")
    public String hello() {
        CRCUtil.appendCrc16("JUNGLE");
        System.out.println("111111111");
        System.out.println(sysUserservice.findByUserid("jungle"));
        return "login";
    }


    @GetMapping("/getKaptchaImage")
    public void getKaptchaImage(HttpServletResponse response, HttpSession session) throws Exception {

        response.setDateHeader("Expires", 0);

        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        //request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //将验证码存到session
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public String singleFile(@RequestParam("file") MultipartFile[] files) {
        //判断非空
        if (null == files && files.length == 0) {
            return null;
        }
        String filePath = "D:\\Program Files\\upload\\";
        for (MultipartFile mf : files) {
            //文件名称
            String filename = mf.getOriginalFilename();
            if (mf.isEmpty()) {
                return "文件名称："+ filename +"上传失败，原因是文件为空!";
            }
            File dir = new File(filePath + filename);

            try {
                //写入文件
                mf.transferTo(dir);
                logger.info("文件名称："+ filename +"上传成功");
            } catch (IOException e) {
                logger.error(e.toString(), e);
                return "文件名称："+ filename +"上传失败";
            }
        }
        return "多文件上传成功";
    }

    @RequestMapping("/upload")
    public  String upload(){
        System.out.println("111111111");
        System.out.println(sysUserservice.findByUserid("jungle"));
        return "upload";

    }

}
