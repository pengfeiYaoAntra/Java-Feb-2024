package com.training.demo.controllers;


import com.training.demo.entities.Calresult;
import com.training.demo.entities.UserSpringValidation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/*
* what is spring boot project->
*
*
* what is spring mvc
*   MVC -> model view and controller
*   Model: represents the data and your business logic and encapsulates the data and provides some methods to interact with the data.
*   view: HTML, XML, JSON -> for rendering the data from the model
*   controller: handles users requests and updates the model and view accordingly
*
* @RequestBody: gather the data from the body of the http request -> when use-> you have http request body contains json, xml -> get, put psot
* @RequestParam: used to read parameters from the URL -> accessing simple values from the query URL
* @PathVariable: gather data from the URL path itself -> used for restful services to access path of the URL path as parameters
*
* logging system level
* FATAL
* ERROR
* WARN
* INFO
* DEBUG:
* TRACE:
*
* PostMapping
* DeleteMapping
* PatchMapping
* PutMapping
*
* PatchMapping vs putMapping
* patch: used to partially update an existing resource
* put: used to update an existing resource
*
* @Controller vs RestController
*
* controller: it will return HTML view, which is resolved by a view resolver ->
*
* RestController: is combination of controller and responseBody annotaion ->
*               it will return value in form of JSON, XML or any other data format that can be consumed by your application
*
*
*
* assuming you want to send a request localhost:add/1/2 -> dispatcher servlet will manage your requests
*
*
*       old way and controller
*
*               your request-> dispatcher servlet -> handler mapping : define which api you built to handle this request
*                                                 <- decision send back to
*                                                      controller will do further step: business logic
*                                                   <-model and view
*                                                  ->view resolver : defines which page(web) you should render
*                                                      <-
*                                                   View: receive model and render your web
*
* @restcontroller
*                       your request -> dispatcher servlet -> handler mapping
*                                                           <-
*                                                           RestController
*
* what is IOC?
* ioc is  container _> contains beans
*
*   [controller bean, service bean, customer bean]-> grap beans from container using ->autowired and qualifier
*
* what is bean?
* bean is an object -> managed by ioc
*
*
* bean life cycle
* instantiate:  IOC creates an instance of the bean
*
*           populate: customize your bean -> assign the values of bean's properties
*           BeanPostProcessor: help to check bean's value
*
*
* being used:
*
* destruction:
*
*
* bean scope
*
*
*   singleton scope(default)
*       there is only one instance of the bean per spring container
*       this bean could be shared across spring application
*
*   prototype
*           a new instance of the bean can be created each time you request from the container
*            this bean is not shared.
*
*   Request:
*       each time you send http request, a new instance of the bean is created
*
*
*   session:
*           a new instance of the bean should be created for each users' session
*
*   application bean scope
*       the container will create a new instance of the bean per web application runtime.
*       similar to singleton scope
*       singleton scoped bean is in application context
*       application bean scoped is in ServletContest
*
*
 */
//@Controller
@RestController
public class CalculatorController {
    @RequestMapping("/hello")// your URL path
    public String hello(){
        return "hello world";
    }
    @RequestMapping("add/{num1}/{num2}")
    public ResponseEntity<Calresult> add(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        double result = num1 + num2;//
        return new ResponseEntity<>(new Calresult(result), HttpStatus.OK);
    }

    @RequestMapping("div/{num1}/{num2}")
    public ResponseEntity<Calresult> div(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        if(num2 == 0) throw  new ArithmeticException("num2 cannot be zero");
        double result = num1 / num2;
        return new ResponseEntity<>(new Calresult(result),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserSpringValidation userSpringValidation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User created successfully", HttpStatus.OK);
    }


    @GetMapping("/test")
    public String test(@RequestBody Calresult calresult){
        return calresult.toString();
    }

    @GetMapping("param")
    public String test(@RequestParam("myCal") String myCal){
        return myCal;
    }

}