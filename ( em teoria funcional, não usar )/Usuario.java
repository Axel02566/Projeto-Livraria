import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nome;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void devolverItem(String itemId) {
        for (Emprestimo e : emprestimos) {
            if (e.getItem().getId().equals(itemId) && !e.estaDevolvido()) {
                e.registrarDevolucao();
                break;
            }
        }
    }

    public void listarEmprestimos() {
        System.out.println("Empréstimos de " + nome + ":");
        for (Emprestimo e : emprestimos) {
            System.out.println("  " + e);
        }
    }

    public void mostrarMultas() {
        double total = 0.0;
        System.out.println("Multas de " + nome + ":");
        for (Emprestimo e : emprestimos) {
            if (!e.estaDevolvido() && e.estaAtrasado()) {
                double multa = e.getMulta();
                total += multa;
                System.out.printf("  %s → R$ %.2f%n", e.getItem().getTitulo(), multa);
            }
        }
        System.out.printf("Total de multas: R$ %.2f%n", total);
    }

    public void pagarMultas() {
        for (Emprestimo e : emprestimos) {
            if (!e.estaDevolvido() && e.estaAtrasado()) {
                e.registrarDevolucao();
            }
        }
        System.out.println("Multas pagas e itens devolvidos.");
    }
}