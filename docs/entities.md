## StandardEntity
<!-- md:version 1.0.0 -->

A `@MappedSuperclass` that can serve as the base class for other entities, providing common fields and mappings.

It leverages Jmix’s Has UUID Trait, Versioned Trait, and Audit Traits to provide the extended entity with UUID identification, versioning, and auditing capabilities.

???+ warning "Caution:"
    As a workaround for the known issue [MappedSuperclass is enhanced incorrectly if it has no Entity subclasses in the module](https://github.com/jmix-framework/jmix/issues/317){: target="_blank" }, a class named StandardEntityWorkaround has been implemented. However, this class must not be used and exists solely as a temporary technical measure.

## Country
<!-- md:version 1.0.0 -->

An enum that provides all 249 countries, including their corresponding **ISO Alpha-2**, **ISO Alpha-3** and **ISO Numeric** codes for each country.

Can be used as a datatype in an entity and as a select field in the data views.

```java title="Entity"
@Column(name = "COUNTRY")
private String country;

public Country getCountry() {
    return country == null ? null : Country.fromId(country);
}

public void setCountry(final Country country) {
    this.country = country == null ? null : country.getId();
}
```

```xml title="Detail View"
<formLayout id="form" dataContainer="theDc">
    <select id="countryField" property="country"/>
</formLayout>
```