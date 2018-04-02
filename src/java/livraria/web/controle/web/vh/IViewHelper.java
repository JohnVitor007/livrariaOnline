//Interface IViewHelper
//@author John Vitor da Silva Quispe
//@date 21/03/2018
package livraria.web.controle.web.vh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livraria.aplicacao.Resultado;
import livraria.dominio.EntidadeDominio;

public interface IViewHelper {
 
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response);
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    
}
