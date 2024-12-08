# Disaster-response-management
A disaster-response-management system.

1. Stop container if already running.
```bash
docker container stop mysql_instance
```

2. Start MySQL.
```bash
docker run --rm --name=mysql_instance \
    --net=host \
    -e MYSQL_DATABASE=db_palapa \
    -e MYSQL_ROOT_PASSWORD=root \
    docker.io/library/mysql:8.4.3
```

3. Add stored procedures.
```bash
docker exec -i mysql_instance mysql --user=root --password=root < ./src/sql/points.sql
```

4. Run application.
```bash
./mvnw spring-boot:run
```
