CS542 Design Patterns
Spring 2016
PROJECT <FOUR> README FILE

Due Date: <Tuesday, April 19, 2016>
Submission Date: <Tuesday, April 22, 2016>
Grace Period Used This Project: <TWO> Days
Grace Period Remaining: <ZERO> Days
Author(s): <Chinmay Kelkar><Plash Sachdeva>
e-mail(s): <ckelkar1@binghamton.edu><psachde3@binghamton.edu>


PURPOSE:

[
  The purpose of this project is to understand how to use visitor pattern with trees.
]

PERCENT COMPLETE:

[
  We believe we have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE: 

[
  NONE
]

BUGS:

[
  NONE
]

FILES:

[

 FileProcessor.java: the file which reads the input file line by line and passes it as a string and also writes to the output file.
 Driver.java: the main file associated with the program also contains main.
 TreeElement.java: acts as an element.
 PopulateTreeVisitor.java: Visitor class that reads words from a file and populates a tree data structure.
 WordCountVisitor.java: Visitor that determines the total number of words, etc.
 grepVisitor.java: Visitor that determines the total number of times a "search-string" occurs
 TreeProcessingVisitorI.java: visitor interface and all three visitors implement that interface.
 build.xml: the file used to compile and run the code
 README.txt: the text file you are presently reading
 Node.java: contains node structure

]



DATA STRUTURE USED:

[
  We tried AVL and Binary Search Tree and we found that BST is giving good performance. So We used Binary Search Tree to store words. We used hashmap which contains key as maxcount and value as arraylist which conatains words having that count. This reduces one extra pass to calculate similar strings having maxcount.
  
]



TO COMPILE:

[
  Untar file using command tar -xvf kelkar_chinmay_sachdeva_plash_assign4.tar.gz
  Follow Path: kelkar_chinmay_sachdeva_plash_assign4/wordCount
  Assuming you are in the directory containing this README
	
  ## To compile: 
  ant -buildfile build.xml all
]


TO RUN:

[
  Assuming you are in the directory containing this README
  Please run as: ant -buildfile build.xml run -Darg0=<inputFileName.txt> -Darg1=<outputFileName.txt> -Darg2=<NUM_ITERATION> -Darg3=<search_string>
]


EXTRA CREDIT:

[
  N/A
]


BIBLIOGRAPHY:

[
  No
]

ACKNOWLEDGEMENT:

[
  N/A

]

