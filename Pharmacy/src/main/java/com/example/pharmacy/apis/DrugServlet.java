package com.example.pharmacy.apis;

import com.example.pharmacy.CRUD.CRUDDrugs;
import com.example.pharmacy.model.Drug;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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

        String jsonData = gson.toJson(crudDrug.getAll());
        if (req.getParameter("ascend") != null) {
            jsonData = gson.toJson(crudDrug.getAllAscend());
        }
        if (req.getParameter("descend") != null) {
            jsonData = gson.toJson(crudDrug.getAllDescend());
        }
        if (req.getParameter("search") != null) {
            searchRequest(req.getParameter("search"), response);
        }


        try (PrintWriter out = response.getWriter()) {
            out.println(jsonData);
        } catch (Exception e) {
            response.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
            buffer.append(System.lineSeparator());
        }
        String data = buffer.toString();
        var res = gson.fromJson(data, Drug.class);

        try {
            var drug = crudDrug.insertDrug(res);
            resp.setStatus(200);
            var json = gson.toJson(drug);
            PrintWriter out = resp.getWriter();
            out.println(json);
        } catch (NullPointerException e) {
            resp.setStatus(400);
            PrintWriter out = resp.getWriter();
            out.println(gson.toJson(new Error()));
        }

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        if (req.getParameter("id") != null) {
            crudDrug.deleteById(req.getParameter("id"));
        }

    }


    private void searchRequest(String text, HttpServletResponse response) throws IOException {
        var list = crudDrug.searchDrug(text);
        String jsonData = gson.toJson(list);
        PrintWriter out = response.getWriter();
        try {
            out.println(jsonData);
        } catch (Exception e) {
            response.setStatus(400);
        } finally {
            out.close();
        }
    }

}
