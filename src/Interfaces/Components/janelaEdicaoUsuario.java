package Interfaces.Components;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import DAO.UsuarioDAO;
import DAO.Dados.UserDados;
import Conexao.GetData;
import java.util.ArrayList;
public class janelaEdicaoUsuario extends WindowAdapter{
    private int telaHeight = 450, telaWidth = 600, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 10;
    JFrame tela = new JFrame();
    public janelaEdicaoUsuario(Integer id){

        JLabel titulo = new JLabel("Edicíon");
        titulo.setFont(new Font("Arial", Font.BOLD, textoHeight));
        titulo.setBounds(telaWidth - 3*textoWidth/2, textoHeight+paddinTop, textoWidth, textoHeight);
        titulo.setHorizontalAlignment(JTextField.CENTER);

        JLabel nome = new JLabel("ESCREBIR EL NOMBRE");
        nome.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*1+paddinTop, textoWidth, textoHeight);
        JTextField nomeInput = new JTextField();
        nomeInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*2+paddinTop, textoWidth, textoHeight);

        JLabel senha = new JLabel("ESCRIBIR LA CLAVE");
        senha.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*3+paddinTop, textoWidth, textoHeight);
        JTextField senhaInput = new JTextField();
        senhaInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight);

        JLabel email = new JLabel("ESCRIBIR EL EMAIL");
        email.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*5+paddinTop, textoWidth, textoHeight);
        JTextField emailInput = new JTextField();
        emailInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*6+paddinTop, textoWidth, textoHeight);

        JLabel idEnt = new JLabel("ESCRIBIR EL COD ENT.");
        idEnt.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*7+paddinTop, textoWidth, textoHeight);
        JTextField idEntInput = new JTextField();
        idEntInput.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);

        JButton editar = new Butao("PARA EDITAR USUÁRIO");
        editar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*9+paddinTop, textoWidth, textoHeight);
        editar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String valores[] = {nomeInput.getText(), senhaInput.getText(), emailInput.getText(), idEntInput.getText()};
                
                ArrayList<UserDados> usuarios = GetData.getUsers();
                UserDados dados = null;

                for(int c = 0; c < usuarios.size(); c++){
                    if (usuarios.get(c).getID() == id){
                        dados = usuarios.get(c);
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
                                col = dados.getSenha();
                                break;
                            case 2:
                                col = dados.getEmail();
                                break;
                            case 3:
                                col = dados.getIdEnt().toString();
                                break;
                        }
                        valores[c] = col;  
                    }
                }
                try{
                    new UsuarioDAO(""+valores[0].toString(), 4, id, valores[1].toString(), valores[2].toString(), Integer.parseInt(valores[3].toString()));
                }catch(Exception ex){
                    System.out.println(ex.getCause());
                }
            }
        });

        JButton fechar = new Butao("CERCAR");
        fechar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*10+paddinTop, textoWidth, textoHeight);
        fechar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fecharJanela(null);
            }
        });

        tela.add(titulo);
        tela.add(nome);
        tela.add(nomeInput);
        tela.add(senha);
        tela.add(senhaInput);
        tela.add(email);
        tela.add(emailInput);
        tela.add(idEnt);
        tela.add(idEntInput);
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
