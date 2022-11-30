package Interfaces;

import Interfaces.Components.Butao;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;

public class Selecao extends WindowAdapter{
    int telaHeight = 400, telaWidth = 600, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 55;
    JFrame tela = new JFrame();

    public Selecao(){
        
        JLabel titulo = new JLabel("BEM-VINDO");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JButton usuario = new Butao("USUÁRIO");
        usuario.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);
        usuario.addActionListener(new  ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Usuario();
            }
        });
    
        JButton entrevistador = new Butao("ENTREVISTADOR");
        entrevistador.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        entrevistador.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                new Entrevistador();
            }
        });

        JButton area = new Butao("ÁREA");
        area.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);
        area.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Area();
            }
        });
    
        JButton fechar = new Butao("CERCAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*5+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.addWindowListener(this);
        
        tela.add(titulo);
        tela.add(usuario);
        tela.add(entrevistador);
        tela.add(area);
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
