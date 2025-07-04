# Conventions

This section explains several conventions used in this documentation.

## Symbols

This documentation uses some symbols for illustration. Before you read
on, please make sure you've made yourself familiar with the following list of
conventions:

### <!-- md:version --> – Version { data-toc-label="Version" }

The tag symbol in conjunction with a version number denotes when a specific
feature or behavior was added. Make sure you're at least on this version
if you want to use it.


### <!-- md:default --> – Default value { #default data-toc-label="Default value" }

Some properties in `mkdocs.yml` have default values for when the author does not
explicitly define them. The default value of the property is always included.

#### <!-- md:default computed --> – Default value is computed { #default data-toc-label="is computed" }

Some default values are not set to static values but computed from other values,
like the site language, repository provider, or other settings.

#### <!-- md:default none --> – Default value is empty { #default data-toc-label="is empty" }

Some properties do not contain default values. This means that the functionality
that is associated with them is not available unless explicitly enabled.

### <!-- md:flag required --> – Required value { #required data-toc-label="Required value" }

Some (very few in fact) properties or settings are required, which means the
authors must explicitly define them.

### <!-- md:flag customization --> – Customization { #customization data-toc-label="Customization" }

This symbol denotes that the thing described is a customization that must be
added by the author.

### <!-- md:utility --> – Utility { data-toc-label="Utility" }

Besides plugins, there are some utilities that build on top of MkDocs 
to provide extended functionality, like, for example, support for versioning.

