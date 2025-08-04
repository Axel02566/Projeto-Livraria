package model;
import enums.StatusObra;
public abstract class Obra {private long codigo;
    private String titulo;
    private String autor;
    private short anoPublicacao;
    private StatusObra status;

    public Obra(long codigo, String titulo, String autor, short anoPublicacao, StatusObra status) {
        super();
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }

    public long getCodigo() {
        return codigo;
    }
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public short getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(short anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public StatusObra getStatus() {
        return status;
    }
    public void setStatus(StatusObra status) {
        this.status = status;
    }

    public abstract short getTempoEmprestimo();

    public void emprestar() throws Exception{
        if (this.status == StatusObra.EMPRESTADO){
            throw new Exception("Obra já está emprestada.");
        }
        this.status = StatusObra.EMPRESTADO;
    }

    public void devolver() {
        this.status = StatusObra.DISPONIVEL;
    }

}
