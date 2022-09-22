#!/bin/bash

# Run kotlin skeleton
(cd skeletons/kotlin/; ./gradlew bootRun --args="$1")
