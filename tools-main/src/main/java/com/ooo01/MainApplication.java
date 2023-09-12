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
        String context = environment.getProperty("server.servlet.context-path");
        String port = environment.getProperty("server.port");
        System.out.println("http://localhost:" + port + context + "/doc.html");
        System.out.println("http://127.0.0.1:" + port + context + "/doc.html");
        System.out.println("http://" + ip + ":" + port + context + "/doc.html");
    }
}
