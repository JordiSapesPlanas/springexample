package com.udl.softarch.springexample.controllers;

import com.udl.softarch.springexample.GreetingRepository;
import com.udl.softarch.springexample.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * Created by davidkaste on 16/02/15.
 */

@Controller
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    GreetingRepository gretRepo;
    /*@RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewGreeting() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        String name = "hola com va!";
        mav.addObject("name", name);
        return mav;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView viewGreeting(@PathVariable(value = "name")String name) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        //String name = "hola com va!";
        mav.addObject("name", name);
        return mav;
    }*/

    //List
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Greeting> list(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);
        return gretRepo.findAll(request).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHtml(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "0") int size) {
        return new ModelAndView("greetings", "greetings", list(page, size));
    }
    //retrieve
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Greeting retrieve(@PathVariable("id") Long id){
        return gretRepo.findOne(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHtml(@PathVariable("id") Long id){
        return new ModelAndView("greeting", "greeting", retrieve(id));
    }

    // create
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Greeting create(@Valid @RequestBody Greeting greeting , HttpServletResponse httpServletResponse){
        return greeting;
    }
    @RequestMapping(method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded", produces = "text/html" )
    public String createHtml(@Valid @ModelAttribute("greeting") Greeting greeting, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/greetings/"+ create(greeting, response).getId();

    }
    @RequestMapping(value = "/form", method = RequestMethod.POST, produces = "text/html")
    public ModelAndView createForm(){
        Greeting emptyGreeting = new Greeting();
        emptyGreeting.setDate(new Date());
        return new ModelAndView("form", "greeting", emptyGreeting);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Greeting update(@PathVariable("id") Long id){
        return gretRepo.findOne(id);

    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT, consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String createHtmlUpdate(@PathVariable("id") Long id, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/greetings/"+update(id).getId();
    }
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView updateGreeting(@PathVariable("id")Long id){
        return new ModelAndView("form", "greeting", gretRepo.findOne(id));

    }

    //Delete

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        gretRepo.delete(id);
    }
    @RequestMapping(value = "/{id}",  method = RequestMethod.DELETE, produces = "text/html")
    public String afterDeleteHtml(@PathVariable("id")Long id) {
        delete(id);
        return "redirect:/greetings/";
    }













}