package agile.primeiroprojeto.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiroControler {

    @GetMapping("/primeiroMetodo")
    public String primeiroMetodo() {
        return "Primeira rota criada com sucesso!";
    }
    @GetMapping("/metodo/{id}")
    public String metodocomqueryparams(@PathVariable String id) {
        return "Segunda rota criada com sucesso! ID: " + id;
    }
    @GetMapping("/metodo2")
    public String metodocomqueryparams2(@RequestParam Map<String, String> allParams) {
        return "Terceira rota criada com sucesso! ID: " + allParams.get("id") + " Nome: " + allParams.get("nome");
    }
    @PostMapping("/metodo3")
    public String metodocombodyparams(@RequestBody Usuario username){
    return "Quarta rota criada com sucesso!" + " Nome: " + username.username();
    }

    record Usuario(String username){}
}