import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import enums.TipoUsuario;
import model.Livro;
import model.Obra;
import model.Usuario;
import com.google.gson.reflect.TypeToken;

import dao.JsonRepository;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		JsonRepository jsonUsuarioRepository = new JsonRepository<ArrayList<Usuario>>("usuario.json");
		JsonRepository jsonObraRepository = new JsonRepository<ArrayList<Obra>>("obra.json");
        UUID uuidObra = UUID.randomUUID();

        ArrayList<Obra> listaObra = new ArrayList<Obra>();
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		
		Type tipoListaUsuarios = new TypeToken<ArrayList<Usuario>>() {}.getType();
		Type tipoListaObra = new TypeToken<ArrayList<Obra>>() {}.getType();

		
		listaUsuario = jsonUsuarioRepository.carregar(tipoListaUsuarios);
		listaObra = jsonObraRepository.carregar(tipoListaObra);
		
		while(true) {
			System.out.println("Bem vindo a biblioteca!");
			Usuario usuario = new Usuario("Quarto usuario", "123456", "8799201929", "jose@teste.com", TipoUsuario.ALUNO);
			listaUsuario.add(usuario);
			jsonUsuarioRepository.salvar(listaUsuario);
			
			long idObra = uuidObra.getMostSignificantBits();
			Obra livro = new Livro(idObra, "As cabras", "Jose", (short) 2028);
			listaObra.add(livro);
			jsonObraRepository.salvar(listaObra);
			break;
		}
		
		
	}
}
