package cn.hejiangnan.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: StartApplication
 * @Description: 项目启动类
 * @Author: hejiangnan
 * @Date: 2020/8/3
 */
@MapperScan("cn.hejiangnan.mybatisplus.mapper")
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
