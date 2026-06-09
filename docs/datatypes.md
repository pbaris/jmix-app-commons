# Data Types

## setString
<!-- md:version 1.0.0 -->

A custom datatype that stores a `Set<String>` as a single pipe-separated string in the database.

It is automatically handled by the `SetStringConverter` JPA converter when applied to an entity attribute.

```java
@Column(name = "TAGS")
@Convert(converter = SetStringConverter.class)
private Set<String> tags;
```

## listString
<!-- md:version 1.0.0 -->

A custom datatype that stores a `List<String>` as a single pipe-separated string in the database.

It is automatically handled by the `ListStringConverter` JPA converter when applied to an entity attribute.

```java
@Column(name = "OPTIONS")
@Convert(converter = ListStringConverter.class)
private List<String> options;
```
