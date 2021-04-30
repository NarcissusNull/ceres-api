package com.ceres.store.infrastructure;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import io.minio.errors.MinioException;

public class MinioRepository {

    private MinioClient minioClient;

    public MinioRepository(String endpoint, String accessKey, String secretKey)
            throws InvalidEndpointException, InvalidPortException {
        // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
        this.minioClient = new MinioClient(endpoint, accessKey, secretKey);
    }

    public void upload(String bucket, MultipartFile file) {

        try {
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(bucket);
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket(bucket);
            }

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject(bucket, file.getOriginalFilename(), file.getInputStream(), new PutObjectOptions(-1, 5L * 1024 * 1024 * 1024));
        } catch (MinioException | InvalidKeyException | IllegalArgumentException | NoSuchAlgorithmException
                | IOException e) {
            System.out.println("Error occurred: " + e);
        }
    }

    public byte[] download(String bucket, String fileName) {
        try {
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(bucket);
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket(bucket);
                return null;
            }

            // 使用putObject上传一个文件到存储桶中。
            return minioClient.getObject(bucket, fileName).readAllBytes();
        } catch (MinioException | InvalidKeyException | IllegalArgumentException | NoSuchAlgorithmException
                | IOException e) {
            System.out.println("Error occurred: " + e);
            return null;
        }
    }

}
