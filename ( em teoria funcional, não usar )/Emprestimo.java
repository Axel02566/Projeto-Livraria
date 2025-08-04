import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private ItemBiblioteca item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(ItemBiblioteca item) {
        this.item = item;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public boolean estaDevolvido() {
        return dataDevolucao != null;
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDate.now();
        item.setDisponivel(true);
    }

    public long getDiasEmprestados() {
        LocalDate fim = estaDevolvido() ? dataDevolucao : LocalDate.now();
        return ChronoUnit.DAYS.between(dataEmprestimo, fim);
    }

    public boolean estaAtrasado() {
        return getDiasEmprestados() > item.getPrazoDias();
    }

    public double calcularMulta() {
        if (!estaAtrasado()) {
            return 0.0;
        }
        long diasAtraso = getDiasEmprestados() - item.getPrazoDias();
        return 5.0 + (diasAtraso - 1) * 0.25;
    }

    public ItemBiblioteca getItem() {
        return item;
    }

    @Override
    public String toString() {
        String status = estaDevolvido() ? "Devolvido" : "Emprestado";
        String atraso = estaAtrasado() ? " (ATRASADO)" : "";
        return String.format("%s → %s em %s%s", 
                             item.getTitulo(), 
                             status, 
                             dataEmprestimo, 
                             atraso);
    }
}