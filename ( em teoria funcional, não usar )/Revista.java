
public class Revista extends ItemBiblioteca {
    public Revista(String id, String titulo, String autor) {
        super(id, titulo, autor);
    }

    @Override
    public int getPrazoDias() {
        return 5;
    }
}