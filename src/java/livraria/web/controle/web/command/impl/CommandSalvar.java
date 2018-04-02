//Command Salva
//@author John Vitor da Sivla Quispe
//@date 22/03/2018

package livraria.web.controle.web.command.impl;

import livraria.aplicacao.Resultado;
import livraria.controle.impl.Fachada;
import livraria.dominio.EntidadeDominio;
import livraria.web.controle.web.command.ICommand;

public class CommandSalvar implements ICommand{

    private Fachada f;
    
    @Override
    public Resultado executar(EntidadeDominio entidadeDomino) {
    
        f = new Fachada();
        
        return f.salvar(entidadeDomino);
        
    }


    
}
