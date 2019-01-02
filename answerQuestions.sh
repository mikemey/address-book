#!/usr/bin/env bash

mvn -q clean compile
mvn exec:java -q -Dexec.mainClass="uk.mm.AddressBookMain" -Dexec.args="src/main/resources/AddressBook"