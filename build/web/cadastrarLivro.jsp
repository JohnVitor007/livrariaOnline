<%@page import="livraria.dominio.UnidadeMedida"%>
<%@page import="livraria.dominio.Categoria"%>
<%@page import="livraria.dominio.Autor"%>
<%@page import="livraria.dominio.Editora"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="livraria.dominio.GrupoPrecificacao"%>
<%@page import="java.util.Collection"%>
<%@page import="livraria.dominio.EntidadeDominio"%>
<%@page import="livraria.web.controle.web.command.impl.CommandConsultar"%>
<%@page import="livraria.dominio.Livro"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.web.controle.web.command.ICommand"%>
<%@page import="livraria.aplicacao.Resultado"%>
<%

    GrupoPrecificacao gp = new GrupoPrecificacao();
    Editora ed = new Editora();
    Autor aut = new Autor();
    Categoria cat = new Categoria();
    Resultado resultado = new Resultado();
    String[] mensagens = null;
    
    UnidadeMedida quilo = new UnidadeMedida();
    quilo.setNome("quilo(s)");
    
    UnidadeMedida grama = new UnidadeMedida();
    grama.setNome("grama(s)");
    
    ICommand cc = new CommandConsultar();
    
    Resultado rgp = cc.executar(gp);
    Collection<EntidadeDominio> egps = rgp.getEntidades();
    
    Resultado red = cc.executar(ed);
    Collection<EntidadeDominio> eds = red.getEntidades();
    
    Resultado rau = cc.executar(aut);
    Collection<EntidadeDominio> eauts = rau.getEntidades();

    Resultado rca = cc.executar(cat);
    Collection<EntidadeDominio> ecat = rca.getEntidades();

    if(session.getAttribute("resultado") != null){
        
        resultado = (Resultado)session.getAttribute("resultado");
    
        if(resultado.getResultados().size() > 0){

            Collection<String> mensagemBuffer = resultado.getResultados();
            
            for(String m : mensagemBuffer){
                mensagens = m.split("<br>");
            }
                

        }
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
        
        
            $("#adicionar_categoria").click(function(){
                $("#categoria_container").append('<input type="text" name="categoria" list="categoria" placeholder="Insira a categoria">');    
            });
            $("#adicionar_autor").click(function(){
                
                $("#autor_container").append('<input type="text" name="autor" list="autor" placeholder="Insira o autor">');    
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
            <ul class="menu col s12">
                <li class="active"><a href="listarLivros.jsp"><i class="material-icons left">book</i>Gerenciamento de Livros</a></li>                
            </ul>
        </div>
        <div id="container">
          <div class="breadcrumb_container">
              <a href="listarLivros.jsp">Gerenciamento de Livros</a>
              <p> > </p>
              <a href="cadastraLivro.jsp">Cadastro de Livros</a>
          </div>
            <div class="content_container">
                <div class="topo">
                    <h5>Cadastrar Livro</h5>
                    <div class="clearfix"></div>
                </div>
                <div class="erros">
                    <%
                        
                        if(mensagens != null){
                            
                            for(String mensagem : mensagens){
                            %>
                                <div class="erro"><b>ATENÇÃO: </b><%= mensagem %></div> 
                            <%  
                                
                            }
                            
                        }
                        
                    %>       
                </div>
                <div class="formulario">
                    <form method="POST" action="salvarLivro">
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
                        <div  class="row">
                            <div id="categoria_container" class="input-field col s12">
                                <input type="text" name="categoria" list="categoria" placeholder="Insira a categoria">
                                <datalist id="categoria">
                                   <%
                                  
                                        for(EntidadeDominio e : ecat){
                                            
                                            Categoria categoria = (Categoria) e;
                                            
                                            %>
                                            <option value="<%= categoria.getNome() %>"><%= categoria.getNome() %></option>
                                            <%                                            
                                            
                                        }
                                  %>
                                </datalist>
                            </div>
                            <a id="adicionar_categoria">Associar mais uma categoria</a>
                        </div>
                        <div class="row">
                            
                        </div>
                        <div class="row autor">
                            <div id="autor_container" class="input-field col s12">
                                <input type="text" name="autor" list="autor" placeholder="Insira o autor">
                                <datalist id="autor">
                                    
                                    <%
                                  
                                        for(EntidadeDominio e : eauts){
                                            
                                            Autor autor = (Autor) e;
                                            
                                            %>
                                            <option value="<%= autor.getNome() %>">
                                            <%                                            
                                            
                                        }
                                  %>
                                </datalist>
                            </div>
                        </div>
                        <div class="row">
                            <a id="adicionar_autor">Adicionar mais um autor(a)</a>
                        </div>
                        
                        <div class="row">
                            <div class="input-field col s12">
                                <input type="text" name="editora" list="editora">
                                <datalist id="editora">
                                  <%
                                  
                                        for(EntidadeDominio e : eds){
                                            
                                            Editora editora = (Editora) e;
                                            
                                            %>
                                            <option value="<%= editora.getNome() %>">
                                            <%                                            
                                            
                                        }
                                  %>  
                                </datalist>
                                <label>Selecione a Editora</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
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
                            <div class="input-field col s6">
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
                            <button name="operacao" value="salvar">Cadastrar</button>
                        </center>
                    </form>
                </div>  
                
            </div>
        </div>
        
        
      <!--JavaScript at end of body for optimized loading-->
      <script type="text/javascript" src="js/materialize.min.js"></script>
      
    </body>
  </html>