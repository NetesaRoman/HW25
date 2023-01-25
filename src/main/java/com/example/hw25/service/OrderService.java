package com.example.hw25.service;

import com.example.hw25.model.Product;
import com.example.hw25.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.hw25.model.Order;
import org.springframework.stereotype.Service;
import com.example.hw25.repository.OrderRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 *
 * @author Roman Netesa
 *
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;



    public void createNewOrder(){
        Order order = new Order();
        order.setCreationDate(LocalDate.now());
        order.setPrice(15.50d);
        orderRepository.save(order);
    }

    public void addProduct(Integer orderID){
        Product product = new Product();
        product.setName("Abrikos");
        product.setPrice(11.5d);
        Optional<Order> order = orderRepository.findById(orderID);
        product.setOrder(order.orElseThrow(() -> new EntityNotFoundException("No Order!")));

        productRepository.save(product);

    }

    public Order findById(Integer id){
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Order!"));
    }

    public List<Order> findAll(){
        ArrayList<Order> result = new ArrayList<>();
        orderRepository.findAll().forEach(result::add);
        return result;
    }

    public void deleteOrder(Integer id){
        Order target = orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Order!"));
        orderRepository.delete(target);
    }
}
