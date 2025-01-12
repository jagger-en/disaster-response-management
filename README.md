# Disaster-response-management
A disaster-response-management system.

1. Stop container if already running.
```bash
docker container stop postgres_instance
```

2. Start database server.
```bash
docker run --rm --name postgres_instance \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=root \
    -e POSTGRES_DB=db_palapa \
    -p 5432:5432 \
    docker.io/library/postgres:15.3
```

You can also run with
```
./utilities/python_scripts/run_database.py
```
But make sure to have the `DOCKER_HOST` env set (e.g. `DOCKER_HOST=unix:///run/user/1000/docker.sock`) in case of a similar issue to https://github.com/abiosoft/colima/issues/468.

3. Add stored procedures.
```bash
docker exec -i postgres_instance psql -U postgres -d db_palapa < ./resources/sql/stored_procedures.sql
```

4. Run application.
```bash
cd ./backend && ./mvnw spring-boot:run
```

5. Add sample data
```bash
./utilities/python_scripts/populate_database.py
```

6. Go to frontend and run locally
```bash
cd ./frontend && npm run dev
```

# Test
Make sure to start the database server and add stored procedures before
running `mvn test`.
