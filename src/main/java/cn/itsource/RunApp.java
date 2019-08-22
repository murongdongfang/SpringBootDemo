package cn.itsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 启动web程序
@MapperScan("cn.itsource.dao")
public class RunApp {
	
	public static void main(String[] args) {
		SpringApplication.run(RunApp.class, args);
		System.err.println("启动成功");
	}

}
