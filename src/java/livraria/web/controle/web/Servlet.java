//Front Controller da aplicação
//@author John Vitor da Silva Quispe
//@date 21/03/2018

package livraria.web.controle.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livraria.aplicacao.Resultado;
import livraria.web.controle.web.command.ICommand;
import livraria.web.controle.web.command.impl.CommandConsultar;
import livraria.web.controle.web.command.impl.CommandSalvar;
import livraria.web.controle.web.vh.IViewHelper;
import livraria.web.controle.web.vh.impl.ViewHelperAtivacao;
import livraria.web.controle.web.vh.impl.ViewHelperLivro;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    private Map<String, IViewHelper> vhs;
    private Map<String, ICommand> commands;
    
    public Servlet(){
        
       //Hashmap contendo todas as instâncias do ViewHelper
       vhs = new HashMap<String, IViewHelper>();
       
       //Instanciando as viewhelpers no Map vhs
       vhs.put("/livrariaOnline/salvarLivro", new ViewHelperLivro());
       vhs.put("/livrariaOnline/consultarLivro", new ViewHelperLivro());
       vhs.put("/livrariaOnline/salvarAtivacao", new ViewHelperAtivacao());
       
       //Hashmap contendo todas as instâncias do command
       commands = new HashMap<String, ICommand>();
              
       //Instanciando o command consultar no Hashmap commands
       commands.put("consultar", new CommandConsultar());
       commands.put("salvar", new CommandSalvar());
       
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uri = request.getRequestURI();
                
        String operacao = request.getParameter("operacao");
        
        IViewHelper vh = vhs.get(uri);
        
        ICommand cmd = commands.get(operacao);
        
        vh.getEntidade(request, response);
        
        Resultado resultado = cmd.executar(vh.getEntidade(request, response));
        
        vh.setView(resultado, request, response);
        
    }

}
