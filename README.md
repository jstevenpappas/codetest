


# Project  
Small project submitted for the CyrusInnovation 'codetest' challenge.  
At the time, they required submissions to be in Java instead of the language of your choice.

## How to Run
Instructions and screenshots are located in the ```docs``` directory

## Assignment

```
Assignment 
Write a program that builds a master list of people from three data files, then prints it to console, sorted in three different ways.

Limitations 
Your program may only use the standard Java SE libraries; no other libraries may be used. Any version of Java is fine.
If you choose to include unit tests with your submission, you may use the JUnit framework.

Input Files 
The person data files may be found in the codetest_files.zip archive, 
in the "input_files" directory. Each file contains one person's information per line.
The properties of a person are separated by either a space (" "), a comma (",")
or a pipe ("|"). You may assume that there are no separators in any of the properties themselves.
Some properties (e.g. gender) are represented differently, depending on the delimiter. 
The order of properties is different for each format:

Pipe-delimited files
Last Name, First Name, Middle Initial, Gender, Favorite Color, Date Of Birth

Space-delimited files 
Last Name, First Name, Middle Initial, Gender, Date Of Birth, Favorite Color

Comma-delimited files 
Last Name, First Name, Gender, Favorite Color, Date Of Birth

Output Format 
When your program is run using the supplied person input files, it should 
produce output that matches the file "model_output.txt", which is also include in the codetest_files.zip archive.

Person records should be printed with their properties in the following order: 
Last Name, First Name, Gender, Date Of Birth, Favorite Color.

The merged list should be printed 3 times:
by Gender (Female before Male), then Last Name ascending.
by Date, ascending.
by Last Name, descending.

What to submit 
Your files should be sent in a zip archive. Please make sure to include both compiled classes and source files in the archive, along with a README file that describes how to build it and how to run it. If you use Ant to build your project, please include the build file. If you are including JUnit tests, please include the JUnit jar file in the archive. Please do no include any ".bat" files as our mail filters tend to think that these are viruses.
```
