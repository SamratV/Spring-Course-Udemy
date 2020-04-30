IMPLEMENTATION: Spring Data REST.

NOTE:
	1) IMPORTANT: Read the PDFs part 13.
	2) No need to implement service and controller.
	3) Add Spring Data REST dependency to "pom.xml".
	4) Certain Spring Data REST properties where added to "application.properties".
	5) For update use the following:
		(a) URL: http://localhost:8080/magic-api/employees/{id}
		(b) Method: PUT
		(c) Request Body:
			{
			    "firstName": "name",
			    "lastName": "surname",
			    "email": "user@domain.com"
			}
		(d) Note there is no "id" in the request body, rather it is part of the URL.
		(e) If you do pass the "id" in the request body then it will be simply ignored.
	6) The last PDF contains very important information about pagination, sorting and
	changing the default API name in the URL, i.e, ".../employees" to, say ".../members". 