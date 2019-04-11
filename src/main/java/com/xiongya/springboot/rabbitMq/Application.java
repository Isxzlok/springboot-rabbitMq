package com.xiongya.springboot.rabbitMq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-04-10 15:40
 *
 * 自动配置
 * 1.RabbitAutoConfiguration
 * 2.有自动配置了连接工厂ConnectionFactory
 * 3.RabbitProperties封装了RabbitMQ的配置
 * 4.RabbitTemplate：给RabbitMQ发送消息
 * 5.AmpqAdmin：RabbitMQ系统管理功能组件
 * AmpqAdmin:创建和删除Queue，Exchange，Binding
 * 6.@EnableRabbit + @RabbitListener 监听消息队列
 */
@EnableRabbit
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
