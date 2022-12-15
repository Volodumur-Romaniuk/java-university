package com.example.pharmacy.apis;

import com.example.pharmacy.CRUD.CRUDDrugs;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DrugServlet", value = "/DrugServlet")
public class DrugServlet extends HttpServlet {
    private CRUDDrugs crudDrug;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        crudDrug = new CRUDDrugs();
        gson = new Gson();
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3001");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String jsonData = gson.toJson(crudDrug.getAll());
        if(req.getParameter("ascend") != null){
             jsonData = gson.toJson(crudDrug.getAllAscend());
        }
        if(req.getParameter("descend") != null){
             jsonData = gson.toJson(crudDrug.getAllDescend());
        }
        if(req.getParameter("search") != null){
            searchRequest(req.getParameter("search"),response);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println(jsonData);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

    private void searchRequest(String text, HttpServletResponse response) throws IOException {
        var list = crudDrug.searchDrug(text);
        String jsonData = gson.toJson(list);
        PrintWriter out = response.getWriter();
        try {
            out.println(jsonData);
        }
        catch (Exception e){
            response.setStatus(400);
        }
        finally {
            out.close();
        }
    }

}
