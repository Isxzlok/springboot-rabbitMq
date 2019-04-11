package com.xiongya.springboot.rabbitMq.service;

import com.xiongya.springboot.rabbitMq.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-04-10 19:39
 */
@Service
public class BookService {

    //设置监听注解，当消息进入这个队列时，自动触发该方法(该方法就相当于接受队列消息)
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息："+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive1(Message message){
        System.out.println(message.getMessageProperties());
        System.out.println(message.getBody());
    }

}
