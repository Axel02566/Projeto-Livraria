package dao;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public class JsonRepository<T> {
    private final Gson gson;
    private final String caminhoArquivo;

    public JsonRepository(String caminhoArquivo) {
        this.gson = new Gson();
        this.caminhoArquivo = caminhoArquivo;
    }

    /**
     * Salva um objeto em um arquivo JSON.
     * @param objeto O objeto a ser persistido.
     */
    public void salvar(T objeto) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            gson.toJson(objeto, writer);
            System.out.println("Objeto salvo com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o objeto: " + e.getMessage());
        }
    }

    public ArrayList<T> carregar(Type tipoLista) {
        try (FileReader reader = new FileReader(caminhoArquivo)) {
            ArrayList<T> lista = gson.fromJson(reader, tipoLista);
            System.out.println("Lista carregada com sucesso de: " + caminhoArquivo);
            return lista;
        } catch (IOException e) {
            System.err.println("Erro ao carregar a lista: " + e.getMessage());
            return new ArrayList<T>();
        }
    }

}
