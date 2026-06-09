# Renderers

## BooleanRenderer
<!-- md:version 1.0.0 -->

A renderer for boolean columns that displays a checkmark or a cross icon instead of text.

### XML Usage

To use it in a `dataGrid` column, set the `renderer` attribute to `booleanRenderer`.

```xml
<column property="active" renderer="booleanRenderer"/>
```

#### Attributes

- **allowNull**: If set to `true`, a `null` value will be rendered as an empty cell. Default is `false`.

```xml
<column property="active">
    <v:booleanRenderer allowNull="true"/>
</column>
```

## TagsRenderer
<!-- md:version 1.0.0 -->

A renderer for entities that implement the `HasTags` interface. It displays tags as small badges with a tag icon.

### XML Usage

To use it in a `dataGrid` column, set the `renderer` attribute to `tagsRenderer`.

```xml
<column property="tags" renderer="tagsRenderer"/>
```

## AbstractListColumnRenderer
<!-- md:version 1.0.0 -->

A base class for renderers that display a collection of items as a badge showing the count. Clicking on the badge opens a dialog with a list of all items. The items should implement `HasListColumnLabel`.

This renderer must be implemented in Java by extending `AbstractListColumnRenderer`.

```java
public class MyListRenderer extends AbstractListColumnRenderer<MyEntity, MyRelatedEntity> {
    public MyListRenderer(MessageBundle messageBundle, Dialogs dialogs) {
        super("myRendererPrefix", messageBundle, dialogs);
    }

    @Override
    protected Collection<MyRelatedEntity> getItems(MyEntity item) {
        return item.getRelatedItems();
    }
}
```

The message bundle should contain keys for the count and the dialog title:
- `myRendererPrefix.count`: The message for the badge (e.g., `{0} items`).
- `myRendererPrefix.title`: The title for the dialog.
