SETUP:
	1) Run the sql scripts in "project 7 - part 0" and "project 8 - part 0/hb-02-one-to-one-bi" folder.
	2) Make a lib folder, copy jdbc connector and the jars in hibernate orm's "lib/required" folder.
	3) Add lib folder to build path.
	4) Copy hibernate config file from "project 7 - part 0" folder to "src" folder and edit it.

VERSIONS:
	1) CreateDemo & Instructor & InstructorDetail: One to one mapping & bidirectional - insert.
	2) DeleteDemo & Instructor & InstructorDetail: One to one mapping & bidirectional - delete.
	2) GetInstructorDetailDemo & Instructor & InstructorDetail: For testing bidirectional mapping.

NOTE:
	Read the comments in "InstructorDetail" class carefully for implementing cascading and non-cascading delete features.