package com.xiongya.springboot.rabbitmq;

import com.xiongya.springboot.rabbitMq.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-04-10 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 创建交换器，对列，绑定
     */
    @Test
    public void fun3(){
        //创建一个交换器
        //amqpAdmin.declareExchange(new DirectExchange("xiong-exchage"));
        //创建一个对列
        //amqpAdmin.declareQueue(new Queue("xiong",true));
        //创建一个绑定规则(第一个参数是绑定规则的目的地，也就是绑定到哪个对列，第二个参数是目的地类型，可以是对列类型，也可以是交换器类型，第三个参数是交换器名称，第四个是路由键)
        amqpAdmin.declareBinding(new Binding("xiong", Binding.DestinationType.QUEUE, "xiong-exchage", "xiongya",null));
    }


    /**
     * 单播
     * 点对点发送数据
     */
    @Test
    public void fun1(){
        //Message需要自己构造一个，定义消息体内容和消息头
        //rabbitTemplate.send(exahange,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("老人与海","海明威"));
    }

    //接受数据
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
