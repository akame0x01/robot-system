package com.br.moraes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.moraes.Models.Robot;

public class RobotsDAO {
    private Connection connection;

    public RobotsDAO(Connection connection) {
        this.connection = connection;
    }

    public Robot SearchRobot(Robot r) {
        try {
            String sql = "select * from robots where id = ?";
            Robot robot = new Robot();

            try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstm.setInt(1, r.getId());
                pstm.execute();

                try (ResultSet resultado = pstm.getResultSet()) {
                    robot.setId(resultado.getInt(1));
                    robot.setSize(resultado.getString(2));
                    robot.setWeight(resultado.getString(3));
                    robot.setStats(resultado.getString(4));
                    robot.setColor(resultado.getString(5));
                    robot.setAge(resultado.getString(6));
                    robot.setNumberOfEyes(resultado.getString(7));
                    robot.setNumberOfAntennas(resultado.getString(8));
                }
            }
            return robot;

        } catch (SQLException s) {
            s.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<Robot> ShowAllRobots() {
        Robot ultimo = null;
        List<Robot> lRobots = new ArrayList<>();

        try {
            String sql = "select * from robots";
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                try (ResultSet result = pstm.getResultSet()) {
                    while (result.next()) {
                        if (ultimo == null || !ultimo.getId().equals(result.getInt(1))) {
                            Robot robot = new Robot();
                            robot.setId(result.getInt(1));
                            robot.setSize(result.getString(2));
                            robot.setWeight(result.getString(3));
                            robot.setStats(result.getString(4));
                            robot.setColor(result.getString(5));
                            robot.setAge(result.getString(6));
                            robot.setNumberOfEyes(result.getString(7));
                            robot.setNumberOfAntennas(result.getString(8));

                            lRobots.add(robot);
                            ultimo = robot;
                        }
                    }
                    return lRobots;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
            throw new RuntimeException();
        }

    }

    public void addRobot(Robot r) {
        try {
            String sql = "insert into robots(size,weight, stats, color,age,number_of_eyes,number_of_antennas) values (?, ? ,? ,?,?,?,?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstm.setString(1, r.getSize());
                pstm.setString(2, r.getWeight());
                pstm.setString(3, r.getStats());
                pstm.setString(4, r.getColor());
                pstm.setString(5, r.getAge());
                pstm.setString(6, r.getNumberOfEyes());
                pstm.setString(7, r.getNumberOfAntennas());

                pstm.execute();

                try (ResultSet result = pstm.getGeneratedKeys()) {
                    while (result.next()) {
                        r.setId(result.getInt(1));
                    }
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
            throw new RuntimeException();
        }
    }
}
