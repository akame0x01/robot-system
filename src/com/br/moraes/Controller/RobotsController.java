package com.br.moraes.Controller;


import java.sql.Connection;
import java.util.List;

import com.br.moraes.DAO.RobotsDAO;
import com.br.moraes.Models.ConnectionFactory;
import com.br.moraes.Models.Robot;

public class RobotsController {
    private RobotsDAO robotsDAO;

    public RobotsController() {
        Connection connection = new ConnectionFactory().recuperarConexao();
        this.robotsDAO = new RobotsDAO(connection);
    }

    public List<Robot> showAllRobots() {
        return robotsDAO.ShowAllRobots();
    }

    public Robot searchRobot(Robot r) {
        return robotsDAO.SearchRobot(r);
    }

    public void addRobot(Robot r) {
        this.robotsDAO.addRobot(r);
    }

}
