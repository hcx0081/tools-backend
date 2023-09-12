package com.ooo01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * {@code @description:} 主应用程序类
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MainApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
        String ip = InetAddress.getLocalHost().getHostAddress();
        Environment environment = ctx.getBean(Environment.class);
        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        System.out.println("http://localhost:" + port + path + "/doc.html");
        System.out.println("http://127.0.0.1:" + port + path + "/doc.html");
        System.out.println("http://" + ip + ":" + port + path + "/doc.html");
    }
}
