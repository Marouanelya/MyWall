package com.polytech.web;

import com.polytech.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by dev on 3/15/17.
 */
@Controller
public class PostController {


    @Autowired
    private PublicationService publicationService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    private boolean liked = false;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "forward:feed.html";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String home(){
        return "Hello";
    }

    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String feed(Model model){
        List<Post> posts = publicationService.fetchAll();
        for (Post post: posts) {
            post.setLikes(likeService.fetchAll((int) post.getId()).size());
            post.setComments(commentService.fetchAll(post.getId()));
            System.out.println("Post Id N° Comments : " + post.getComments().size());
        }

        model.addAttribute("posts", posts);
        //List<Comment> comments = commentService.fetchAll(1);
        //model.addAttribute("comments", comments);
        //System.out.println(comments.size());
        //List<Likes> likes = likeService.fetchAll(1);
        //model.addAttribute("likes", likes);
        return "feed";
    }

    @RequestMapping(value = "/share", method = RequestMethod.POST)
    public String post(Post post, Principal principal){
        String username = principal.getName();
        post.setUsername(username);
        //System.out.println(content);
        publicationService.post(post);
        System.out.println(post);
        System.out.println(publicationService.fetchAll().size());
        return "redirect:feed.html";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(Comment comment, Principal principal){
        String username = principal.getName();
        comment.setUsername(username);
        commentService.comment(comment);
        System.out.println("PostID : " + comment.getPostID());
        //commentService.comment(comment);
        return "redirect:feed.html";
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public String like(Likes like, Principal principal){

        Likes li = new Likes();

        for (Likes l: likeService.fetchAll((int) like.getPostID())) {
            if(l.getUsername() == principal.getName() && like.getPostID() == l.getPostID()) {
                li = l;
                break;
            }
        }

        if(li.getId() == 0) {
            String username = principal.getName();
            like.setUsername(username);
            likeService.like(like);
            System.out.println("Like ! " + like);
            liked = true;
        }
        else {
            likeService.delete(like.getPostID(), principal.getName());
            System.out.println("DO NOT LIKE !");
            liked = false;
        }
        return "redirect:feed.html";
    }

    @RequestMapping(value = "/deletePost/{id}")
    public String deletePost(@PathVariable("id") Long id){
        System.out.println("ID : " + id);
        publicationService.delete(id);
        return "redirect:/feed.html";
    }

    @RequestMapping(value = "/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") Long id){
        System.out.println("ID : " + id);
        commentService.delete(id);
        return "redirect:/feed.html";
    }

}