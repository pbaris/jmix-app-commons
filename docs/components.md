# Components

## ViewLink
<!-- md:version 1.0.0 -->

A component that provides a link to a specific view in the application. It automatically hides itself when the view is opened in lookup mode.

### Attributes

- **view** <!-- md:flag required -->: The ID of the target view.
- **text**: The text to display for the link.
- **icon**: The icon to display next to the text.
- **size**: The size of the icon. <!-- md:default 1em -->

### Example

```xml
<v:viewLink id="myViewLink"
            view="MyView"
            text="Go to My View"
            icon="USER"/>
```

In order to use the component in your view, you need to add the following namespace to the root element:

```xml
<view xmlns="http://jmix.io/schema/flowui/view"
      xmlns:v="http://schemas.netmechanics.gr/jmix/ui">
    ...
</view>
```
