SETUP:
	1) Run the sql scripts in "project 7 - part 0" and "project 8 - part 0/hb-03-one-to-many" folder.
	2) Make a lib folder, copy jdbc connector and the jars in hibernate orm's "lib/required" folder.
	3) Add lib folder to build path.
	4) Copy hibernate config file from "project 7 - part 0" folder to "src" folder and edit it.

VERSIONS:

	----- OLD AND IRRELEVANT -----
	
	1) CreateDemo & Instructor & InstructorDetail: One to one mapping & bidirectional - insert.
	2) DeleteDemo & Instructor & InstructorDetail: One to one mapping & bidirectional - delete.
	3) GetInstructorDetailDemo & Instructor & InstructorDetail: For testing bidirectional mapping.
	
	----- NEW ADDITIONS / IMPORTANT -----
	
	4) CreateInstructorDemo & Instructor & InstructorDetail & Course: Many to one & bidirectional.
	5) GetInstructorCoursesDemo & Instructor & InstructorDetail & Course: Fetch courses.
	6) CreateCoursesDemo & Instructor & InstructorDetail & Course: Create and add courses.
	7) DeleteCourseDemo & Instructor & InstructorDetail & Course: Delete course by id but prevent
	cascading delete by specifying right cascade property in the entity classes.

NOTE:
	Read the comments in "InstructorDetail" class carefully for implementing cascading and non-cascading delete features.