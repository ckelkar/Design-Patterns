CS542 Design Patterns
Spring 2016
PROJECT <3> README FILE

Due Date: <Monday, March 22, 2016>
Submission Date: <Tuesday, April 5, 2016> (extension given by the professor because of sickness)
Author(s): <Chinmay Pradeep Kelkar> 
e-mail(s): <ckelkar1@binghamton.edu> 


PURPOSE:

[
  Apply the design principles you have learned so far to develop and test code for the given problem.
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of this project.
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
  Driver.java: main class file 
  BST.java:contains BST operations
  Node.java:observer as well as listner
  ObserverI.java: observer interface
  SubjectI.java: subject interface
  FileProcessor.java:reads file line by line
  BSTBuilder.java: creates mainBST,backup1 and backup2 and performs corresponding operations.
  EvenFilterImpl.java: even filter implementation
  OddFilterImpl.java: odd filter implementation
  OddEvenFilterI.java: interface for odd and even filters
  README: the text file you are presently reading
]

SAMPLE OUTPUT:

[



]

TO COMPILE:

[
  Untar file using command tar -xvf chinmay_kelkar_assign3.tar.gz
  Follow Path: chinmay_kelkar_assign3/studentRecordsBackup
  Assuming you are in the directory containing this README
	
  ## To compile: 
  ant -buildfile src/build.xml all
]

TO RUN:

[
  
  Assuming you are in the directory containing this README
  Please run as: ant -buildfile src/build.xml run -Darg0=<inputFileName.txt> -Darg1=<UPDATE_VALUE>  

]

TO CLEAN:

[
  Assuming you are in the directory containing this README
  use command: ant -buildfile src/build.xml clean
  
]

USE OF DATASTRUCTURE:
Used hashmap to store observers and filters. Observers acts as key and filter acts as a value. Each subject node has one hashmap to store its's observers and their corresponding filters. Suppose there are n observers and n corresponding filters. Time complexity is O(n) and space complexity is O(n).


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
