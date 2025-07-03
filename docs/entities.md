---
authors:
- Panos Bariamis

date: 2025-05-20
---

# Entities

## StandardEntity

`@since 1.0.0`

A `@MappedSuperclass` that can serve as the base class for other entities, providing common fields and mappings.

It leverages Jmix’s Has UUID Trait, Versioned Trait, and Audit Traits to provide the extended entity with UUID identification, versioning, and auditing capabilities.

!!! warning "Caution:"
As a workaround for the known issue [MappedSuperclass is enhanced incorrectly if it has no Entity subclasses in the module](https://github.com/jmix-framework/jmix/issues/317){: target="_blank" }, a class named StandardEntityWorkaround has been implemented. However, this class must not be used and exists solely as a temporary technical measure. 