import com.google.gson.reflect.TypeToken;
import dao.JsonRepository;
import enums.TipoUsuario;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.lang.reflect.Type;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        JsonRepository jsonUsuarioRepository = new JsonRepository<ArrayList<Usuario>>("usuario.json");
        JsonRepository jsonRevistaRepository = new JsonRepository<ArrayList<Revista>>("Revista.json");
        JsonRepository jsonLivroRepository = new JsonRepository<ArrayList<Livro>>("Livro.json");
        JsonRepository jsonArtigoRepository = new JsonRepository<ArrayList<Artigo>>("Artigo.json");
        UUID uuidObra = UUID.randomUUID();

        ArrayList<Obra> listaLivro = new ArrayList<Obra>();
        ArrayList<Obra> listaArtigo = new ArrayList<Obra>();
        ArrayList<Obra> listaRevista = new ArrayList<Obra>();
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();


        Type tipoListaUsuarios = new TypeToken<ArrayList<Usuario>>() {}.getType();
        Type tipoListaLivro = new TypeToken<ArrayList<Livro>>() {}.getType();
        Type tipoListaArtigo = new TypeToken<ArrayList<Artigo>>() {}.getType();
        Type tipoListaRevista = new TypeToken<ArrayList<Revista>>() {}.getType();


        listaUsuario = jsonUsuarioRepository.carregar(tipoListaUsuarios);
        listaLivro = jsonLivroRepository.carregar(tipoListaLivro);
        listaArtigo = jsonArtigoRepository.carregar(tipoListaArtigo);
        listaRevista = jsonRevistaRepository.carregar(tipoListaRevista);
        long idObra = uuidObra.getMostSignificantBits();

        int op = 0;
        do {
            System.out.println("Bem vindo a biblioteca!\nPor favor, digite o numero correspondente a ação.\n1-Adicionar usuario" +
                    "2-Adicionar Livro.\n3-Adicionar Artigo.\n4-Adicionar Revista. \n5-Listar Obras.\n6-Listar usuarios.\n0-Sair.");
            op = scanner.nextInt();
            scanner.nextLine();
            if (op ==1 ){
                System.out.println("Digite o tipo de usuario.\n 1 para Professor\n 2 para aluno\n 3 para servidor");
                int tipo = scanner.nextInt();
                scanner.nextLine();
                if (tipo == 1){
                    System.out.println("Digite o nome do usuario: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite o E-mail: ");
                    String email = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, matricula, telefone, email, TipoUsuario.PROFESSOR);
                    listaUsuario.add(usuario);
                    jsonUsuarioRepository.salvar(listaUsuario);
                }
                if (tipo == 2){
                    System.out.println("Digite o nome do usuario: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite o E-mail: ");
                    String email = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, matricula, telefone, email, TipoUsuario.ALUNO);
                    listaUsuario.add(usuario);
                    jsonUsuarioRepository.salvar(listaUsuario);
                }
                if (tipo == 3){
                    System.out.println("Digite o nome do usuario: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Digite o E-mail: ");
                    String email = scanner.nextLine();
                    Usuario usuario = new Usuario(nome, matricula, telefone, email, TipoUsuario.SERVIDOR);
                    listaUsuario.add(usuario);
                    jsonUsuarioRepository.salvar(listaUsuario);
                }
            }
            if (op == 2){
                System.out.println("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o autor: ");
                String autor = scanner.nextLine();
                System.out.println("Digite o ano de lançamento:  ");
                short ano = scanner.nextShort();
                Livro livro = new Livro(idObra, nome, autor, ano);
                listaLivro.add(livro);
                jsonLivroRepository.salvar(listaLivro);

            }
            if (op == 3){
                System.out.println("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o autor: ");
                String autor = scanner.nextLine();
                System.out.println("Digite o ano de lançamento:  ");
                short ano = scanner.nextShort();
                Artigo artigo= new Artigo(idObra, nome, autor, ano);
                listaArtigo.add(artigo);
                jsonArtigoRepository.salvar(listaArtigo);
            }
            if (op == 4){
                System.out.println("Digite o nome: ");
                String nome = scanner.nextLine();
                System.out.println("Digite o autor: ");
                String autor = scanner.nextLine();
                System.out.println("Digite o ano de lançamento:  ");
                short ano = scanner.nextShort();
                Revista revista = new Revista(idObra, nome, autor, ano);
                listaRevista.add(revista);
                jsonRevistaRepository.salvar(listaRevista);
            }
        }while(op !=0);


    }
    }