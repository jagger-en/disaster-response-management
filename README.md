# HRManager-App
A human resource manager app.
Latest version: v1.0

## How to build:

1. Create folder named `HRManager`, and cd into it.
```console
mkdir HRManager && cd HRManager
```
2. Clone the repository
```console
git clone https://github.com/riko-net/HRManager.git .
```
3. Run a database container described in the `docker-compose.yaml` file. NOTE: [Docker](https://www.docker.com/products/docker-desktop) needs to be installed.
```console
docker-compose up -d
```
4. Build code with maven.
```console
./mvnw spring-boot:run
```
5. Finally, go to http://localhost:8080/employee or http://localhost:8080/team to see the web pages.
