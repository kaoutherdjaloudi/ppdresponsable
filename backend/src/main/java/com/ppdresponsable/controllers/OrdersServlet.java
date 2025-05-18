package com.ppdresponsable.controllers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppdresponsable.models.FactureDetails;
import com.ppdresponsable.services.FactureService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

    private FactureService service;
    private static final Logger logger = Logger.getLogger(OrdersServlet.class.getName());

    @Override
    public void init() {
        service = new FactureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            List<FactureDetails> factures = service.getFacturesDetails();
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(factures));

        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Erreur lors de la récupération des commandes.\"}");
            logger.log(Level.SEVERE, "Erreur dans OrdersServlet", e);
        }
    }
}