package buscadorWoW;

import javax.swing.UIManager;

import buscadorWoW.Interfaces.InterfaceFabrica;


public class App {
    public static void main(String[] args) {
        String[] looks = {"Windows", "Nimbus", "Metal"};

        try {
            outer:
            for (String look: looks){
                for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                    if (look.equals(info.getName())){
                        UIManager.setLookAndFeel(info.getClassName());
                        break outer;
                    }
                }
            }
        } catch (Exception err) {
            // Nada faz...
        }

        InterfaceFabrica.getInterface().setVisible(true);
    }
}
