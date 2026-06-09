# Traits

## HasListColumnLabel
<!-- md:version 1.0.0 -->

An interface that can be implemented by entities to provide a label for display in list columns, especially when using `AbstractListColumnRenderer`.

```java
public interface HasListColumnLabel {
    String getListColumnLabel();
}
```

## HasTags
<!-- md:version 1.0.0 -->

An interface that should be implemented by entities that have tags, which can then be rendered using the `TagsRenderer`.

```java
public interface HasTags {
    Collection<String> getTagValues();
}
```
