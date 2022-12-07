# Toy Language Interpreter
### A custom "toy" language interpreter built on Java

-----

# Used Concepts
- Layered architecture
- JavaFX for GUI
- Encapsulation, interfaces, streams
- MVC pattern

---

# Instructions:
- logical expressions
- arithmetical expressions
- relational expressions
- variable declaration & assignment
- printing
- if
- while
- file opening, closing and reading
- fork (multi-threading)
- heap allocation, reading and writing

---

# Variables Types:
- Bool
- Int
- String
- Reference

---

# Functionalities
- Storing instructions in execution stacks
- Storing local variables in symbol tables
- Storing BufferedReader objects into a file table used for file operations
- Shared heap across all the states created by a program - allocation, reading, writing and garbage collector
- Storing printing output in an output table
- While forking, a new program state is being created with a unique ID 
- Program states: each state has a unique ID, a symbol table and an execution stack
