package model;

import enums.StatusObra;

public class Livro extends Obra{

    public Livro(long codigo, String titulo, String autor, short anoPublicacao) throws Exception {
        super(codigo, titulo, autor, anoPublicacao, StatusObra.DISPONIVEL);
    }

    @Override
    public short getTempoEmprestimo() {
        return 7;
    }
}
