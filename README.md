# Web Engineering 2015-2016 / Swagger documentation

## What is Swagger?

Swagger is a a specification and complete framework implementation for describing, producing, consuming, and visualizing RESTful web services. As a specification, it is language-agnostic. With Swagger's declarative resource specification, clients can understand and consume services without knowledge of server implementation or access to the server code. More info can be found at [Swagger page](http://swagger.io/).

It is composed of various modules, such as:

* Swagger Ui

It is a HTML (+JS+CSS) application that allows to generate documentation from a Swagger API. The Swagger UI framework allows both developers and non-developers to interact with the API in a sandbox UI that gives clear insight into how the API responds to parameters and options. The sandbox has this appearance.
![Example of documentation generation](http://img.scoop.it/B_LNqfPaH-b3STEXHVQ-qTl72eJkfbmt4t8yenImKBXEejxNn4ZJNZ2ss5Ku7Cxt "Example of documentation generation")

We open Swagger UI local with `http://localhost:8282/api/resources.json`

* Swagger Core

It defines the Java annotations and the required logic to generate a Swagger client or server.

* Swagger node.js

Stand-alone Swagger server written in Javascript with node.js

* Swagger Java Sample App

Stand-alone Swagger server written in Java that shows how to set up Swagger in your API.

* Swagger CodeGen

It offers a templates engine to generate client code in different languages.
