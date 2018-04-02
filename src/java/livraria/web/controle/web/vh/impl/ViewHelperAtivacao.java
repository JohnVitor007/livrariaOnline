package livraria.web.controle.web.vh.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livraria.aplicacao.Resultado;
import livraria.dominio.Ativacao;
import livraria.dominio.CategoriaAtivacao;
import livraria.dominio.EntidadeDominio;
import livraria.dominio.Livro;
import livraria.web.controle.web.vh.IViewHelper;


public class ViewHelperAtivacao implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
    
        Ativacao ativacao = new Ativacao();
        CategoriaAtivacao ca = new CategoriaAtivacao();
        Livro l = new Livro();
        ca.setId((Integer.valueOf(request.getParameter("categoriaAtivacao"))));
        l.setId(Integer.valueOf(request.getParameter("idLivro")));
        ativacao.setLivro(l);
        
        ativacao.setJustificativa(request.getParameter("justificativa"));
        ativacao.setCategoriaAtivacao(ca);
        
        return ativacao;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        RequestDispatcher d = null;
        
        String operacao = request.getParameter("operacao");
        
        if(operacao.equals("salvar")){
            
            d = request.getRequestDispatcher("listarLivros.jsp");
            
            request.getSession().setAttribute("resultado", resultado);
            
        }    
        
        d.forward(request, response);
    
    
    }
    
}
