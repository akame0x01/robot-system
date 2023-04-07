package com.br.moraes.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;




public class View extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        View v = new View();
        v.setVisible(true);
    }

    public View() {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 788, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 788, 527);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel titulo = new JLabel("Feito Por Moraeskkj");
        Font fonte = new Font("Game Over", Font.PLAIN, 40);
		titulo.setBounds(200,0 , 400, 200);
        titulo.setFont(fonte);
		titulo.setForeground(SystemColor.controlLtHighlight);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.BLACK);
		panel.add(titulo);

        JPanel btnexit = new JPanel();
        btnexit.setBounds(735, 0, 53, 36);
        panel.add(btnexit);
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

        JButton btnAtualizar = new JButton();
        btnAtualizar.setBounds(150,200,160,50);
        btnAtualizar.setLayout(null);
		btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(btnAtualizar);
        btnAtualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AtualizarRoboView a = new AtualizarRoboView();
                a.setVisible(true);
            }
        });

        JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setBounds(0, 0, 160, 50);
		lblAtualizar.setForeground(SystemColor.controlLtHighlight);
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
        lblAtualizar.setForeground(Color.BLACK);
		btnAtualizar.add(lblAtualizar);

        JButton btnVerRobo = new JButton();
        btnVerRobo.setBounds(450,200,160,50);
        btnVerRobo.setLayout(null);
		btnVerRobo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(btnVerRobo);
        btnVerRobo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //VerRoboView v = new verRoboView();
                //v.setVisible(true)
            }
        });

        JLabel lblVerRobo = new JLabel("Ver Todos os Robos");
		lblVerRobo.setBounds(0, 0, 160, 50);
		lblVerRobo.setForeground(SystemColor.controlLtHighlight);
		lblVerRobo.setHorizontalAlignment(SwingConstants.CENTER);
        lblVerRobo.setForeground(Color.BLACK);
		btnVerRobo.add(lblVerRobo);


        JButton btnPesquisarPorRobo = new JButton();
        btnPesquisarPorRobo.setBounds(450,400,160,50);
        btnPesquisarPorRobo.setLayout(null);
		btnPesquisarPorRobo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(btnPesquisarPorRobo);
        btnPesquisarPorRobo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //PesquisarRoboView v = new PesquisarRoboView();
                //v.setVisible(true)
            }
        });

        JLabel lblPesquisarPorRobo = new JLabel("Pesquisar Por um Robo");
        lblPesquisarPorRobo.setBounds(0, 0, 160, 50);
		lblPesquisarPorRobo.setForeground(SystemColor.controlLtHighlight);
		lblPesquisarPorRobo.setHorizontalAlignment(SwingConstants.CENTER);
        lblPesquisarPorRobo.setForeground(Color.BLACK);
		btnPesquisarPorRobo.add(lblPesquisarPorRobo);

        JButton btnVerAtualizacoes = new JButton();
        btnVerAtualizacoes.setBounds(150,400,160,50);
        btnVerAtualizacoes.setLayout(null);
		btnVerAtualizacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel.add(btnVerAtualizacoes);
        btnVerAtualizacoes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //verTodasAtualizacoesView v = new verTodasAtualizacoesView();
                //v.setVisible(true)
            }
        });

        
        JLabel lblVerAtualizacoes = new JLabel("Ver Atualizaçoes de um Robo");
        lblVerAtualizacoes.setBounds(0, 0, 160, 50);
		lblVerAtualizacoes.setForeground(SystemColor.controlLtHighlight);
		lblVerAtualizacoes.setHorizontalAlignment(SwingConstants.CENTER);
        lblVerAtualizacoes.setForeground(Color.BLACK);
		btnVerAtualizacoes.add(lblVerAtualizacoes);
    }


}
