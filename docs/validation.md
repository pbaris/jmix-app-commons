# Validation

## @Iso639Set1
<!-- md:version 1.0.0 -->

A constraint annotation for validating that a string is a valid ISO 639-1 language code (2-letter code).

```java
@Iso639Set1
@Column(name = "LANGUAGE_CODE")
private String languageCode;
```

## @Iso3166Set1Alpha2
<!-- md:version 1.0.0 -->

A constraint annotation for validating that a string is a valid ISO 3166-1 alpha-2 country code (2-letter code).

```java
@Iso3166Set1Alpha2
@Column(name = "COUNTRY_CODE")
private String countryCode;
```
