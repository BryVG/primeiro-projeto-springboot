package agile.primeiroprojeto.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MeuComponent {
    public String chamarMeuComponent() {
    return "MeuComponent foi chamado com sucesso!";
    }
}
