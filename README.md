# Disaster-response-management
A disaster-response-management system.

## Run
1. Start database server, backend, and populate with data.
```
DOCKER_HOST=unix:///run/user/1000/docker.sock ./utilities/python_scripts/run_database.py
```
Make sure to have the `DOCKER_HOST` env set (e.g. `DOCKER_HOST=unix:///run/user/1000/docker.sock`) in case of a similar issue to https://github.com/abiosoft/colima/issues/468.

2. Go to frontend and run locally
```bash
cd ./frontend && npm run dev
```

## Test
Make sure to start the database server and add stored procedures before
running `mvn test`.
