Product Selection web App
========================

# 1 - About

The goal of this application is to display the products to the customer based on his home location.

This application is build using the following technologies


**Back End**

- Java 8 (lambda)
- Spring boot starter
- Jackson
- Maven
- Junit Tests
- SLF4J (Logging Facade for Java)
- Apache Tomcat Server


**Front End**


- npm, Bower
- Javascript (Jquery, RequireJS, UnderscoreJS, BackboneJS, Backbone.LocalStorage)
- Spring's Thymeleaf (HTML 5)
- CSS


# 2 - Setup

This project is shipped with maven 3.1.1 which is in the root package.
to build the app, just navigate to home directory from terminal and execute command

**./build.sh install (mac)**
**build.sh install (windows)**

This will download all maven dependencies to your local repository.
You can start server by executing this maven goal

**./build.sh exec:java**

The server will start at

**port: 8080**

only two urls are mapped at the moment.

- **/product**
- **/confirmation**

"/Product" will display list of available products to the users depending on their location
"/confirmation" page holds the basket that contains all your selected products

It is assumed that cookie **customerID** will be present.

There are only two users at the moment

**customer1** (located in London)
**customer2** (located in Liverpool)

If you pass query parameter **?customerID=customer1**, it will be prefered over the cookie value.

If there is no cookie present, customer1 will be selected by default, as it is only a test and will
prevent exception.

if wrong customerID is provided, that does not exits in db, An exception will be thrown.

All products that are added to basket are saved in local storage against customerID. so if you switch
between the customers, view will be change accordingly.

# 3 - Explaination

**Back End**

Spring MVC Controllers are used to map requests.

Two Services,

- **CustomerLocationService**
- **Catalogue Service**

former provides the location of the user depends on customerID.
later provides the catalogue depends on the Location

Service request mock data is created in the JSON format and live in following files

- **customer_location.json**
- **location_products.json**

Jackon will map the values to Java objects and present it to client.

Controllers will request'ProductClient' to fetch data data from service depends on customerID

The data returned from service pushed into model so that view can utilize this data.


**Front End**

Thymeleaf templates are used to put some logic in the template

All javascript dependencies are downloaded through bower and aligned through requirejs.

BackboneJS is used to structure the front end javascript code. Backbone model is extended which holds

- id (product id)
- name (product name)
- customerID

whenever user click on the checkbox, a model is created which is added to Backbone Collection.

if model is added into the collection, it triggers 'add' event and 'remove' if model is removed from collection.
Backbone View is always listening to these event to update the view.

This collection is stored in the local storage to be able to use it later on confirmation page.

# 4 - Improvements

There is still a lot of room for improvement as this task only meant to last for few hours, i couldnt cover everything i wanted.

- Grunt task runner can be used to run karma tests on javascript
  and to minify js and css files and compile the requirejs.
- Service is directly talking to exposed data, instead, there should be another layer (repository ?) that will be
  responsible of assembling query and returning results sets from database to the service.


  If you have any question regarding this excercise, feel free to drop me an email.

















