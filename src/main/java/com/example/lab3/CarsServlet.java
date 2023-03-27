package com.example.lab3;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "carsServlet", value = "/cars")
public class CarsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private CarService carService;

    @Override
    public void init() {
        carService = (CarService) getServletContext().getAttribute("carService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(carService.getCars()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Car car = objectMapper.readValue(request.getInputStream(), Car.class);
        carService.addCar(car);
    }
}
