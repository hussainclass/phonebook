Software developent process :
---------------------------

As part of the agile process, we have Epics and Stories created in the backlog Kanban board.
Based on the sprint planning, we do discuss the stories and size them.

Usually we follow small sprints which span of two weeks, we do the task break down for the stories.

In daily stand up call, we track the progress of stories which are in-progress.

As part of Implementation we starts with test cases 
Test-driven development is a software development process that relies on the repetition of a very short development cycle: 
requirements are turned into very specific test cases, then the code is improved so that the tests pass.

In Pair programming two programmers work together.  
One, the driver, writes code while the other, the observer or navigator, reviews each line of code.

12 factor guidelines are followed for the implementation of microservices and to ensure frequent delivery, so we will have
proper DevOps (CI and CD) process for the continuous integration and continuous delivery.
The CI pipeline can be built around the tools like Git, Bazel, Jenkins, SonarCube, Static analysis tools etc.. that builds 
the Docker containers and release to repository like artifactory and Docker Hub
And the CD pipeline will deploy the Docker containers to the container orchestration environment like Kubernates (Diff environments like
Dev, QA, Performance, UAT and Production)

At the end of each sprint there will be a demo to business stake holders for the acceptance of stories.
If there is any technical debt, those stories will be moved to the next sprint.

As part of DOD check list, will also do code review and review report will be uploaded and also ensure that all the criterions are met.
Will also ensure that documentation and release notes has been prepared.

squad service ownership ensures each service will be owned by team and which is responsible for end to end ownership.

--------------------------------------------------------------------

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
