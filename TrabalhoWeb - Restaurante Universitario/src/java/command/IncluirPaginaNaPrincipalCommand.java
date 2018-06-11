/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathe
 */
public class IncluirPaginaNaPrincipalCommand implements Command{

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(IncluirPaginaNaPrincipalCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
