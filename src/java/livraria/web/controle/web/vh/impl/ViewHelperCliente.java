
package livraria.web.controle.web.vh.impl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import livraria.aplicacao.Resultado;
import livraria.dominio.Endereco;
import livraria.dominio.EnderecoEntrega;
import livraria.dominio.EntidadeDominio;
import livraria.web.controle.web.vh.IViewHelper;


public class ViewHelperCliente implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

        //Endereco enderecoEntegar = (Endereco) ViewHelperEnderecoEntrega();
       
        Endereco endereco = new EnderecoEntrega();
        
        return null;
        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
