package model;

import enums.StatusObra;

public class Revista extends Obra{

    public Revista(long codigo, String titulo, String autor, short anoPublicacao) {
        super(codigo, titulo, autor, anoPublicacao, StatusObra.DISPONIVEL);
    }
    @Override
    public short getTempoEmprestimo() {
        return 3;
    }
}
