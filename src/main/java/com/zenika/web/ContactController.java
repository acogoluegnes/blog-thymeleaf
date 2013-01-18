package com.zenika.web;

import com.zenika.business.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 */
@Controller
public class ContactController {

    @Autowired private ContactService contactService;

    @RequestMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("contacts",contactService.getContacts());
        return "contacts";
    }

}
