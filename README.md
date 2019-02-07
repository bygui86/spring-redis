
# Spring Boot Redis sample project

## Sub-projects

Spring Boot Redis sample projects:
* Redis as DB - Spring Data Redis
* Redis for caching - Spring Caching
* Messaging with Redis - Spring Data Redis

---

## Prerequisites

* docker
* curl / httpie / postman

---

## Run sample

Start Redis
```
docker run -d --rm --name redis -p 6379:6379 redis:alpine redis-server --appendonly yes'
```

Start application
```
cd <PROJECT_ROOT_FOLDER>/<SUB_PROJECT_FOLDER>
mvnw clean package spring-boot:run
```

Now you can call the exposed endpoints.

PLEASE NOTE: A bench of sample data are loading automatically in the DB.

---

## Exposed endpoints

* Redis as DB
	* GET /posts   -->   Get all posts
	* GET /posts/{id}   -->   Get post by id
	* POST /posts   -->   Insert new post
	* PUT /posts   -->   Update existing post
	* DELETE /posts   -->   Delete all posts
	* DELETE /posts/{id}   -->   Delete post by id

* Redis for caching
	* GET /posts   -->   Get all posts
	* GET /posts/{id}   -->   Get post by id
	* POST /posts   -->   Insert new post
	* PUT /posts   -->   Update existing post
	* DELETE /posts   -->   Delete all posts
	* DELETE /posts/{id}   -->   Delete post by id
	* GET /cache   -->   Get all cache keys
	* GET /cache/{key}   -->   Get cache by key
	* DELETE /cache   -->   Evict whole cache
	* DELETE /cache/{key}   -->   Evict cache by key

* Messaging with Redis
	TBD

PLEASE NOTE: URL root http://localhost:8080

---

## Links

### Redis as DB

* https://www.baeldung.com/spring-data-redis-tutorial

### Redis for caching

* https://medium.com/@MatthewFTech/spring-boot-cache-with-redis-56026f7da83a
* https://www.baeldung.com/spring-boot-evict-cache
* https://www.baeldung.com/spring-cache-tutorial

### Messaging with Redis

* https://spring.io/guides/gs/messaging-redis/
* https://dzone.com/articles/intro-to-redis-with-spring-boot

### Redis

* https://blog.serverdensity.com/monitor-redis/
* https://dzone.com/articles/6-crucial-redis-monitoring-metrics-you-need-to-wat

### Others

* https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
* https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
