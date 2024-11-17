package buscadorWoW.backend.servico;

import java.util.regex.*;
import java.util.*;

public class Filtro {
    public static List<String> filtrarTermos(String filtro, List<String> termos) {
        if (filtro.isBlank()) 
            return termos;
        
        Pattern ptr = Pattern.compile(filtro.replace('*', '.'), Pattern.CASE_INSENSITIVE);
        ArrayList<String> filtrados = new ArrayList<>();
        
        for (String palavra: termos) {
            if (palavra.length() == filtro.length() && ptr.matcher(palavra).find()) {
                filtrados.add(palavra);
            }
        }
        
        return filtrados;
    }
}
