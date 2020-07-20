package br.com.spring.blog.springblog.controller;

import br.com.spring.blog.springblog.model.Post;
import br.com.spring.blog.springblog.service.SpringblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringblogController {

    @Autowired
    SpringblogService springblogService;

    @GetMapping(value = "/posts")
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = springblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = springblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

}
