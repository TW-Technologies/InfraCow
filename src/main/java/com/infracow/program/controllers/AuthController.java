package com.infracow.program.controllers;

import com.infracow.program.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infracow.program.models.Usuario;
import com.infracow.program.services.UserService;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;


    @GetMapping("/")
    public String loginPage() {
        return "userLogin";
    }

    @GetMapping("/register")
    public String cadastroPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "userCadastro";
    }

    @PostMapping("/login")
    public String addUser(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model) {
        Usuario user = this.service.findByEmail(usuario.getemail()).orElseThrow(() -> new RuntimeException("User Not Found"));

        if(passwordEncoder.matches(user.getsenha(), usuario.getsenha())){
            String token = this.tokenService.generateToken(user);
            return "redirect:/imagem/cadastroImagem";
        }


        if (result.hasErrors()) {
            return "userCadastro";
        }

        service.addUser(usuario);
        return "redirect:/user/";
    }
}
