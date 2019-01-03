Pingboard.in Java API
=====================

Java implementation of the [pingboard.in API](https://pinboard.in/api/).

[![Release](https://jitpack.io/v/jfisbein/pinboard-java-api.svg)](https://jitpack.io/#jfisbein/pinboard-java-api)

Usage
-----

### add to your project
#### maven
add the [jitpack](https://jitpack.io) repository to your project:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
add the library dependency to you pom.xml:
```xml
<dependency>
    <groupId>com.github.jfisbein</groupId>
    <artifactId>pinboard-java-api</artifactId>
    <version>0.1.0</version>
</dependency>
```

gradle: check https://jitpack.io/#jfisbein/pinboard-java-api

### Start using it 
```java
    PinboardApi api = Pinboard.getApi("usertoken");
    PostsResponse response = api.getRecentPosts(null, 5).execute().body();
    response.getPosts().forEach(System.out::println);
```

## Javadoc
Javadoc is hosted on jitpack: https://jitpack.io/com/github/jfisbein/pinboard-java-api/latest/javadoc/
