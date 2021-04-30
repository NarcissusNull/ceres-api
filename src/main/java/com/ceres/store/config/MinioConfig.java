package com.ceres.store.config;

import com.ceres.store.infrastructure.MinioRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;

@Configuration
public class MinioConfig {
    
    @Value("${store.minio.endpoint}")
    private String endpoint;

    @Value("${store.minio.accessKey}")
    private String accessKey;

    @Value("${store.minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioRepository minioRepository() throws InvalidEndpointException, InvalidPortException {
        return new MinioRepository(endpoint, accessKey, secretKey);
    }
    
}
