package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import livraria.dominio.Ativacao;
import livraria.dominio.CategoriaAtivacao;
import livraria.dominio.Categoria;
import livraria.dominio.Autor;
import java.util.Collection;
import livraria.dominio.EntidadeDominio;
import livraria.web.controle.web.command.impl.CommandConsultar;
import livraria.dominio.Livro;
import livraria.web.controle.web.command.ICommand;
import livraria.web.controle.web.command.ICommand;
import livraria.aplicacao.Resultado;

public final class consultarLivro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Livro livro = new Livro();
    CategoriaAtivacao ca = new CategoriaAtivacao();
    
    if(request.getParameter("idLivro") != null)
        livro.setId(Integer.valueOf(request.getParameter("idLivro")));

    livro.setEdicao(null);
    
    ICommand cc = new CommandConsultar();
    
    Resultado res = cc.executar(livro);
    
    Resultado rca = cc.executar(ca);
    
    
    Collection<EntidadeDominio> eds = res.getEntidades();
    
    for(EntidadeDominio ed : eds){
        livro = (Livro) ed;
    }



      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("  <html>\n");
      out.write("    <head>\n");
      out.write("      <!--Import Google Icon Font-->\n");
      out.write("      <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("      <!--Import materialize.css-->\n");
      out.write("      <link type=\"text/css\" rel=\"stylesheet\" href=\"css/materialize.min.css\"  media=\"screen,projection\"/>\n");
      out.write("      \n");
      out.write("      <link rel=\"stylesheet\" href=\"css/estilo.css\"/>\n");
      out.write("      \n");
      out.write("      <!--Let browser know website is optimized for mobile-->\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("       <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js\"></script>\n");
      out.write("      <script>\n");
      out.write("        $(document).ready(function(){\n");
      out.write("            $('select').formSelect();          \n");
      out.write("        });\n");
      out.write("     \n");
      out.write("      </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"navbar-fixed\">\n");
      out.write("        <nav>\n");
      out.write("          <div class=\"nav-wrapper z-depth-0 blue\">\n");
      out.write("            <a href=\"#\" class=\"brand\">Livraria Online</a>\n");
      out.write("             <ul class=\"right hide-on-med-and-down\">\n");
      out.write("                <li><a href=\"perfilAdmin.html\"><i class=\"material-icons left\">assignment_ind</i>Administrador</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"aside\">\n");
      out.write("            <ul class=\"menu cols 12\">\n");
      out.write("                <li class=\"active\"><a href=\"listarLivros.jsp\"><i class=\"material-icons left\">book</i>Gerenciamento de Livros</a></li>                \n");
      out.write("            </ul>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div id=\"container\">\n");
      out.write("          <div class=\"breadcrumb_container\">\n");
      out.write("              <a href=\"listarLivros.jsp\">Gerenciamento de Livros</a>\n");
      out.write("              <p> > </p>\n");
      out.write("              <a href=\"consultarLivro.jsp\">Consulta de Livros</a>\n");
      out.write("          </div>\n");
      out.write("            <div class=\"content_container\">\n");
      out.write("                <div class=\"topo\">\n");
      out.write("                    <h5>Consulta de Livro</h5>\n");
      out.write("                    <div class=\"clearfix\"></div>\n");
      out.write("                </div>                      \n");
      out.write("                <div class=\"produto\">\n");
      out.write("                    <div class=\"foto\">\n");
      out.write("                        <img src=\"http://via.placeholder.com/250x300px\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"informacoes\">\n");
      out.write("                        <div class=\"titulo\">\n");
      out.write("                            <h5>");
      out.print( livro.getTitulo() + " - " + livro.getSubtitulo() );
      out.write("</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <p><b>Autor: </b>\n");
      out.write("                        ");

                        
                            int i = 0;
                            
                            for(Autor autor : livro.getAutor()){
                                i++;
                                out.print(autor.getNome() + " ");
                                                                
                                if(livro.getAutor().size() > 1 && i != livro.getAutor().size())
                                    out.print(" / ");
                                
                            }

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Editora: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEditora().getNome());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Edição </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEdicao().getNumero());

                        
      out.write("\n");
      out.write("                        º\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Ano: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEdicao().getAno());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Número de páginas: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEdicao().getNumeroPaginas());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Dimensoes: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEdicao().getDimensoes().getAltura() + " x " +
                                    livro.getEdicao().getDimensoes().getLargura() + " x " +
                                    livro.getEdicao().getDimensoes().getProfundidade());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Peso: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getEdicao().getDimensoes().getPeso().getQuantidade() +
                                    " " + livro.getEdicao().getDimensoes().getPeso().getUnidadeMedida().getNome());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Data Cadastro: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getDataCadastro().getDate() + "/" + (livro.getDataCadastro().getMonth()+1) + "/" +
                                    (livro.getDataCadastro().getYear() + 1900));

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Categoria(s): </b>\n");
      out.write("                        ");

                            
                            for(Categoria categoria : livro.getCategoria()){
                                
                                out.print(categoria.getNome() + ", ");
                                        
                                
                            }
                                 
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Código de Barras: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getCodigoBarras());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Grupo de Precificação: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getGrupoPrecificacao().getNome());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <p><b>Sinopse: </b>\n");
      out.write("                        ");

                                                  
                            out.print(livro.getSinopse());

                        
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                        <div class=\"clearfix\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"info\">\n");
      out.write("                    <h5>Informação de Acesso</h5>\n");
      out.write("                    <p><b>Esse livro está ");
      out.print( (livro.isAtivo()) ? "ativo" : "inativo"  );
      out.write("</b></p>\n");
      out.write("                    <a href=\"alteraLivro.jsp?id=");
      out.print( livro.getId() );
      out.write("\">Alterar dados do livro</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"formulario\">\n");
      out.write("                    ");


                        if(!livro.isAtivo()){
                            
                            
      out.write("\n");
      out.write("                            <form method=\"POST\" action=\"salvarAtivacao\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s12\">\n");
      out.write("                                        <select name=\"categoriaAtivacao\">\n");
      out.write("                                            <option value=\"0\" selected>Selecione</option>  \n");
      out.write("                                          ");


                                                for(EntidadeDominio e : rca.getEntidades()){

                                                    CategoriaAtivacao categoriaAtivacao = (CategoriaAtivacao) e;                                           
                                                    
      out.write("\n");
      out.write("                                                    <option value=\"");
      out.print( categoriaAtivacao.getId() );
      out.write('"');
      out.write('>');
      out.print( categoriaAtivacao.getNome() );
      out.write("</option>\n");
      out.write("                                                    ");
                                            

                                                }
                                          
      out.write("  \n");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                        <label>Selecione o grupo de precificação</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s12\">\n");
      out.write("                                        <textarea name=\"justificativa\" id=\"textarea1\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                                        <label for=\"sinopse\">Justificativa</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <input type=\"hidden\" name=\"idLivro\" value=\"");
      out.print( livro.getId() );
      out.write("\">\n");
      out.write("                                <center>\n");
      out.write("                                    <button name=\"operacao\" value=\"salvar\">Ativar Livro</button>\n");
      out.write("                                </center>\n");
      out.write("                            </form>\n");
      out.write("                            \n");
      out.write("                            ");

                            
                            
                        }else{
                        
                        
      out.write("\n");
      out.write("                        \n");
      out.write("                        <form method=\"POST\" action=\"salvarInativacao\">\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s12\">\n");
      out.write("                                        <select name=\"categoriaAtivacao\">\n");
      out.write("                                            <option value=\"0\" selected>Selecione</option>  \n");
      out.write("                                          ");


                                                for(EntidadeDominio e : rca.getEntidades()){

                                                    CategoriaAtivacao categoriaAtivacao = (CategoriaAtivacao) e;                                           
                                                    
      out.write("\n");
      out.write("                                                    <option value=\"");
      out.print( categoriaAtivacao.getId() );
      out.write('"');
      out.write('>');
      out.print( categoriaAtivacao.getNome() );
      out.write("</option>\n");
      out.write("                                                    ");
                                            

                                                }
                                          
      out.write("  \n");
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                        <label>Selecione o grupo de precificação</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"row\">\n");
      out.write("                                    <div class=\"input-field col s12\">\n");
      out.write("                                        <textarea name=\"justificativa\" id=\"textarea1\" class=\"materialize-textarea\"></textarea>\n");
      out.write("                                        <label for=\"sinopse\">Justificativa</label>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <button name=\"operacao\" value=\"salvar\">Desativar Livro</button>\n");
      out.write("                        </form>\n");
      out.write("                        \n");
      out.write("                        ");


                        }

                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("      <!--JavaScript at end of body for optimized loading-->\n");
      out.write("      <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("  </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
