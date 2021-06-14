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
public class RecommendationEngineService {


}
