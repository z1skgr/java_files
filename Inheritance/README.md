# SimpleJava-Inheritance
A simple program for practise java IS-A mechanisms. 


 
 ## Table of contents
* [Features](#features)
* [Hierarchy](#hierarchy)
* [Setup](#setup)
* [Acknowledgements](#acknowledgements)
 

 
 ## Features
 1. Introduction of a (only one) zoo.
 2. Printing details of the zoo and all its employees and animals.
 3. Introduction of employees.
 4. Introduction and deletion of animals.
 5. Search for employees based on the AFM number of the employee.
 6. Search for animals based on their registration serial number.
 7. Printing of all workers or animals belonging to a specific category of workers / animals given by user [^1][^2]

## Hierarchy
*
 ```mermaid
graph TD;
    A[Zoo]-->B[Name];
    A[Zoo]-->C[City];

```
*
 ```mermaid
graph TD;
    A[Worker]-->B[Name];
    A[Worker]-->C[AFM];
```
*
 ```mermaid
graph TD;
    A[Worker]-->|divided|B[Trainer];
    A[Worker]-->|divided|C[Assistant];
    B[Trainer]-->D[Type Train];
    C[Assistant]-->E[Depart];

```
*
 ```mermaid
graph TD;
    A[Animal]-->B[Name];
    A[Animal]-->C[Serial num];


```
*
 ```mermaid
graph TD;
    A[Animal]-->|divided|B[Snakes];
    A[Animal]-->|divided|C[Birds];
    A[Animal]-->|divided|D[Fish];
    B[Snakes]-->E[Cover];
    B[Snakes]-->|divided|F[Legs];
    B[Snakes]-->|divided|G[No-Legs];
    F[Legs]-->H[Num Legs];
    G[No-Legs]-->I[max speed];
    C[Birds]-->J[seamuff];
    C[Birds]-->K[Color wings];
    D[Fish]-->|born|M[Eggs];
    M[Eggs]-->N[shape];
    M[Eggs]-->O[color];
 ```

 
 ## Setup
Java IDE environment (Eclipse implemented)

* Import project to eclipse workshop
* Run as Java application


## Acknowledgements
- This project was one of my very first project for learning Java.
- This project was created for the requirements of the lesson Structured Programming.
- Implementation focus on class hierarcy


[^1]: For example, the user may request that the data for all birds be displayed.
[^2]: All reptiles are to be printed, both reptiles with legs and reptiles without legs must be printed.
