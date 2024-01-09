package buscadorWoW.Interfaces;

import javax.swing.JFrame;
import buscadorWoW.backend.Fachada;

public class InterfaceFabrica {
    public static JFrame getInterface(Fachada fachada) {
        return new Interface(fachada);
    }

    public static JFrame getInterface() throws Exception {
        return getInterface(Fachada.getInstancia());
    }

    public static JFrame getConfigInterface(Fachada fachada) {
        return new ConfigInterface(fachada);
    }

    public static JFrame getConfigInterface() throws Exception {
        return getConfigInterface(Fachada.getInstancia());
    }
}
