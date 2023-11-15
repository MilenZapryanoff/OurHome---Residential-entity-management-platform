package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.MessageService;
import com.example.OurHome.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
    private final UserService userService;
    private final MessageService messageService;

    public MessageController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public ModelAndView messages() {

        return new ModelAndView("messages", "userViewModel", getUserViewModel());
    }

    @GetMapping("/messages/archives")
    public ModelAndView messageArchives() {

        return new ModelAndView("messages-archives", "userViewModel", getUserViewModel());
    }

    @PostMapping("/messages/delete/{id}")
    @PreAuthorize("@securityService.checkMessageUserAccess(#id, authentication)")
    public ModelAndView messageDelete(@PathVariable("id") Long id) {

        messageService.deleteMessage(id);
        return new ModelAndView("redirect:/messages/archives");
    }

    @PostMapping("/messages/delete/all/{id}")
    @PreAuthorize("@securityService.checkMassMessagesUserAccess(#id, authentication)")
    public ModelAndView messageDeleteAll(@PathVariable("id") Long id) {

        messageService.deleteAllMessages(id);
        return new ModelAndView("redirect:/messages/archives");
    }

    @PostMapping("/messages/read/{id}")
    @PreAuthorize("@securityService.checkMessageUserAccess(#id, authentication)")
    public ModelAndView messageRead(@PathVariable("id") Long id) {

        messageService.readMessage(id);
        return new ModelAndView("redirect:/messages");
    }

    @PostMapping("/messages/read/all/{id}")
    @PreAuthorize("@securityService.checkMassMessagesUserAccess(#id, authentication)")
    public ModelAndView messageReadAll(@PathVariable("id") Long id) {

        messageService.readAllMessages(id);
        return new ModelAndView("redirect:/messages");
    }

    @PostMapping("/messages/archive/{id}")
    @PreAuthorize("@securityService.checkMessageUserAccess(#id, authentication)")
    public ModelAndView messageArchive(@PathVariable("id") Long id) {

        messageService.archiveMessage(id);
        return new ModelAndView("redirect:/messages");
    }

    @PostMapping("/messages/archive/all/{id}")
    @PreAuthorize("@securityService.checkMassMessagesUserAccess(#id, authentication)")
    public ModelAndView messageArchiveAll(@PathVariable("id") Long id) {

        messageService.archiveAllMessages(id);
        return new ModelAndView("redirect:/messages");
    }

    private UserViewModel getUserViewModel() {
        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.getUserViewData(loggedUser);
    }
}
