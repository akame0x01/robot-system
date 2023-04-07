package com.br.moraes.Models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableRobots extends AbstractTableModel {
    private List<Robot> Robots;
    private String[] colunas = { "ID", "SIZE", "WEIGHT", "STATS", "COLOR","AGE","NUMBER OF EYES","NUMBER OF ANTENNAS"};
    private final int coluna_id = 0;
    private final int coluna_size = 1;
    private final int coluna_weight = 2;
    private final int coluna_stats = 3;
    private final int coluna_color = 4;
    private final int coluna_age = 5;
    private final int coluna_numberOfEyes = 6;
    private final int coluna_numberOfAntennas = 7;

    public TableRobots() {
        this.Robots = new ArrayList<>();
    }

    public TableRobots(ArrayList<Robot> Robots) {
        this.Robots = Robots;
    }

    // retorna celula é editavel ou nao;
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    // retorna a quantidade de linhas
    @Override
    public int getRowCount() {
        return Robots.size();

    }

    // retorna quantidade de colunas
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    // retorna o nome de determinada coluna
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    public void RemoveRow(int row) {
        Robots.remove(row);
        fireTableDataChanged();
    }

    // retorna o valor da celula em determinada linha e coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // puxa a Robots do arrayList de Robotss
        Robot robot = this.Robots.get(rowIndex);

        switch (columnIndex) {
            case coluna_id:
                return robot.getId();
            case coluna_size:
                return robot.getSize();
            case coluna_weight:
                return robot.getWeight();
            case coluna_age:
                return robot.getAge();
            case coluna_color:
                return robot.getColor();
            case coluna_stats :
                return robot.getStats();
            case coluna_numberOfEyes :
                return robot.getNumberOfEyes();
            case coluna_numberOfAntennas :
                return robot.getNumberOfAntennas();        
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Robot robot = this.Robots.get(rowIndex);
        // como recebemos um Object,é recomendavel fazer um cast
        switch (columnIndex) {
            case coluna_size:
                robot.setSize(String.valueOf(aValue));
                break;
            case coluna_weight:
                robot.setWeight(String.valueOf(aValue));
                break;
            case coluna_age:
                robot.setAge(String.valueOf(aValue));
                break;
            case coluna_color:
                robot.setColor(String.valueOf(aValue));
                break;
            case coluna_stats:
                robot.setStats(String.valueOf(aValue));
                break;
            case coluna_numberOfAntennas :
                robot.setNumberOfAntennas(String.valueOf(aValue));
            case coluna_numberOfEyes :
                robot.setNumberOfEyes(String.valueOf(aValue));    
        }
        fireTableDataChanged();
    }

    // adiciona um novo objeto e notifica os listerners da tabela
    public void addRow(Robot r) {
        this.Robots.add(r);
        this.fireTableRowsInserted(this.indexOf(r), this.indexOf(r));
    }

    private int indexOf(Robot r) {
        return this.Robots.indexOf(r);
    }

    public List<Robot> getDataVector() {
        return null;
    }

    public void setRowCount(int rowCount) {
        int oldRowCount = getRowCount();
        if (rowCount > oldRowCount) {
            fireTableRowsInserted(oldRowCount, rowCount - 1);
        } else if (rowCount < oldRowCount) {
            fireTableRowsDeleted(rowCount, oldRowCount - 1);
        }
    }

}
