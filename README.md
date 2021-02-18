# Disaster-response-management
A disaster-response-management system.

## How to build:

1. Create folder named `Disaster-response-management`, and cd into it.
```console
mkdir Disaster-response-management && cd Disaster-response-management
```
2. Clone the repository
```console
git clone https://github.com/riko-net/Disaster-response-management.git .
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
