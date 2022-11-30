package Interfaces.Components;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import DAO.EntrevistadorDAO;
import DAO.Dados.EntrevistadorDados;
import Conexao.GetData;
import java.util.ArrayList;

public class janelaEdicaoEntrevistador {
    private int telaHeight = 500, telaWidth = 600, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 10;
    JFrame tela = new JFrame();
    public janelaEdicaoEntrevistador(Integer id){

        JLabel titulo = new JLabel("Edicíon");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel nome = new JLabel("ESCRIBIR EL NOMBRE");
        nome.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField nomeInput = new JTextField();
        nomeInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JLabel cpf = new JLabel("ESCREBIR EL CPF");
        cpf.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        JTextField cpfInput = new JTextField();
        cpfInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);

        JLabel rg = new JLabel("ESCRIBIR EL RG");
        rg.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*5+paddinTop, textoWidth, textoHeight);
        JTextField rgInput = new JTextField();
        rgInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*6+paddinTop, textoWidth, textoHeight);

        JLabel dataNasc = new JLabel("ESCRIBIR LA FECHA DE NASCIMENTO");
        dataNasc.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*7+paddinTop, textoWidth, textoHeight);
        JTextField dataNascInput = new JTextField();
        dataNascInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);

        JLabel matricula = new JLabel("ESCRIBIR LA MATRÍCULA");
        matricula.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*9+paddinTop, textoWidth, textoHeight);
        JTextField matriculaInput = new JTextField();
        matriculaInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*10+paddinTop, textoWidth, textoHeight);

        JButton editar = new Butao("EDITAR USUÁRIO");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*11+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String valores[] = {nomeInput.getText(), cpfInput.getText(), rgInput.getText(), dataNascInput.getText(), matriculaInput.getText()};
                
                ArrayList<EntrevistadorDados> entrevistadores = GetData.getEntrevistadores();
                EntrevistadorDados dados = null;

                for(int c = 0; c < entrevistadores.size(); c++){
                    if (entrevistadores.get(c).getID() == id){
                        dados = entrevistadores.get(c);
                    }
                }

                for(int c = 0; c < valores.length; c++){
                    if(valores[c].isBlank()){
                        String col = null;

                        switch (c){
                            case 0:
                                col = dados.getNome();
                                break;
                            case 1:
                                col = dados.getCPF();
                                break;
                            case 2:
                                col = dados.getRG();
                                break;
                            case 3:
                                col = dados.getDataNasc();
                                break;
                            case 4:
                                col = dados.getMatricula();
                                break;
                        }
                        valores[c] = col;  
                    }
                }
                try{
                    new EntrevistadorDAO(valores[0], 4, valores[1], valores[2], valores[3], valores[4], id);
                }catch(Exception ex){
                    System.out.println(ex.getCause());
                }
            }
        });

        JButton fechar = new Butao("FECHAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*12+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(nome);
        tela.add(nomeInput);
        tela.add(cpf);
        tela.add(cpfInput);
        tela.add(rg);
        tela.add(rgInput);
        tela.add(dataNasc);
        tela.add(dataNascInput);
        tela.add(matricula);
        tela.add(matriculaInput);
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
