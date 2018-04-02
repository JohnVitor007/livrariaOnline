//Classe command consultar
//@author John Vitor da Silva Quispe
//@date 21/03/2018
package livraria.web.controle.web.command.impl;

import livraria.aplicacao.Resultado;
import livraria.controle.impl.Fachada;
import livraria.dominio.EntidadeDominio;
import livraria.web.controle.web.command.ICommand;

public class CommandConsultar implements ICommand{

    private Fachada f;
    
    @Override
    public Resultado executar(EntidadeDominio entidadeDomino) {
        
        f = new Fachada();
        
        return f.consultar(entidadeDomino);
    
    }
    
}
