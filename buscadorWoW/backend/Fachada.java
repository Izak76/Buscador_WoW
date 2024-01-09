package buscadorWoW.backend;

import java.io.CharConversionException;
import java.util.List;

import buscadorWoW.backend.servico.Buscador;
import buscadorWoW.backend.servico.Configuracoes;

public class Fachada {
    private static Fachada instancia;
    private Buscador buscador;
    private Configuracoes configs;

    private Fachada() {
        try{
            this.configs = Configuracoes.getInstancia();
            this.buscador = this.configs.getBuscador();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
    
    public static Fachada getInstancia() {
        if (instancia == null)
            instancia = new Fachada();
        
        return instancia;
    }

    public List<String> buscarTermos(String entrada) throws CharConversionException {
        return buscador.buscarPalavras(entrada);
    }

    public void setArquivoDicionario(String arquivoDicionario) {
        try{
            if (arquivoDicionario != configs.getArquivoDicionario()){
                configs.setArquivoDicionario(arquivoDicionario);
                buscador.setArquivoDicionario(arquivoDicionario);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public String[] getDicionariosDisponiveis() {
        return configs.getDicionarios();
    }

    public String getDicionarioAtual() {
        return configs.getArquivoDicionario();
    }
}
