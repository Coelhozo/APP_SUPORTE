import Interfaces.*;
//import javax.swing.*;
//import java.awt.event.*;
//import Interfaces.Components.Butao;
public class App {
    
    public static void main(String[] args) {
        new Selecao();
        /*
        int telaHeight = 500, telaWidth = 800, textoHeight = 25, textoWidth = telaWidth/2, gap = 30, paddinTop = 55;

        JFrame tela = new JFrame();
        String[][] lista = {{"1", "2"}, {"3", "4"}, {"5", "6"}};
        String[] cols = {"pedro", "lucas"};

        JTable tabela = new JTable(lista, cols);
        JScrollPane sp = new JScrollPane(tabela);
        sp.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*4+paddinTop, textoWidth, textoHeight*5);

        JButton deletar = new Butao("DELETAR ÁREA");
        deletar.setBounds(telaWidth - 3*textoWidth/2, textoHeight+gap*8+paddinTop, textoWidth, textoHeight);
        deletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int[] rows = tabela.getSelectedRows();
                for(int c = 0; c < rows.length; c++){
                    int row = rows[c];
                    System.out.println(tabela.getValueAt(row, 0));
                }

            } 
        });

        tela.add(sp);
        tela.add(deletar);
        tela.setSize(telaWidth, telaHeight);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        
    }
}
