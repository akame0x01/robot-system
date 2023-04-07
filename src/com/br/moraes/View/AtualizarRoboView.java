package com.br.moraes.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.ListSelectionModel;

import com.br.moraes.Controller.RobotsController;
import com.br.moraes.Models.Robot;
import com.br.moraes.Models.TableRobots;

public class AtualizarRoboView extends JFrame {
    private RobotsController robotsController;
    private TableRobots modelTableRobots;
    private JTable tbRobots;
    private JScrollPane scrollPane;

    public AtualizarRoboView() {
        this.robotsController = new RobotsController();
       

        this.setBounds(0, 0, 1000, 527);
        JPanel btnexit = new JPanel();
        btnexit.setBounds(780, 0, 53, 36);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btnexit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btnexit.setBackground(new Color(12, 138, 199));
            }
        });

        tbRobots = new JTable();
        preencherTabela();
        tbRobots.setModel(this.modelTableRobots);
        tbRobots.setEnabled(false);
        tbRobots.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbRobots.setFont(new Font("Roboto", Font.PLAIN, 16));

        this.scrollPane = new JScrollPane(tbRobots);

        this.add(scrollPane);


    }

    private void preencherTabela() {
        ArrayList<Robot> lRobots = (ArrayList<Robot>) robotsController.showAllRobots();
        this.modelTableRobots = new TableRobots(lRobots);
        boolean jaExiste = false;
        for (int i = 0; i < tbRobots.getRowCount(); i++) {
            int column = 0;
            Integer value = (Integer) tbRobots.getValueAt(i, column);

            for (Robot robot : lRobots) {

                if (value == robot.getId()) {
                    jaExiste = true;
                }

                if (!jaExiste) {
                    modelTableRobots.addRow(robot);
                }
            }
        }

    }

}
