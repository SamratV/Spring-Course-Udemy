SETUP:
	1) Run the sql scripts in "project 7 - part 0" and "project 8 - part 0/hb-03-one-to-many" folder.
	2) Make a lib folder, copy jdbc connector and the jars in hibernate orm's "lib/required" folder.
	3) Add lib folder to build path.
	4) Copy hibernate config file from "project 7 - part 0" folder to "src" folder and edit it.

VERSIONS:
	1) EagerLazyDemo: Change the fetch type in Instructor class to either EAGER or LAZY and set
	breakpoint at line 34 in the EagerLazyDemo class and finally run in debug mode to see the difference.
	2) FetchJoinDemo: Read the important comment in EagerLazyDemo.

CONCEPTS LEARNED:
	1) Difference between EAGER and LAZY loading. (2 concepts)
	2) LAZY loading fetch problem and it's solution. Read the important comment in EagerLazyDemo. (2 concepts)
	3) Read through the screenshots in the "Readme" folder. (1 concept)

NOTE:
	Read the comments in "InstructorDetail" class carefully for implementing cascading and non-cascading delete features.