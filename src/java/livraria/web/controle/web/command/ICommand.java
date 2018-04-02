//Interface Command
//@author John Vitor da Silva Quispe
//@date 21/03/2018

package livraria.web.controle.web.command;

import livraria.aplicacao.Resultado;
import livraria.dominio.EntidadeDominio;

public interface ICommand {
    
    public Resultado executar(EntidadeDominio entidadeDomino);
    
}
