import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<ItemBiblioteca> itens = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public ItemBiblioteca buscarItem(String idItem) {
        for (ItemBiblioteca item : itens) {
            if (item.getId().equals(idItem)) {
                return item;
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(idUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean emprestarItem(String idUsuario, String idItem) {
        Usuario usuario = buscarUsuario(idUsuario);
        ItemBiblioteca item = buscarItem(idItem);
        if (usuario != null && item != null && item.isDisponivel()) {
            item.setDisponivel(false);
            usuario.adicionarEmprestimo(new Emprestimo(item));
            return true;
        }
        return false;
    }

    public boolean devolverItem(String idUsuario, String idItem) {
        Usuario usuario = buscarUsuario(idUsuario);
        ItemBiblioteca item = buscarItem(idItem);
        if (usuario != null && item != null && !item.isDisponivel()) {
            usuario.devolverItem(idItem);
            return true;
        }
        return false;
    }

    public List<ItemBiblioteca> listarDisponiveis() {
        List<ItemBiblioteca> disponiveis = new ArrayList<>();
        for (ItemBiblioteca item : itens) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }

    public List<ItemBiblioteca> listarEmprestados() {
        List<ItemBiblioteca> emprestados = new ArrayList<>();
        for (ItemBiblioteca item : itens) {
            if (!item.isDisponivel()) {
                emprestados.add(item);
            }
        }
        return emprestados;
    }
}