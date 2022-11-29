package Interfaces;

import DAO.AreaDAO;
import Interfaces.Components.Butao;
import Interfaces.Components.janelaEdicaoArea;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.*;

public class Area extends WindowAdapter{
    private int telaHeight = 500, telaWidth = 800, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 55;
    private ArrayList<String[]> linhas = new ArrayList<>();
    JFrame tela = new JFrame();

    public Area(){
        
        JLabel titulo = new JLabel("CRUD: área");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel pergunta = new JLabel("ESCREVA UMA NOVA ÁREA ABAIXO:");
        pergunta.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField perguntaInput = new JTextField();
        perguntaInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JButton inserir = new Butao("INSERIR ÁREA");
        inserir.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        inserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new AreaDAO(perguntaInput.getText(), 1, null);
            } 
        });

        //tabela
        AreaDAO dao = new AreaDAO(null, 2, null);
        
        for (int i = 0; i < dao.getAreas().size(); i++){
            String linha[] = {""+dao.getAreas().get(i).getID()+"", dao.getAreas().get(i).getNome()};
            linhas.add(linha);
        }

        //conversão de ArrayList para Array
        String[][] lin = new String[linhas.size()][2];
        for (int i = 0; i < linhas.size(); i++){
            lin[i] = linhas.get(i);
        }

        String[] colNomes = {"ID", "Nome"};
        JTable tabela = new JTable(lin, colNomes);
        
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight*5);
        
        JButton deletar = new Butao("DELETAR ÁREA");
        deletar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);
        deletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    System.out.println(rows.length);
                    String id = tabela.getValueAt(rows[c], 0).toString();
                    new AreaDAO(null, 3, Integer.parseInt(id));
                }
            }
        });
        
        JButton editar = new Butao("EDITAR ÁREA");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*9+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    System.out.println(rows.length);
                    String id = tabela.getValueAt(rows[c], 0).toString();
                   
                    new janelaEdicaoArea(Integer.parseInt(id));
                }
            }
        });

        JButton fechar = new Butao("FECHAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*10+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(pergunta);
        tela.add(perguntaInput);
        tela.add(inserir);
        tela.add(sp);
        tela.add(deletar);
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
