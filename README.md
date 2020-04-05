Note: we used the in memory H2 database, restart of the application resets the database.

Step1 : check out the code and import maven project into STS or any other IDE.

Step2 : Run project as Spring Boot application or java application

Step3 : Access Swager UI to get the exposed API's
url: http://localhost:8080/swagger-ui.html#/

OR 

If you have maven installed then checkout the code and run the below command from the project root directory

mvn clean spring-boot:run

If you want to run the service in Kubernates cluster : 
Build Docker image using the Dockerfile provided 
and this Docker image can be deployed to Kubernates cluster using phonebook.yaml file 

---------------------------------------------------------------------------------------------------
# TO DO #
Moving the hard coded content like messages, proper naming conventions :),  sql queries to property / yaml files.
proper exception handling with error codes.
Implementation of Logging.
Implementation of ssl (https), TLS.

Implementing the micro services patterns like 
	Config server (spring cloud config server)
	Discovery server (service registry like Euraka)
	API gateway (Zuul)
	Authorization thru Oauth server / using JWT / SAML
	Load balancer (Ribbon)
	Hystrix 
	centralized Logging using ELK /kafka / fluentd
	Distributed tracing using spring cloud sleuth, zipkin
	Monitoring using spring boot admin / prometheus 
	
The above micro services patterns can be implemented uisng service mesh like Istio.

	The implementation of micro services should be followed by using Devops tool chain.
	The micro service can be shipped as a docker image and can run in Kubernates clustor to manage the micro services using pods and 
	can take advantage of Kubernates features like scaling, resiliency, to do blue green , kenary deployments etc..
