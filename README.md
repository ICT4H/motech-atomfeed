Motech-Atomfeed
========

[![Build Status](https://travis-ci.org/ICT4H/motech-atomfeed.png)](https://travis-ci.org/ICT4H/motech-atomfeed)

Motech AtomFeed is an [ATOM](https://github.com/ICT4H/simplefeed) consumer implementation that is written for the [Motech](https://code.google.com/p/motech/) platform.

It consists of the following modules

* motech-atomfeed-consumer - A generic ATOM consumer built using [an atom client](https://github.com/ICT4H/atomfeed) that uses the motech scheduler to poll the configured server periodically.
* motech-atomfeed-consumer-bundle - An OSGI wrapper around the consumer module.
* motech-openmrs-integration - An use case implementation of how OpenMRS and Motech can communicate using ATOM.

Build
-----
To build:
* mvn compile
* mvn test

To install:
* Create a Postgres DB and update atomfeed-server/maven.properties with credentials.
* mvn install -P IT -DskipTests

To start up:
* Create the DB tables by running install (see above).
* Update atomfeed-standalone/src/main/resources/atomfeed.properties with Postgres credentials.
* cd atomfeed-standalone
* mvn jetty:run -P IT

To integration test:
* mvn integration-test -P IT

## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

