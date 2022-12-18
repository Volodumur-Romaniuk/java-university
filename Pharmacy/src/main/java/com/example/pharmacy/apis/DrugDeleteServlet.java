package com.example.pharmacy.apis;

import com.example.pharmacy.CRUD.CRUDDrugs;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DrugDeleteServlet", value = "/DrugDeleteServlet")
public class DrugDeleteServlet extends HttpServlet {
    private CRUDDrugs crudDrug;

    @Override
    public void init() throws ServletException {
        super.init();
        crudDrug = new CRUDDrugs();

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        if (req.getParameter("id") != null) {
            crudDrug.deleteById(req.getParameter("id"));
        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        super.doDelete(req, resp);
        if (req.getParameter("id") != null) {
            crudDrug.deleteById(req.getParameter("id"));
        }
    }
}
