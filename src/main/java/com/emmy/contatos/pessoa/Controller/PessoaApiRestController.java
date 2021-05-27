
package com.emmy.contatos.pessoa.Controller;

import com.emmy.contatos.pessoa.model.Pessoa;
import com.emmy.contatos.pessoa.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

@RequestMapping("/")

public class PessoaApiRestController {
       private PessoaRepository pessoaRepository;

       @Autowired
       public PessoaApiRestController(PessoaRepository pessoaRepository) {
              this.pessoaRepository = pessoaRepository;
       }

       @RequestMapping(value = "/{pessoa}", method = RequestMethod.GET)
       public String listaPessoas(@PathVariable("pessoa") String pessoa, Model model) {
              List<Pessoa> listaPessoas = pessoaRepository.findByNome(pessoa);
              if (listaPessoas != null) {
                     model.addAttribute("pesoas", listaPessoas);
              }
              return "listaPessoas";
       }

       @RequestMapping(value = "/{pessoa}", method = RequestMethod.POST)
       public String adicionaPessoa(@PathVariable("pessoa") String nome, Pessoa pessoa) {
              pessoa.setNome(nome);
              pessoaRepository.save(pessoa);
              return "redirect:/{pessoa}";
       }

       @GetMapping("/edit/{id}")
       public String showUpdateForm(@PathVariable("id") long id, Model model) {
              Pessoa user = pessoaRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

              model.addAttribute("user", user);
              return "update-user";
       }

       @GetMapping("/delete/{id}")
       public String deleteUser(@PathVariable("id") long id, Model model) {
              Pessoa user = pessoaRepository.findById(id)
                            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
              pessoaRepository.delete(user);
              return "redirect:/index";
       }

}