Pingboard.in Java API
=====================

Java implementation of the [pingboard.in API](https://pinboard.in/api/).

Usage
-----
```java
PinboardApi api = Pinboard.getApi("usertoken");
PostsResponse response = api.getRecentPosts(null, 5).execute().body();
response.getPosts().forEach(System.out::println);
```