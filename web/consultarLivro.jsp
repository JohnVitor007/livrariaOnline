<%@page import="livraria.dominio.Ativacao"%>
<%@page import="livraria.dominio.CategoriaAtivacao"%>
<%@page import="livraria.dominio.Categoria"%>
<%@page import="livraria.dominio.Autor"%>
<%@page import="java.util.Collection"%>
<%@page import="livraria.dominio.EntidadeDominio"%>
<%@page import="livraria.web.controle.web.command.impl.CommandConsultar"%>
<%@page import="livraria.dominio.Livro"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.aplicacao.Resultado"%>
<%
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


%>  

<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      
      <link rel="stylesheet" href="css/estilo.css"/>
      
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
      <script>
        $(document).ready(function(){
            $('select').formSelect();          
        });
     
      </script>
    </head>

    <body>
        <div class="navbar-fixed">
        <nav>
          <div class="nav-wrapper z-depth-0 blue">
            <a href="#" class="brand">Livraria Online</a>
             <ul class="right hide-on-med-and-down">
                <li><a href="perfilAdmin.html"><i class="material-icons left">assignment_ind</i>Administrador</a></li>
            </ul>
          </div>
        </nav>
        </div>
        <div id="aside">
            <ul class="menu cols 12">
                <li class="active"><a href="listarLivros.jsp"><i class="material-icons left">book</i>Gerenciamento de Livros</a></li>                
            </ul>
            
        </div>
        <div id="container">
          <div class="breadcrumb_container">
              <a href="listarLivros.jsp">Gerenciamento de Livros</a>
              <p> > </p>
              <a href="consultarLivro.jsp">Consulta de Livros</a>
          </div>
            <div class="content_container">
                <div class="topo">
                    <h5>Consulta de Livro</h5>
                    <div class="clearfix"></div>
                </div>                      
                <div class="produto">
                    <div class="foto">
                        <img src="http://via.placeholder.com/250x300px">
                    </div>
                    <div class="informacoes">
                        <div class="titulo">
                            <h5><%= livro.getTitulo() + " - " + livro.getSubtitulo() %></h5>
                        </div>
                        <p><b>Autor: </b>
                        <%
                        
                            int i = 0;
                            
                            for(Autor autor : livro.getAutor()){
                                i++;
                                out.print(autor.getNome() + " ");
                                                                
                                if(livro.getAutor().size() > 1 && i != livro.getAutor().size())
                                    out.print(" / ");
                                
                            }

                        %>
                        </p>
                        <p><b>Editora: </b>
                        <%
                                                  
                            out.print(livro.getEditora().getNome());

                        %>
                        </p>
                        <p><b>Edição </b>
                        <%
                                                  
                            out.print(livro.getEdicao().getNumero());

                        %>
                        º
                        </p>
                        <p><b>Ano: </b>
                        <%
                                                  
                            out.print(livro.getEdicao().getAno());

                        %>
                        </p>
                        <p><b>Número de páginas: </b>
                        <%
                                                  
                            out.print(livro.getEdicao().getNumeroPaginas());

                        %>
                        </p>
                        <p><b>Dimensoes: </b>
                        <%
                                                  
                            out.print(livro.getEdicao().getDimensoes().getAltura() + " x " +
                                    livro.getEdicao().getDimensoes().getLargura() + " x " +
                                    livro.getEdicao().getDimensoes().getProfundidade());

                        %>
                        </p>
                        <p><b>Peso: </b>
                        <%
                                                  
                            out.print(livro.getEdicao().getDimensoes().getPeso().getQuantidade() +
                                    " " + livro.getEdicao().getDimensoes().getPeso().getUnidadeMedida().getNome());

                        %>
                        </p>
                        <p><b>Data Cadastro: </b>
                        <%
                                                  
                            out.print(livro.getDataCadastro().getDate() + "/" + (livro.getDataCadastro().getMonth()+1) + "/" +
                                    (livro.getDataCadastro().getYear() + 1900));

                        %>
                        </p>
                        <p><b>Categoria(s): </b>
                        <%
                            
                            for(Categoria categoria : livro.getCategoria()){
                                
                                out.print(categoria.getNome() + ", ");
                                        
                                
                            }
                                 
                        %>
                        
                        </p>
                        <p><b>Código de Barras: </b>
                        <%
                                                  
                            out.print(livro.getCodigoBarras());

                        %>
                        </p>
                        <p><b>Grupo de Precificação: </b>
                        <%
                                                  
                            out.print(livro.getGrupoPrecificacao().getNome());

                        %>
                        </p>
                        <p><b>Sinopse: </b>
                        <%
                                                  
                            out.print(livro.getSinopse());

                        %>
                        </p>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <div class="info">
                    <h5>Informação de Acesso</h5>
                    <p><b>Esse livro está <%= (livro.isAtivo()) ? "ativo" : "inativo"  %></b></p>
                    <a href="alteraLivro.jsp?id=<%= livro.getId() %>">Alterar dados do livro</a>
                </div>
                <div class="formulario">
                    <%

                        if(!livro.isAtivo()){
                            
                            %>
                            <form method="POST" action="salvarAtivacao">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <select name="categoriaAtivacao">
                                            <option value="0" selected>Selecione</option>  
                                          <%

                                                for(EntidadeDominio e : rca.getEntidades()){

                                                    CategoriaAtivacao categoriaAtivacao = (CategoriaAtivacao) e;                                           
                                                    %>
                                                    <option value="<%= categoriaAtivacao.getId() %>"><%= categoriaAtivacao.getNome() %></option>
                                                    <%                                            

                                                }
                                          %>  

                                        </select>
                                        <label>Selecione o grupo de precificação</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <textarea name="justificativa" id="textarea1" class="materialize-textarea"></textarea>
                                        <label for="sinopse">Justificativa</label>
                                    </div>
                                </div>
                                <input type="hidden" name="idLivro" value="<%= livro.getId() %>">
                                <center>
                                    <button name="operacao" value="salvar">Ativar Livro</button>
                                </center>
                            </form>
                            
                            <%
                            
                            
                        }else{
                        
                        %>
                        
                        <form method="POST" action="salvarInativacao">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <select name="categoriaAtivacao">
                                            <option value="0" selected>Selecione</option>  
                                          <%

                                                for(EntidadeDominio e : rca.getEntidades()){

                                                    CategoriaAtivacao categoriaAtivacao = (CategoriaAtivacao) e;                                           
                                                    %>
                                                    <option value="<%= categoriaAtivacao.getId() %>"><%= categoriaAtivacao.getNome() %></option>
                                                    <%                                            

                                                }
                                          %>  

                                        </select>
                                        <label>Selecione o grupo de precificação</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <textarea name="justificativa" id="textarea1" class="materialize-textarea"></textarea>
                                        <label for="sinopse">Justificativa</label>
                                    </div>
                                </div>
                                <button name="operacao" value="salvar">Desativar Livro</button>
                        </form>
                        
                        <%

                        }

                    %>
                </div>
            </div>
        </div>
        
        
      <!--JavaScript at end of body for optimized loading-->
      <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
  </html>