package pl.narodzinyprogramisty.servlet;

import pl.narodzinyprogramisty.entity.Ad;
import pl.narodzinyprogramisty.entity.NormalUser;
import pl.narodzinyprogramisty.entity.User;
import pl.narodzinyprogramisty.service.HibernateService;
import pl.narodzinyprogramisty.service.MySQLService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {


    private String name;
    private String lastName;
    private String login;
    private String password1;
    private String password2;
    private String isAccept;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        lastName = req.getParameter("lastName");
        login = req.getParameter("login");
        password1 = req.getParameter("pass1");
        password2 = req.getParameter("pass2");
        isAccept = req.getParameter("regulations");


        if ( validate()){
            NormalUser normalUser = createUser();
            resp.getWriter().write(normalUser.toString());
        }

    }

    private NormalUser createUser() {
        NormalUser user = new NormalUser(new User(name,lastName,password1,login),"address",new ArrayList<Ad>());
        return user;
    }


    private boolean validate() {
        if (password1.equals(password2)) {
            return true;
        }
        return false;

    }

}
