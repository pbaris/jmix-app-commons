---
authors:
- Panos Bariamis

date: 2025-05-20
---

# Jmix AppCommons Documentation

This add-on provides common utilities and components for applications built with the Jmix framework.

It aims to streamline development by offering reusable modules that can be integrated into various Jmix applications.

## Installation

The following table shows which version of the add-on is compatible with which version of the platform:

| Jmix Version | Add-on Version | Implementation                                       |
|--------------|----------------|------------------------------------------------------|
| 1.2.14       | 2.5.2          | gr.netmechanics.jmix:jmix-app-commons-starter:1.2.14 |
| 1.3.0        | 2.6.0          | gr.netmechanics.jmix:jmix-app-commons-starter:1.3.0  |

Add to your project's `build.gradle` the repository:

```gradle
maven {
    url = 'https://nexus.nmlabs.gr/repository/m2public/'
}
```

Add to your project's `build.gradle` dependencies:

```gradle
implementation 'gr.netmechanics.jmix:jmix-app-commons-starter:<addon-version>'
```
