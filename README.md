<!--
{% comment %}
Licensed to Julian Hyde under one or more contributor license
agreements.  See the NOTICE file distributed with this work
for additional information regarding copyright ownership.
Julian Hyde licenses this file to you under the Apache
License, Version 2.0 (the "License"); you may not use this
file except in compliance with the License.  You may obtain a
copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
either express or implied.  See the License for the specific
language governing permissions and limitations under the
License.
{% endcomment %}
-->
[![Build Status](https://github.com/julianhyde/filtex/actions/workflows/main.yml/badge.svg?branch=main)](https://github.com/julianhyde/filtex/actions?query=branch%3Amain)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.hydromatic/filtex/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.hydromatic/filtex)

# Filtex

Filter expressions.

## Get Filtex

### From Maven

Get Filtex from
<a href="https://search.maven.org/#search%7Cga%7C1%7Ca%3Afiltex">Maven central</a>:

```xml
<dependency>
  <groupId>net.hydromatic</groupId>
  <artifactId>filtex</artifactId>
  <version>0.1</version>
</dependency>
```

### Download and build

You need Java (8 or higher, 21 preferred) and Git.

```bash
$ git clone git://github.com/julianhyde/filtex.git
$ cd filtex
$ ./mvnw verify
```

On Windows, the last line is

```bash
> mvnw verify
```

On Java versions 11 or lower, you should add the follow parameters to
the Maven command:
```
-Dcheckstyle.version=9.3 -Dgraalvm.version=22.0.0.2
```

## More information

* License: <a href="LICENSE">Apache Software License, Version 2.0</a>
* Author: Julian Hyde
* Blog: https://julianhyde.blogspot.com
* Project page: http://www.hydromatic.net/filtex
* API: http://www.hydromatic.net/filtex/apidocs
* Source code: https://github.com/julianhyde/filtex
* Developers list:
  <a href="mailto:dev@calcite.apache.org">dev at calcite.apache.org</a>
  (<a href="https://mail-archives.apache.org/mod_mbox/calcite-dev/">archive</a>,
  <a href="mailto:dev-subscribe@calcite.apache.org">subscribe</a>)
* Issues: https://github.com/julianhyde/filtex/issues
* <a href="HISTORY.md">Release notes and history</a>
* <a href="HOWTO.md">HOWTO</a>
