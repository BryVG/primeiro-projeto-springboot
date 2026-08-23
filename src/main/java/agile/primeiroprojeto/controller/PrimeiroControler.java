package agile.primeiroprojeto.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/metodoResponseEntity/{id}")
    public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id) {
        var usuario = new Usuario("João");

        if(id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mensagem de erro para ID: " + id);
    }
    
    
    record Usuario(String username){}
}