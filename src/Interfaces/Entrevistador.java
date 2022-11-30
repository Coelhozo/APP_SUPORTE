package Interfaces;

import DAO.EntrevistadorDAO;
import Interfaces.Components.Butao;
import Interfaces.Components.janelaEdicaoEntrevistador;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.*;

public class Entrevistador extends WindowAdapter{
    private int telaHeight = 760, telaWidth = 800, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 55;
    private ArrayList<String[]> linhas = new ArrayList<>();
    JFrame tela = new JFrame();

    public Entrevistador(){
        
        JLabel titulo = new JLabel("CRUD: entevistador");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel nomeLabel = new JLabel("ESCREVA EL NOMBRE DE ENTREVISTADOR:");
        nomeLabel.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField nomeInput = new JTextField();
        nomeInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JLabel cpfLabel = new JLabel("ESCREVA O CPF:");
        cpfLabel.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        JTextField cpfInput = new JTextField();
        cpfInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);

        JLabel rg = new JLabel("RG:");
        rg.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*5+paddinTop, textoWidth, textoHeight);
        JTextField rgInput = new JTextField();
        rgInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*6+paddinTop, textoWidth, textoHeight);

        JLabel dataNasc = new JLabel("DATA DE NASCIMENTO:");
        dataNasc.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*7+paddinTop, textoWidth, textoHeight);
        JTextField dataNascInput = new JTextField();
        dataNascInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);

        JLabel matricula = new JLabel("MATRICULA:");
        matricula.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*9+paddinTop, textoWidth, textoHeight);
        JTextField matriculaInput = new JTextField();
        matriculaInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*10+paddinTop, textoWidth, textoHeight);

        JButton inserir = new Butao("INSERIR ENTREVISTADOR");
        inserir.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*11+paddinTop, textoWidth, textoHeight);
        inserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new EntrevistadorDAO(nomeInput.getText(), 1, cpfInput.getText(), rgInput.getText(), dataNascInput.getText(), matriculaInput.getText(), null);
            } 
        });

        //tabela
        EntrevistadorDAO dao = new EntrevistadorDAO(null, 2, null, null, null, null, null);
        
        for (int i = 0; i < dao.getEntrevistadores().size(); i++){
            String linha[] = {""+dao.getEntrevistadores().get(i).getID()+"", dao.getEntrevistadores().get(i).getNome(), ""+dao.getEntrevistadores().get(i).getCPF(), ""+dao.getEntrevistadores().get(i).getRG(), ""+dao.getEntrevistadores().get(i).getDataNasc(), ""+dao.getEntrevistadores().get(i).getMatricula()};
            linhas.add(linha);
        }

        //conversão de ArrayList para Array
        String[][] lin = new String[linhas.size()][6];
        for (int i = 0; i < linhas.size(); i++){
            lin[i] = linhas.get(i);
        }

        String[] colNomes = {"ID", "Nombre", "CPF", "RG", "Data Nascimento", "Matrícula"};
        JTable tabela = new JTable(lin, colNomes);
        
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*12+paddinTop, textoWidth, textoHeight*6);
        
        JButton deletar = new Butao("DELETAR ENTREVISTADOR");
        deletar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*17+paddinTop, textoWidth, textoHeight);
        deletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    String id = tabela.getValueAt(rows[c], 0).toString();
                
                    new EntrevistadorDAO(null, 3, null, null, null, null, Integer.parseInt(id));
                }
            }
        });
        
        JButton editar = new Butao("EDITAR ÁREA");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*18+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    String id = tabela.getValueAt(rows[c], 0).toString();
                    new janelaEdicaoEntrevistador(Integer.parseInt(id));
                }
            }
        });

        JButton fechar = new Butao("FECHAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*19+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(nomeLabel);
        tela.add(nomeInput);
        tela.add(cpfLabel);
        tela.add(cpfInput);
        tela.add(rg);
        tela.add(rgInput);
        tela.add(dataNasc);
        tela.add(dataNascInput);
        tela.add(matricula);
        tela.add(matriculaInput);
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
