package Interfaces.Components;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

import DAO.AreaDAO;

public class janelaEdicaoArea extends WindowAdapter{
    private int telaHeight = 300, telaWidth = 600, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 10;
    JFrame tela = new JFrame();
    public janelaEdicaoArea(Integer id){

        JLabel titulo = new JLabel("Edição");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel nome = new JLabel("ESCREVA O NOME NOVO");
        nome.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField nomeInput = new JTextField();
        nomeInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JButton editar = new Butao("EDITAR ÁREA");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AreaDAO(nomeInput.getText(), 4, id);
            }
        });

        JButton fechar = new Butao("FECHAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(nome);
        tela.add(nomeInput);
        tela.add(editar);
        tela.add(fechar);

        tela.setSize(telaWidth, telaHeight);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void fecharJanela(WindowEvent e){
        tela.dispose();
    }
}
