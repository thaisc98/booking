# Hotel Booking

### Logic
![image](https://user-images.githubusercontent.com/27523071/202915271-603e8d9f-a219-43a2-84d6-2b1a8f73ec3a.png)

### Check maven command
```
mvn --version
```
Note: if does not have mvn command please install it

### Build project
```
mvn clean install
```
### Run project
```
mvn spring-boot:run
```
### Run project with Docker

```
docker build . -t hotel/booking
```
```
docker run -p 8080:8080 hotel/booking
```
> With you want to build the image with spring boot the command is:
> ```
>  mvn spring-boot:build-image
> ```

### Postman - Sharing the collection

```
https://api.postman.com/collections/9534617-2411e131-4c19-452d-b06c-e2f0fe6d5d63?access_key=PMAT-01GJC5W8V6PGJM190BW169FQMJ
```

## Swagger URL
```
http://localhost:8080/swagger-ui/index.html
```
### Comments
> Note:  I couldn't make the migration with flyway, but at least I try it. Was always in pending status.
