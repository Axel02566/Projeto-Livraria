public class Livro extends ItemBiblioteca {
    public Livro(String id, String titulo, String autor) {
        super(id, titulo, autor);
    }

    @Override
    public int getPrazoDias() {
        return 7;
    }
}