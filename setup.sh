#!/bin/bash

docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=store -d mysql
