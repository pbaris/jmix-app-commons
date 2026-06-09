# Views

## StandardSettingsDetailView
<!-- md:version 1.0.0 -->

An abstract base class for creating detail views for application settings entities (entities extending `AppSettingsEntity` from the Jmix AppSettings add-on).

It provides utility methods for adjusting fields to show default values and common maps like Yes/No.

### Usage

Extend `StandardSettingsDetailView` and implement `getEntityClass()`.

```java
@ViewController("MySettings.detail")
@ViewDescriptor("my-settings-detail-view.xml")
@EditedEntityContainer("mySettingsDc")
public class MySettingsDetailView extends StandardSettingsDetailView<MySettingsEntity> {

    @Override
    protected Class<MySettingsEntity> getEntityClass() {
        return MySettingsEntity.class;
    }

    @Subscribe
    public void onInit(final InitEvent event) {
        // Use adjustDefaultField to show default value in a read-only field
        // adjustDefaultField(myField, "myProperty");
    }
}
```
