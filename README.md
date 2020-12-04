# Ditto

This a stub/mock server. If your service is dependent on other microservice api which are underdevelopment then you can use this app to mock the api request.

>> Instade of localhost use ec2-13-233-97-35.ap-south-1.compute.amazonaws.com

Use: 
 - Create a mock endpoint
 
 		Method: GET
 
        Endpoint: /api/downstream-service-name/user/001
 
 		ResponseBody:{"name":"sourav kabiraj","roll":1001}
 
 		ResponseStatus:OK

 Hit the following Curl request to create the above endpoint

	curl --location --request POST 'http://localhost:8080/endpoints' \
	--header 'Content-Type: application/json' \
	--data-raw '{
  	  "method":"GET",
	    "url":"/api/downstream-service-name/user/001",
	    "body" : "{\"name\":\"sourav kabiraj\",\"roll\":1001}",
	    "status": "OK"
	}'

- To see all mocked endpoints

	  curl --location --request GET 'http://localhost:8080/endpoints'
	 
- To delete a mock

	  curl --location --request DELETE 'http://localhost:8080/endpoints/ff808081762ec4e301762ec5bf2a0001'
	replace ff808081762ec4e301762ec5bf2a0001 with your mock endpoint id
