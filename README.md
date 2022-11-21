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

### Comments
> Note:  I couldn't make the migration with flyway, but at least I try it. Was always in pending status.
