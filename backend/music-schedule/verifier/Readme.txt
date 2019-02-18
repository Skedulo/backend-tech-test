Verifies that a submitted music scheduling program produces the expected JSON given an input JSON file.

The verifier will execute the provided command multiple times, passing in a JSON file each time and diffing
the output against a corresponding ".expected" file.

Usage:
    1. cd to the directory where you want to run the program (e.g. run.sh)
    2. Execute: <path_to_verifier> <run_command>
        - For example, ../verifier/verify-music.sh run.sh

