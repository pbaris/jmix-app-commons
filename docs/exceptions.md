## OnDeleteInverseDenyExceptionHandler
<!-- md:version 1.0.0 -->

An application-level exception handler designed to catch and handle **"on delete inverse deny"** errors, typically triggered when attempting to delete an entity that is still referenced by other entities with restrictive delete policies.

You can modify the message that is shown to the user in response to the error. The message is set in the message bundle with the key in the `databaseDeleteConstraintViolation.<FOREIGN_KEY_NAME>` format, for example:

```properties title="messages_en.properties"
databaseDeleteConstraintViolation.FK_NMCR_VEHICLE_ON_MODEL=Cannot delete the vehicle model because it is still used by some vehicles.
```

The handler is enabled by default. You can disable it by setting the property `jmix.appcommons.on-delete-inverse-deny-exception-handler.enabled` to false.

```properties title="application.properties"
jmix.appcommons.on-delete-inverse-deny-exception-handler.enabled=false
```