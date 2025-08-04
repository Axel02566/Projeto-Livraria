
public class Artigo extends ItemBiblioteca {
    public Artigo(String id, String titulo, String autor) {
        super(id, titulo, autor);
    }

    @Override
    public int getPrazoDias() {
        return 3;
    }
}