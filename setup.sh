#!/bin/bash

docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=store -d mysql


docker run -it -p 9000:9000 --name minio \
-d --restart=always \
-e "MINIO_ACCESS_KEY=admin" \
-e "MINIO_SECRET_KEY=admin123456" \
-v /mnt/minio/data:/data \
-v /mnt/minio/config:/root/.minio \
minio/minio server /data