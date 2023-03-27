package com.example.lab3;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private final CarService carService;

    public ContextListener() {
        this.carService = new CarService("C:\\Users\\redmik\\IdeaProjects\\Lab-3\\cars");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("carService", carService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        carService.saveCars();
    }
}
