package com.example.shop.order;

import com.example.shop.model.Order;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private Long nextId = 1L;

    // 주문 생성
    public Order createOrder(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    // 주문 목록 조회
    public List<Order> getAllOrders() {
        return orders;
    }

    // 개별 주문 조회
    public Order getOrderById(Long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다."));
    }

    // 주문 취소
    public void cancelOrder(Long id) {
        Optional<Order> orderOpt = orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();

        if (orderOpt.isPresent()) {
            orderOpt.get().setStatus("취소됨");
        } else {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
    }
}
