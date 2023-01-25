package com.example.hw25;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import com.example.hw25.service.OrderService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Hw25Application {
    @Autowired
    private OrderService orderService;


    public static void main(String[] args) {
        SpringApplication.run(Hw25Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start(){
        orderService.createNewOrder();
        orderService.addProduct(1);
        orderService.addProduct(1);
        orderService.addProduct(2);

        System.out.println(orderService.findById(1));
        orderService.deleteOrder(1);
    }
}
