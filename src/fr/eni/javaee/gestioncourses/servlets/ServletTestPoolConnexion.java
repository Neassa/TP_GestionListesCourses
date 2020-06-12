package fr.eni.javaee.gestioncourses.servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Context context = new InitialContext();
            //Recherche de la DataSource
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
            //Demande une connexion. La méthode getConnectio met la demande en attente tant qu'il n'y a pas
            //de connexion disponible dans le pool.
            Connection cnx = dataSource.getConnection();
            //Exploitatin de la connexion
            out.print("La connexion est " + (cnx.isClosed()?"fermée":"ouverte")+".");
            //Libérer la connexion lorsque l'on en a plus besoin:
            cnx.close();//La conexion est remise dans le pool
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
        }

    }
}
