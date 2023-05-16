package ru.molokoin.j200_jpa.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import ru.molokoin.j200_jpa.entities.Domains;
import ru.molokoin.j200_jpa.entities.Person;
import ru.molokoin.j200_jpa.services.RepositoryFace;

@WebServlet(name = "Listing", value = "/listing")
public class Listing extends HttpServlet{
    @EJB
    private RepositoryFace repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        page(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        page(request, response);
    }

    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Person> persons = repository.getAllPerson();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("    <meta charset=\"UTF-8\">");
            out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("    <title>j200_jpa</title>");
            //out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
            out.println("</head>");

            out.println("<html>");
            out.println("<body>");
            //aside
            out.println("<aside>");
            out.println("</aside>");
            //main
            out.println("<main>");
            out.println("<p>Листинг из базы:</p>");
            
            for(Person person : persons){
                out.println("<br>");
                out.println("<p>" + person.toString() + "<p>");

                // Collection<Domains> domains = person.getDomainsCollection();
                // if(domains.size()>0){
                //     for(Domains domain : person.getDomainsCollection()){
                //         out.println("<tr>");
                //         out.println("<td>" + person.getId() + "</td>");
                //         out.println("<td>" + person.getJobtitle() + "</td>");
                //         out.println("<td>" + person.getFirstnamelastname() + "</td>");
                //         out.println("<td>" + person.getPhone() + "</td>");
                //         out.println("<td>" + person.getEmail() + "</td>");
                //         out.println("<td>" + domain.getId() + "</td>");
                //         out.println("<td>" + domain.getWebname()+ "</td>");
                //         out.println("<td>" + domain.getDomainname()+ "</td>");
                //         out.println("<td>" + domain.getIp() + "</td>");
                //         out.println("<td>" + domain.getCountryreg() + "</td>");
                //         out.println("</tr>");
                //     }
                // }
                //  else {
                //         out.println("<tr>");
                //             out.println("<td>" + person.getId() + "</td>");
                //             out.println("<td>" + person.getJobtitle() + "</td>");
                //             out.println("<td>" + person.getFirstnamelastname() + "</td>");
                //             out.println("<td>" + person.getPhone() + "</td>");
                //             out.println("<td>" + person.getEmail() + "</td>");
                //             out.println("<td></td><td></td><td></td><td></td><td></td>");
                //         out.println("</tr>");
                // }
            }
            out.println("</main>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
}
