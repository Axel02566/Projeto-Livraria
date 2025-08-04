
public abstract class ItemBiblioteca {
    protected String id;
    protected String titulo;
    protected String autor;
    protected boolean disponivel;

    public ItemBiblioteca(String id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean status) { this.disponivel = status; }

    public abstract int getPrazoDias(); // prazo de devolução por tipo

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s)", id, titulo, autor, getClass().getSimpleName());
    }

    public void adicionarLivro(Livro livro) {
        adicionarItem(livro);
    }

    public void listarTodosLivros() {
    System.out.println("=== Todos os itens cadastrados ===");
    for (ItemBiblioteca item : itens) {
        System.out.println(item);
        }
    }
    public void listarEmprestimosUsuario(String idUsuario) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario != null) {
        usuario.listarEmprestimos();
        } else {
        System.out.println("Usuário não encontrado.");
        }
    }


}