package com.infracow.program.controllers;

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

import java.util.Optional;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String loginPage() {
        return "userLogin";
    }

    @GetMapping("/register")
    public String cadastroPage(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "userCadastro";
    }

 /*   @PostMapping("/authenticate")
    public String authenticate(@ModelAttribute("usuario") @Validated Usuario body, BindingResult result, Model model) {
        Optional<Usuario> userOpt = this.service.findByEmail(body.getemail());

        if (result.hasErrors() || userOpt.isEmpty()) {
            model.addAttribute("errorMessage", "Credenciais inválidas");
            return "userLogin";
        }

        Usuario user = userOpt.get();

        if (passwordEncoder.matches(user.getsenha(), body.getsenha())) {
            return "redirect:/animal/animais";
        }

        model.addAttribute("errorMessage", "Credenciais inválidas");
        return "userLogin";
    }*/

    @PostMapping("/create")
    public String addUser(@ModelAttribute("usuario") @Validated Usuario body, BindingResult result, Model model) {
        Optional<Usuario> userOpt = this.service.findByEmail(body.getEmail());
        if (result.hasErrors() || userOpt.isPresent()) {
            model.addAttribute("errorMessage", "Erro ao criar usuário");
            return "userCadastro";
        }

        Usuario newUser = new Usuario();
        newUser.setEmail(body.getEmail());
        newUser.setSenha(passwordEncoder.encode(body.getSenha()));
        service.addUser(newUser);

        return "redirect:/auth/login?success";// Após o cadastro, redireciona para a página de login
    }
}
