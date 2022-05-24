# Programming Challenge 

Hi! Welcome to the Skedulo backend tech project. Here you will be creating an optimal schedule for Sally Salamander at a music festival, ensuring that she can see her favourite shows!

Feel free to complete the test in the language you most feel comfortable with, at Skedulo we primarily work with Kotlin, Typescript, and Scala but want to make sure that you can submit your most confident work without burdening yourself learning new tools and technologies.

## The Sound of Music 
Sally Salamander is going to the ‘Big Weekend Out’ music festival, and has a list of acts she wants to see. 
Unfortunately, many of these performances overlap in time. In order to determine where to be at what time, Sally has taken the list of events published on the Big Weekend website and added a priority to each from 1 to 10 (from least to most important). 

**Performance output shape**

```
band: String 
start: DateTime 
finish: DateTime 
priority: Integer 
```

## Your Challenge 

Write a program for Sally that takes a list of Performance objects as input and produces Sally’s optimal schedule. 

An optimal schedule meets the following criteria: 
1. Sally wants to see the best performance at any given time. This may mean cutting one event short to see a higher priority performance, then returning to the original later. 
2. You can assume Sally has a teleportation device and can travel between stages instantaneously! 
3. If two performances starting at the same time have the same priority, Sally is happy to go to either one. 
4. There may also be gaps where no performances are on. 

## Instructions 
1. The program should take one argument on the command line: the path to an input file. 
2. The input file will be JSON, containing an array of Performance objects as described above. See the end of this document for an example. 
    * DateTime’s are represented as strings in ISO8601 format. 
    * To simplify the solution, you can assume the file exists, fits into memory and contains valid JSON (no need for error handling when ingesting the file). 
3. The program should create a new JSON file in the same directory as the input file, with the extension changed to ‘.optimal.json’. 
    * For example, if the input file name was ‘performances.json’, the output file name would be ‘performances.optimal.json’. 
4. The output file should represent Sally’s schedule for the festival as an array of objects, as defined below. See the end of this document for an example.

**Scheduled Performance Input**

```
band: String 
start: DateTime 
finish: DateTime 
```

Some examples include:

Input file (overlapping.json): 
```json
[ 
  { 
    "band" : "Soundgarden", 
    "start" : "1993-05-25T02:00:00Z", 
    "finish" : "1993-05-25T02:50:00Z", 
    "priority" : 5 
  }, 
  { 
    "band" : "Pearl Jam", 
    "start" : "1993-05-25T02:15:00Z", 
    "finish" : "1993-05-25T02:35:00Z", 
    "priority" : 9 
  } 
] 
```

Output file (overlapping.optimal.json): 
```json
[ 
  { 
    "band" : "Soundgarden", 
    "start" : "1993-05-25T02:00:00Z", 
    "finish" : "1993-05-25T02:15:00Z" 
  }, 
  { 
    "band" : "Pearl Jam", 
    "start" : "1993-05-25T02:15:00Z", 
    "finish" : "1993-05-25T02:35:00Z" 
  }, 
  { 
    "band" : "Soundgarden", 
    "start" : "1993-05-25T02:35:00Z", 
    "finish" : "1993-05-25T02:50:00Z" 
  } 
] 
```

## How to verify your solution

This repository has a standard script that you can use to evaluate you solution. It is located in [music-schedule/verifier](music-schedule/verifier)

We typically assume the following when we verify your solution:
1. There is a build.sh or build.bat to builds the program
2. and a run.sh or run.bat that runs the program

Note that the `jq` program is a dependency of the verifier. Windows users may need to install it.

## What we're looking for

When we review your submission we're looking for a few things:
- [ ] how you model the domain that you're working with,
- [ ] coding approach and proficiency with your language of choice,
- [ ] what testing strategy you apply to ensure that any solution has future maintainability,
- [ ] a readme that discusses your approach, any concessions you made, any self imposed constraints, anything that you think would be valuable for the reviewer to know.

## How to submit

Once you've determined how Sally can have her best concert experience can you please post your solution to a private Github repository, let your hiring manager know and they can provide the accounts of some available reviewers.

Thank you for applying and good luck on this project!

## End note

If you have any queries about the programming challenge, please get in touch with your hiring manager and we will be happy to clarify.

When you have finished… 

We are always trying to improve the way we do things here at Skedulo, so we would love to get your feedback on this test. 

1. What are some things that could go wrong with your program that you didn’t handle? 
2. What influenced your choice of solution/programming language? 
3. Reflect on how easy or difficult it was to complete this task given the instructions provided. Is there any way you think the question could be improved?

