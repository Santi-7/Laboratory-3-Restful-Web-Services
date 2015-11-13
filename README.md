# Web Engineering 2015-2016 / Swagger documentation

## What is Swagger?

Swagger is a a specification and complete framework implementation for describing, producing, consuming, and visualizing RESTful web services. As a specification, it is language-agnostic. With Swagger's declarative resource specification, clients can understand and consume services without knowledge of server implementation or access to the server code. More info can be found at [Swagger page](http://swagger.io/).

It is composed of various modules, such as:

* Swagger Ui

It is a HTML (+JS+CSS) application that allows to generate documentation from a Swagger API. The Swagger UI framework allows both developers and non-developers to interact with the API in a sandbox UI that gives clear insight into how the API responds to parameters and options. The sandbox has this appearance.

![Example of documentation generation](http://img.scoop.it/B_LNqfPaH-b3STEXHVQ-qTl72eJkfbmt4t8yenImKBXEejxNn4ZJNZ2ss5Ku7Cxt "Example of documentation generation")

* Swagger Core

It defines the Java annotations and the required logic to generate a Swagger client or server.

* Swagger node.js

Stand-alone Swagger server written in Javascript with node.js

* Swagger Java Sample App

Stand-alone Swagger server written in Java that shows how to set up Swagger in your API.

* Swagger CodeGen

It offers a templates engine to generate client code in different languages.

## How do we use Swagger?

We have to do the following steps:

1) We import Swagger dependencies in `build.gradle`.

2) We documentate our code with Swagger annotations. In this service, I have documentated the classes `AddressBookService, Person, PhoneNumber`

3) We have to hook up our api with Swagger. This is made by adding Swagger's configuration. You can check it in `ApplicationConfig.java`

4) We have to create a ServletContainer to take use of Swagger service.

    URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
	  ServletContainer sc = new ServletContainer(new ApplicationConfig(ab));
	  HttpServer server = GrizzlyWebContainerFactory.create(uri, sc, null, null);`
	  
5) We run the server (`gradle server`) and go to Swagger service (`http://localhost:8282/swagger.json`). And we get the documentation we wanted.

![JSON with Swagger documentation](http://i64.tinypic.com/11bjcsn.png "JSON with Swagger documentation")

We can download [Swagger UI](https://github.com/swagger-api/swagger-ui) to have a good looking interface.
