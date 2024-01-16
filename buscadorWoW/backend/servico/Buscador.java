package buscadorWoW.backend.servico;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.IOException;
import java.io.CharConversionException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Buscador {
    private HashMap<Integer, ArrayList<String>> dicionario;
    private File arquivoDicionario;

    Buscador(String arquivoDicionario) throws IOException {
        setArquivoDicionario(arquivoDicionario);
    }

    private static int stringHash(String str) {
        str = str.toLowerCase().strip();
        int h = 0, c;

        for (char char_: str.toCharArray()){
            c = (int) char_;
            if (c > 96 && c < 123)
                h |= 1 << c-97;
        }

        return h;
    }

    private static boolean isCorrespondente(String termo, String padrao) {
        termo = termo.toLowerCase().strip();
        padrao = padrao.toLowerCase().strip();
        byte contaTermo[] = new byte[26], contaPadrao[] = new byte[26];

        for (char c: termo.toCharArray())
            contaTermo[c-97]++;

        for (char c: padrao.toCharArray())
            contaPadrao[c-97]++;

        for (byte i=0; i<26; i++)
            if (contaTermo[i] > contaPadrao[i])
                return false;

        return true;
    }

    public ArrayList<String> buscarPalavras(String caracteres) throws CharConversionException {
        int hash = stringHash(caracteres);
        ArrayList<ArrayList<String>> listasPalavras = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();

        for(int chave: dicionario.keySet()) {
            if ((chave&hash) == chave){
                listasPalavras.add(dicionario.get(chave));
            }
        }

        for(ArrayList<String> listaPalavras: listasPalavras)
            for(String p: listaPalavras)
                if (isCorrespondente(p, caracteres) && p.length() > 2)
                    resultado.add(p);
        
        resultado.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() != b.length())
                    return Integer.compare(a.length(), b.length());
                else
                    return a.toLowerCase().compareTo(b.toLowerCase());
            }
        });
        
        return resultado;
    }

    public void setArquivoDicionario(String arquivoDicionario) throws IOException {
        this.arquivoDicionario = new File("dicionarios/"+arquivoDicionario);
        this.dicionario = new HashMap<>();
        LineNumberReader dicReader = new LineNumberReader(new FileReader(this.arquivoDicionario));

        for(String palavra=dicReader.readLine(); palavra != null; palavra=dicReader.readLine()) {
            int hash = stringHash(palavra);

            if (dicionario.get(hash) == null)
                dicionario.put(hash, new ArrayList<>());

            dicionario.get(hash).add(palavra);
        }

        dicReader.close();
    }
}
