package com.ceres.store.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ceres.store.application.dto.OrderDto;
import com.ceres.store.entity.GoodsEntity;
import com.ceres.store.entity.ItemsEntity;
import com.ceres.store.entity.NoticeEntity;
import com.ceres.store.entity.OrdersEntity;
import com.ceres.store.entity.TypeEntity;
import com.ceres.store.infrastructure.GoodsRepository;
import com.ceres.store.infrastructure.ItemsRepository;
import com.ceres.store.infrastructure.NoticeRepository;
import com.ceres.store.infrastructure.OrdersRepository;
import com.ceres.store.infrastructure.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    public void createTypes(List<String> types) {
        List<TypeEntity> typeEntities = types.stream()
                .map(type -> TypeEntity.builder().name(type).createdAt(new Date()).updatedAt(new Date()).build())
                .collect(Collectors.toList());
        typeRepository.saveAll(typeEntities);
    }

    @Transactional
    public List<OrderDto> notice(Long id) {
        List<OrderDto> results = new ArrayList<>();
        Optional<NoticeEntity> noticeEntityOptional = noticeRepository.findByUser(id);

        if (!noticeEntityOptional.isPresent()) {
            noticeRepository.save(NoticeEntity.builder().user(id).check(new Date()).build());
            return results;
        }

        NoticeEntity noticeEntity = noticeEntityOptional.get();

        if (noticeEntity.getCheck() == null) {
            noticeEntity.setCheck(new Date());
        }

        ordersRepository.findAll().stream().filter(order -> order.getCreatedAt().after(noticeEntity.getCheck()))
                .forEach(order -> {
                    List<ItemsEntity> saved = itemsRepository.findByOrder(order.getId());
                    OrderDto orderDto = OrderDto.builder().id(order.getId()).user(order.getUser())
                            .goods(saved.stream().map(s -> s.getGoods()).collect(Collectors.toList()))
                            .nums(saved.stream().map(s -> s.getNums()).collect(Collectors.toList())).build();
                    results.add(orderDto);
                });

        return results;
    }

    @Transactional
    public void clear(Long id) {
        NoticeEntity noticeEntity = noticeRepository.findByUser(id).get();
        noticeEntity.setCheck(new Date());
    }

    public List<OrderDto> oldOrder(Long id) {
        List<OrderDto> results = new ArrayList<>();
        Optional<NoticeEntity> noticeEntityOptional = noticeRepository.findByUser(id);

        if (!noticeEntityOptional.isPresent()) {
            noticeRepository.save(NoticeEntity.builder().user(id).check(new Date()).build());
            return results;
        }

        NoticeEntity noticeEntity = noticeEntityOptional.get();

        if (noticeEntity.getCheck() == null) {
            noticeEntity.setCheck(new Date());
        }

        ordersRepository.findAll().stream().filter(order -> order.getCreatedAt().before(noticeEntity.getCheck()))
                .forEach(order -> {
                    List<ItemsEntity> saved = itemsRepository.findByOrder(order.getId());
                    OrderDto orderDto = OrderDto.builder().id(order.getId()).user(order.getUser())
                            .goods(saved.stream().map(s -> s.getGoods()).collect(Collectors.toList()))
                            .nums(saved.stream().map(s -> s.getNums()).collect(Collectors.toList())).build();
                    results.add(orderDto);
                });

        return results;
    }

    public List<OrderDto> myOrder(Long id) {
        List<OrderDto> results = new ArrayList<>();
        ordersRepository.findAllByUser(id).forEach(order -> {
            List<ItemsEntity> saved = itemsRepository.findByOrder(order.getId());
            OrderDto orderDto = OrderDto.builder().id(order.getId()).user(order.getUser())
                    .goods(saved.stream().map(s -> s.getGoods()).collect(Collectors.toList()))
                    .nums(saved.stream().map(s -> s.getNums()).collect(Collectors.toList())).build();
            results.add(orderDto);
        });

        return results;
    }

}
