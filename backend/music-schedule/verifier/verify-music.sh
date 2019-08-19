#!/usr/bin/env bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
RED='\033[0;31m'
GREEN='\033[1;32m'
NONE='\033[0m'

function verify {
    FILE_PATH="$DIR/$1"

    echo ""
    echo -n "Testing $FILE_PATH.json..."

    bash $EXE $FILE_PATH.json

    if [ $? -ne 0 ]; then
      echo ""
      echo "Failed to execute $EXE"
      echo ""
      exit 1
    fi

    SOLUTION_PATH=$FILE_PATH.optimal.json

    if [ -f $SOLUTION_PATH ]; then
        normaliseJson $FILE_PATH.optimal.json > $FILE_PATH.optimal.norm.json
        normaliseJson $FILE_PATH.optimal.json.expected > $FILE_PATH.optimal.norm.json.expected

        DIFF=`diff $FILE_PATH.optimal.norm.json $FILE_PATH.optimal.norm.json.expected`
        if [ -z "$DIFF" ]; then
            echo -e "${GREEN}  OK  ${NONE}"
        else
            echo -e "${RED}  FAILED:  ${NONE}"
            echo "$DIFF"
        fi
        `rm $FILE_PATH*.norm.*`
    else
        echo -e "${RED}FAILED: No output file was found at $SOLUTION_PATH   ${NONE}"
    fi
}

function normaliseJson {
    jq -c . $1 | jq .
}

if [ $# -ne 1 ]; then
    echo "Usage: $0 <path>"
    echo "  path: Full path to the executable to test"
    echo "        The executable should take two arguments: the input and output file names"
    exit 1
fi

EXE=$1

rm -f *.optimal.json
echo "Testing executable '$EXE'"

verify "example"
verify "overlapping"
verify "time-priority"
verify "minutes-resolution"
verify "seconds-resolution"
verify "timezone"

echo ""
echo "Finished verifying"
echo ""
