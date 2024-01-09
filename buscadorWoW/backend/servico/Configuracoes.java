package buscadorWoW.backend.servico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.*;
import org.w3c.dom.*;

public class Configuracoes {
    private final DocumentBuilder XMLBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    private final Transformer XMLTransformer = TransformerFactory.newInstance().newTransformer();
    private static Configuracoes instancia;
    private String arquivoDicionario, dicionarios[];
    private File config;
    
    private Configuracoes() throws Exception {
        config = new File("config.xml");
        dicionarios = new File("dicionarios").list();
        XMLTransformer.setOutputProperty("indent", "yes");
        
        if (config.createNewFile()) {
            if (dicionarios.length == 0)
                throw new Exception("Não há arquivos de dicionario disponíveis.");
            
            this.arquivoDicionario = dicionarios[0];
            salvarXML();
        } else {
            Document doc = XMLBuilder.parse(config);
            arquivoDicionario = ((Element) doc.getElementsByTagName("config").item(0)).getElementsByTagName("dicionario").item(0).getTextContent();
        }
    }
    
    private void salvarXML() throws TransformerException, IOException {
        StringWriter sw = new StringWriter();
        FileWriter fw = new FileWriter(this.config);
        Document doc = XMLBuilder.newDocument();
        Element cfg = doc.createElement("config"),
                dic = doc.createElement("dicionario");

        dic.setTextContent(this.arquivoDicionario);
        cfg.appendChild(dic);
        doc.appendChild(cfg);
        XMLTransformer.transform(new DOMSource(doc), new StreamResult(sw));
        fw.write(sw.toString());
        fw.close();
    }
    
    public static Configuracoes getInstancia() throws Exception {
        if (instancia == null)
            instancia = new Configuracoes();
        
        return instancia;
    }

    public String getArquivoDicionario() {
        return this.arquivoDicionario;
    }
    
    public String[] getDicionarios() {
        return this.dicionarios;
    }

    public Buscador getBuscador() throws IOException{
        return new Buscador(this.arquivoDicionario);
    }

    public void setArquivoDicionario(String arquivo) throws TransformerException, IOException {
        this.arquivoDicionario = arquivo;
        salvarXML();
    }
}
