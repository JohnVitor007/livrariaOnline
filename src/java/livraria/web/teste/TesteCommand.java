package livraria.web.teste;

import livraria.aplicacao.Resultado;
import livraria.dominio.EntidadeDominio;
import livraria.dominio.GrupoPrecificacao;
import livraria.web.controle.web.command.ICommand;
import livraria.web.controle.web.command.impl.CommandConsultar;
import livraria.web.controle.web.command.impl.CommandSalvar;

/**
 *
 * @author johnv
 */
public class TesteCommand {

    public static void main(String[] args) {
        
        ICommand cc = new CommandConsultar();
        
        GrupoPrecificacao gp = new GrupoPrecificacao();
        
        Resultado r = cc.executar(gp);
        
        for(EntidadeDominio ed : r.getEntidades()){
            
            GrupoPrecificacao g = (GrupoPrecificacao) ed;
            System.out.println(g.getNome());
            
            
        }
        
        ICommand cs = new CommandSalvar();
        
        cs.executar(gp);
        
        
        
    }
    
}
