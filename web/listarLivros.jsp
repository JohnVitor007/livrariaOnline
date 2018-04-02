<%@page import="livraria.dominio.Edicao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="livraria.dominio.GrupoPrecificacao"%>
<%@page import="livraria.dominio.UnidadeMedida"%>
<%@page import="java.util.Collection"%>
<%@page import="livraria.dominio.EntidadeDominio"%>
<%@page import="livraria.web.controle.web.command.impl.CommandConsultar"%>
<%@page import="livraria.dominio.Livro"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.aplicacao.Resultado"%>
<%

    Livro livro = new Livro();
    
    GrupoPrecificacao gp = new GrupoPrecificacao();
        
    ICommand cc = new CommandConsultar();
        
    Resultado res = cc.executar(livro);
    
    if(session.getAttribute("resultado") != null){
        res = (Resultado)session.getAttribute("resultado");
        request.getSession().setAttribute("resultado", null);
    }
    
    Collection<EntidadeDominio> eds = res.getEntidades();

    UnidadeMedida quilo = new UnidadeMedida();
    quilo.setNome("quilo(s)");
    
    UnidadeMedida grama = new UnidadeMedida();
    grama.setNome("grama(s)");

    Resultado rgp = cc.executar(gp);
    Collection<EntidadeDominio> egps = rgp.getEntidades();
       
%>  

<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <!--Import materialize.css-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      
      <link rel="stylesheet" href="css/estilo.css"/>
      
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <script src="js/jquery.js"></script>
      <script>
          $(document).ready(function(){
            $('select').formSelect();
            $("#buscaAvancada").toggle();        
            $("#a_busca_avancada").click(function(){
                $("#buscaAvancada").toggle();
            });
            
        
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
              
          </div>
            <div class="content_container">
                <div class="topo">
                    <p>Livros Cadastrados</p>
                    <a href="cadastrarLivro.jsp" class="waves-effect waves-light btn blue"><i class="material-icons left">add</i>Cadastrar Livro</a>
                    <div class="clearfix"></div>
                </div>
                <div id="buscaAvancada" class="buscaAvancada">
                    <form method="POST" action="consultarLivro">
                        <div class="row">
                            <div class="input-field col s6">
                                <input name="titulo" placeholder="Insira o título do livro" type="text" class="validate">
                                <label for="titulo">Titulo</label>
                            </div>
                            <div class="input-field col s6">
                                <input name="subtitulo" placeholder="Insira o subtítulo do livro" type="text" class="validate">
                                <label for="subtitulo">Subtitulo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s3">
                                <input name="edicao" placeholder="Somente números" type="text" class="validate">
                                <label for="edicao">Edição</label>
                            </div>
                            <div class="input-field col s3">
                                <input name="ano" placeholder="Somente números" type="text" class="validate">
                                <label for="ano">Ano</label>
                            </div>
                            <div class="input-field col s3">
                                <input name="isbn" placeholder="Somente números" type="text" class="validate">
                                <label for="ISBN">ISBN</label>
                            </div>
                            <div class="input-field col s3">
                                <input name="numPaginas" placeholder="Somente números" type="text" class="validate">
                                <label for="numPaginas">Número de Páginas</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s3">
                                <input name="altura" placeholder="Somente números" type="text" class="validate">
                                <label for="altura">Altura</label>
                            </div>
                            <div class="input-field col s3">
                                <input name="largura" placeholder="Somente números" type="text" class="validate">
                                <label for="largura">Largura</label>
                            </div>
                            <div class="input-field col s3">
                                <input name="profundidade" placeholder="Somente números" type="text" class="validate">
                                <label for="profundidade">Profundidade</label>
                            </div>
                            <div class="input-field col s1">
                                <input name="peso" placeholder="Somente números" type="text" class="validate">
                                <label for="peso">Peso</label>
                            </div>
                            <div class="input-field col s2">
                                <select name="unidadeMedida">
                                    <option value="<%= grama.getNome() %>"><%= grama.getNome()  %></option>
                                    <option value="<%= quilo.getNome()  %>"><%= quilo.getNome() %></option>
                                </select>
                                <label for="unidadeMedida">Unidade de Medida</label>
                            </div>
                        </div>
                        <div class="row autor">
                            
                        </div>
                        <div class="row">
                            <div class="input-field col s3">
                                <input type="text" name="editora" list="editora">
                                <label>Selecione a Editora</label>
                            </div>
                            <div id="autor_container" class="input-field col s3">
                                <input type="text" name="autor" placeholder="Insira o autor">
                            </div>
                            <div id="categoria_container" class="input-field col s3">
                                <input type="text" name="categoria" placeholder="Insira a categoria">
                            </div>
                            <div class="input-field col s3">
                                <select name="grupoPrecificacao">
                                    <option value="0" selected>Selecione</option>  
                                  <%
                                  
                                        for(EntidadeDominio e : egps){
                                            
                                            GrupoPrecificacao grupoPrecificacao = (GrupoPrecificacao) e;
                                            
                                            DecimalFormat df = new DecimalFormat("0.#");

                                            %>
                                            <option value="<%= grupoPrecificacao.getId() %>"><%= grupoPrecificacao.getNome() + " - " + df.format(grupoPrecificacao.getPercentual()) + "%" %></option>
                                            <%                                            
                                            
                                        }
                                  %>  
                                    
                                </select>
                                <label>Selecione o grupo de precificação</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input name="codigoBarras" placeholder="Somente números" type="text" class="validate">
                                <label for="codigoBarras">Código de barras</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <textarea name="sinopse" id="textarea1" class="materialize-textarea"></textarea>
                                <label for="sinopse">Sinopse</label>
                            </div>
                        </div>
                        <center>
                            <button name="operacao" value="consultar">Busca Avançada</button>
                        </center>
                    </form>
                                  
                </div>
                <div id="buscaAvancada">
                    <a id="a_busca_avancada">Busca Avançada</a>
                </div>
                <div class="collection-header">
                    <div class="row">
                        <p class="col s1"><b>Foto</b></p>
                        <p class="col s3"><b>Titulo</b></p>
                        <p class="col s3"><b>Edição</b></p>
                        <p class="col s3"><b>Status</b></p>
                        <p class="col s2"><b>Operação</b></p>
                    </div>
                </div>
                 <ul class="collection">
                    <%
                        
                        for(EntidadeDominio e : eds){
                            
                            Livro l = (Livro) e;
                            %>  
                            <li class="collection-item">
                                <div class="row">
                                    <img src="" class="col s1">
                                    <p class="col s3"><%= l.getTitulo() %></p>
                                    <p class="col s3"><%= l.getEdicao().getNumero() %></p>
                                    <p class="col s3"><%= l.getStatus() %></p>
                                    <a href="consultarLivro.jsp?idLivro=<%= l.getId() %>" class="waves-effect waves-light btn green">Consultar</a>
                                </div>
                            </li>
                                   
                            <%
                            
                        }
                    
                    %>
                     
                    
                  </ul>
                
            </div>
        </div>
        
        
      <!--JavaScript at end of body for optimized loading-->
      <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
  </html>