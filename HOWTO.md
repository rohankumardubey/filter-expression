# Filtex HOWTO

Here's some miscellaneous documentation about using and developing Filtex.

# Release

Make sure that `./mvnw clean install site` runs on JDK 8, 11, 17 and 21
on Linux, macOS and Windows.
Also check [Travis CI](https://travis-ci.org/julianhyde/filtex).

Upgrade dependencies to their latest release: run
```bash
./mvnw versions:update-properties
```
and commit the modified `pom.xml`.

Update the [release history](HISTORY.md),
the version number at the bottom of [README](README.md),
and the copyright date in [NOTICE](NOTICE).

Switch to JDK 17.

Set up tty so that gpg can prompt for password:
```
export GPG_TTY=$(tty)
```

Check that the sandbox is clean:
```
./mvnw clean
./mvnw release:clean
git clean -nx
git clean -fx
```

Prepare and perform:
```
./mvnw -Prelease -DreleaseVersion=x.y.0 -DdevelopmentVersion=x.(y+1).0-SNAPSHOT release:prepare
./mvnw -Prelease release:perform
```

Then go to [Sonatype](https://oss.sonatype.org/#stagingRepositories),
log in, close the repository, and release.

Make sure that the [site](http://www.hydromatic.net/filtex/) has been updated.

[Announce the release](https://twitter.com/julianhyde/status/622842100736856064).
