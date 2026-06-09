# Utils

## JsonUtil
<!-- md:version 1.0.0 -->

A utility class for JSON serialization and deserialization using Jackson. It comes pre-configured with `JavaTimeModule` to handle Java 8 Date/Time API.

Methods:
- `toJson(Object obj)`: Serializes an object to JSON string.
- `toJsonPretty(String json)`: Formats a JSON string.
- `fromJson(String json, Class<T> objClass)`: Deserializes a JSON string to an object.
- `fromJson(String json, TypeReference<T> typeReference)`: Deserializes a JSON string to a complex type.

## UiUtils
<!-- md:version 1.0.0 -->

Contains UI-related utility methods.

Methods:
- `fixInputDialogResponsiveUI(InputDialog inputDialog)`: Fixes the responsive behavior of an `InputDialog` by setting its maximum width.

## Localized Enum Sorting
<!-- md:version 1.0.0 -->

Jmix AppCommons provides a way to sort enums in UI components (like `Select` or `ComboBox`) based on their localized messages instead of their ID or order.

### Implementation

1. The enum must implement the `EnumSortLocalized` interface.

```java
public enum MyEnum implements EnumClass<String>, EnumSortLocalized<MyEnum> {
    VALUE_A("A"),
    VALUE_B("B");

    private String id;

    MyEnum(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Nullable
    public static MyEnum fromId(String id) {
        for (MyEnum at : MyEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }

    @Override
    public BiFunction<Messages, MyEnum, String> getLocalizedSortFunction() {
        return (messages, e) -> messages.getMessage(e);
    }
}
```

2. The `ExtDataViewDelegate` (which is a `@Primary` bean) will automatically detect if the enum implements `EnumSortLocalized` and apply a `CollatorComparator` for sorting.
