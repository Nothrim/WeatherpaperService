package com.nothrim.controllers.user;

import com.nothrim.database.models.security.User;
import com.nothrim.iplocation.ServerLocationBo;
import com.nothrim.security.SecurityContextAccessor;
import com.nothrim.security.SecurityService;
import com.nothrim.security.UserService;
import com.nothrim.security.UserValidator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Notrim on 24.04.2017.
 */

@Controller
public class UserController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    SecurityContextAccessor securityContextAccessor;

    @Autowired
    ServerLocationBo serverLocationBo;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        log.info("REGISTERING");
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.create(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/home";
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ResponseBody
    public String token(Authentication authentication) {
        String token = UUID.randomUUID().toString();
        String login = authentication.getName();
        User u = userService.findByUsername(login);
        if (u != null) {
            u.setToken(token);
            userService.save(u);
        }
        return token;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout, HttpServletRequest request) {
//        if (urls != null && urls.size() > 0)
//            model.addAttribute("imageUrl", "background-image:url(\"" + urls.get(new Random().nextInt(urls.size())) + "\");" +
//                    " background-position:center top;background-repeat:no-repeat;");

        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        return logout == null && securityContextAccessor.isCurrentAuthenticationAnonymous() ? "login" : "home";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcome(Model model, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        model.addAttribute("token", user.getToken());
        model.addAttribute("images", user.getImages());
        model.addAttribute("favouriteImages", user.getFavImages());
        return "home";
    }
}

