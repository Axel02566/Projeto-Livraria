import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        // cadastro inicial de livros
        biblioteca.adicionarLivro(new Livro("1", "1984", "George Orwell"));
        biblioteca.adicionarLivro(new Livro("2", "Dom Casmurro", "Machado de Assis"));

        // cadastro inicial de usuários
        biblioteca.adicionarUsuario(new Usuario("u1", "Gustavo"));
        biblioteca.adicionarUsuario(new Usuario("u2", "Mariana"));

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Listar empréstimos de usuário");
            System.out.println("5. Listar livros disponíveis");
            System.out.println("6. Listar livros emprestados");
            System.out.println("7. Ver multas de usuário");
            System.out.println("8. Pagar multas de usuário");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            String opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    biblioteca.listarTodosLivros();
                    break;
                case "2":
                    System.out.print("ID do usuário: ");
                    String idUsr = sc.nextLine();
                    System.out.print("ID do livro: ");
                    String idLivro = sc.nextLine();
                    if (biblioteca.emprestarItem(idUsr, idLivro)) {
                        System.out.println("Empréstimo realizado com sucesso.");
                    } else {
                        System.out.println("Falha no empréstimo. Verifique IDs e disponibilidade.");
                    }
                    break;
                case "3":
                    System.out.print("ID do usuário: ");
                    idUsr = sc.nextLine();
                    System.out.print("ID do livro: ");
                    idLivro = sc.nextLine();
                    if (biblioteca.devolverItem(idUsr, idLivro)) {
                        System.out.println("Devolução realizada com sucesso.");
                    } else {
                        System.out.println("Falha na devolução. Verifique IDs e estado do item.");
                    }
                    break;
                case "4":
                    System.out.print("ID do usuário: ");
                    idUsr = sc.nextLine();
                    biblioteca.listarEmprestimosUsuario(idUsr);
                    break;
                case "5":
                    System.out.println("=== Livros disponíveis ===");
                    biblioteca.listarDisponiveis()
                              .forEach(System.out::println);
                    break;
                case "6":
                    System.out.println("=== Livros emprestados ===");
                    biblioteca.listarEmprestados()
                              .forEach(System.out::println);
                    break;
                case "7":
                    System.out.print("ID do usuário: ");
                    idUsr = sc.nextLine();
                    Usuario usr = biblioteca.buscarUsuario(idUsr);
                    if (usr != null) {
                        usr.mostrarMultas();
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case "8":
                    System.out.print("ID do usuário: ");
                    idUsr = sc.nextLine();
                    usr = biblioteca.buscarUsuario(idUsr);
                    if (usr != null) {
                        usr.pagarMultas();
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case "0":
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
        System.out.println("Encerrando sistema. Até logo!");
    }
}