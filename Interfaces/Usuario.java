package Interfaces;

import DAO.UsuarioDAO;
import Interfaces.Components.Butao;
import Interfaces.Components.janelaEdicaoUsuario;

import javax.swing.*;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.*;

public class Usuario {
    
    private int telaHeight = 700, telaWidth = 800, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 55;
    private ArrayList<String[]> linhas = new ArrayList<>();
    JFrame tela = new JFrame();

    public Usuario(){
        
        JLabel titulo = new JLabel("CRUD: usuário");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel nomeLabel = new JLabel("ESCREVA EL NOMBRE DE USUÁRIO:");
        nomeLabel.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField nomeInput = new JTextField();
        nomeInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JLabel senhaLabel = new JLabel("ESCREVA LA CONTRASENA:");
        senhaLabel.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        JTextField senhaInput = new JTextField();
        senhaInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);

        JLabel email = new JLabel("EMAIL:");
        email.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*5+paddinTop, textoWidth, textoHeight);
        JTextField emailInput = new JTextField();
        emailInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*6+paddinTop, textoWidth, textoHeight);

        JLabel idEnt = new JLabel("EL CÓDIGO DE ENTREVISTADOR:");
        idEnt.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*7+paddinTop, textoWidth, textoHeight);
        JTextField idEntInput = new JTextField();
        idEntInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);

        JButton inserir = new Butao("INSERIR USUÁRIO");
        inserir.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*9+paddinTop, textoWidth, textoHeight);
        inserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UsuarioDAO(nomeInput.getText(), 1, null, senhaInput.getText(), emailInput.getText(), Integer.parseInt(idEntInput.getText()));
            } 
        });

        //tabela
        UsuarioDAO dao = new UsuarioDAO(null, 2, null, null, null, null);
        
        for (int i = 0; i < dao.getUsers().size(); i++){
            String linha[] = {""+dao.getUsers().get(i).getID()+"", dao.getUsers().get(i).getNome(), ""+dao.getUsers().get(i).getEmail(), ""+dao.getUsers().get(i).getSenha(), ""+dao.getUsers().get(i).getIdEnt()};
            linhas.add(linha);
        }

        //conversão de ArrayList para Array
        String[][] lin = new String[linhas.size()][5];
        for (int i = 0; i < linhas.size(); i++){
            lin[i] = linhas.get(i);
        }

        String[] colNomes = {"ID", "Nombre", "Email", "Sena", "COD ENT."};
        JTable tabela = new JTable(lin, colNomes);
        
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*10+paddinTop, textoWidth, textoHeight*6);
        
        JButton deletar = new Butao("DELETAR ÁREA");
        deletar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*15+paddinTop, textoWidth, textoHeight);
        deletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    System.out.println(rows.length);
                    String id = tabela.getValueAt(rows[c], 0).toString();
                    new UsuarioDAO(null, 3, Integer.parseInt(id), null, null, null);
                }
            }
        });
        
        JButton editar = new Butao("EDITAR ÁREA");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*16+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    
                    String id = tabela.getValueAt(rows[c], 0).toString();
                    new janelaEdicaoUsuario(Integer.parseInt(id));
                }
            }
        });

        JButton fechar = new Butao("FECHAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*17+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(nomeLabel);
        tela.add(nomeInput);
        tela.add(senhaLabel);
        tela.add(senhaInput);
        tela.add(email);
        tela.add(emailInput);
        tela.add(idEnt);
        tela.add(idEntInput);
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