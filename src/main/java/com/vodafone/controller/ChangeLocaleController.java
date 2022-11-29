package com.vodafone.controller;

import com.vodafone.model.LocaleSelect;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class ChangeLocaleController {
    private ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource;
    public ChangeLocaleController(ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource){
        this.reloadableResourceBundleMessageSource=reloadableResourceBundleMessageSource;
    }
    @GetMapping("/changeLocale")
    public String changeLocale(Model model){
        model.addAttribute("localeSelect",new LocaleSelect());
        return "changeLocal";
    }
    @PostMapping("/changeLocale")
    public String changeLocalePost(@ModelAttribute("localeSelect") LocaleSelect localeSelect, BindingResult bindingResult,Model model){
         model.addAttribute("locale",localeSelect.getChoice());
        return "redirect:/springmvc/helloLocale?lang="+localeSelect.getChoice();
    }
    @GetMapping("/helloLocale")
    public String helloWithLocale(){
        return "helloWithLocale";
    }
}
