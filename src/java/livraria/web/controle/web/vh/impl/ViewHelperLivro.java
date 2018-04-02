//Classe ViewHelper Livro
//@author John Vitor da Silva Quispe
//@date 21/03/2018
package livraria.web.controle.web.vh.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livraria.aplicacao.Resultado;
import livraria.dominio.Autor;
import livraria.dominio.Categoria;
import livraria.dominio.Dimensao;
import livraria.dominio.Edicao;
import livraria.dominio.Editora;
import livraria.dominio.EntidadeDominio;
import livraria.dominio.GrupoPrecificacao;
import livraria.dominio.Livro;
import livraria.dominio.Peso;
import livraria.dominio.UnidadeMedida;
import livraria.web.controle.web.vh.IViewHelper;

public class ViewHelperLivro implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
    
        Livro l = new Livro();
        Edicao e = new Edicao();
        Dimensao d = new Dimensao();
        Peso p = new Peso();
        UnidadeMedida um = new UnidadeMedida();
        GrupoPrecificacao gp = new GrupoPrecificacao();
        Editora ed = new Editora();
        Autor a;  
        Categoria c;
        
        l.setTitulo(request.getParameter("titulo"));
        l.setSubtitulo(request.getParameter("subtitulo"));
        l.setISBN(request.getParameter("isbn"));
        l.setSinopse(request.getParameter("sinopse"));
        l.setCodigoBarras(request.getParameter("codigoBarras"));
        
        e.setAno((request.getParameter("ano").equals("")) ? 0 : Integer.valueOf(request.getParameter("ano")));
        e.setNumero((request.getParameter("edicao").equals("")) ? 0 : Integer.valueOf(request.getParameter("edicao")));
        e.setNumeroPaginas((request.getParameter("numPaginas").equals("")) ? 0 : Integer.valueOf(request.getParameter("numPaginas")));
        
        d.setAltura((request.getParameter("altura").equals("")) ? 0 : Double.valueOf(request.getParameter("altura")));
        d.setLargura((request.getParameter("largura").equals("")) ? 0 : Double.valueOf(request.getParameter("largura")));
        d.setProfundidade((request.getParameter("profundidade").equals("")) ? 0 : Double.valueOf(request.getParameter("profundidade")));
                
        e.setDimensoes(d);
        
        p.setQuantidade((request.getParameter("peso").equals("")) ? 0 : Double.valueOf(request.getParameter("peso")));
        
        um.setNome((request.getParameter("unidadeMedida")));
        
        p.setUnidadeMedida(um);
        
        d.setPeso(p);
        
        e.setDimensoes(d);
        
        l.setEdicao(e);
                 
        Collection<Categoria> categorias = new ArrayList<>();
        
        if(request.getParameter("categoria") != null){
            
            String[] nomesCategoria = request.getParameterValues("categoria");
        
            for(String nomeCategoria : nomesCategoria){
                c = new Categoria();

                c.setNome(nomeCategoria);
                categorias.add(c);
            }
            
        }        
               
        l.setCategoria(categorias);
        
        Collection<Autor> autores = new ArrayList<>();
                
        if(request.getParameter("autor") != null){
            
            String[] nomeAutores = request.getParameterValues("autor");
                        
            for(String nomeAutor : nomeAutores){

                a = new Autor();
                a.setId(0);
                a.setNome(nomeAutor);
                autores.add(a);

            }
            
        }        
        
        l.setAutor(autores);
                
        ed.setId(0);
        ed.setNome(request.getParameter("editora"));
        
        l.setEditora(ed);
        
        gp.setId(Integer.valueOf(request.getParameter("grupoPrecificacao")));
        
        l.setGrupoPrecificacao(gp);
        
        return l;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        RequestDispatcher d = null;
        
        String operacao = request.getParameter("operacao");
        
        if(operacao.equals("salvar")){
            if(resultado.getResultados() == null){
                d = request.getRequestDispatcher("listarLivros.jsp");
            }else{
                d = request.getRequestDispatcher("cadastrarLivro.jsp");
            }
            
            request.getSession().setAttribute("resultado", resultado);
            
        }else if(operacao.equals("consultar")){
            if(resultado.getResultados() == null){
                d = request.getRequestDispatcher("listarLivros.jsp");
            }
            
            request.getSession().setAttribute("resultado", resultado);
            d.forward(request, response);

        }    
        
        d.forward(request, response);       
        */
    
    }
    
}
