# spring-boot-project

Install Docker before use

Create mysql database before use:

1. Pull mysql image from docker:
docker pull mysql
2. Run mysql container:
docker run -e MYSQL_ROOT_PASSWORD=test -p 3306:3306 -d mysql:latest
3. Switch to bash inside docker container:
docker exec -it CONTAINER_ID bash
4. Switch to root user:
mysql -u root -p
5. Create table using script in create-table-script.mysql


Run main method from IntelliJ IDEA, send requests to localhost:8080
Endpoints with examples:

POST /addUser
{
    "firstName": "Jack",
    "lastName": "Doe",
    "membershipId": 1111
}

GET localhost:8080/getUser/Jack

DELETE localhost:8080/deleteUser/Jack
