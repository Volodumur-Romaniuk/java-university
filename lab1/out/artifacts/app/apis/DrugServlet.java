package apis;

import CRUD.CRUDDrugs;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DrugServlet", value = "/DrugServlet")
public class DrugServlet extends HttpServlet {
    private CRUDDrugs crudDrug;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        gson = new Gson();
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String jsonData = gson.toJson(crudDrug.getAll());
        try (PrintWriter out = response.getWriter()) {
            out.println(jsonData);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

}
