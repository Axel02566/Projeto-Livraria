package model;

import enums.StatusObra;

public class Artigo extends Obra{

    public Artigo(long codigo, String titulo, String autor, short anoPublicacao) {
        super(codigo, titulo, autor, anoPublicacao, StatusObra.DISPONIVEL);
    }

    @Override
    public short getTempoEmprestimo() {
        return 2;
    }
}
