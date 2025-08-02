package model;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.UUID;

import com.google.gson.reflect.TypeToken;

import dao.JsonRepository;

public class Emprestimo {
	private Obra obra;
    private String matriculaUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private String idPagamentoMulta;
    private double multa;
    
    public Emprestimo(Obra obra, String matriculaUsuario, LocalDate dataEmprestimo) {
    	try {
			this.obra.emprestar();
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.obra = obra;
        this.matriculaUsuario = matriculaUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(verificarInstancia(obra));
        this.multa = 0.0;
    }
    
    public void registrarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        this.obra.devolver();
        calcularMulta();
    }

    
    public void calcularMulta() {
        if ( !(dataDevolucao.isBefore(dataPrevistaDevolucao) || dataDevolucao.isEqual(dataPrevistaDevolucao)) ) {
        	long diasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataDevolucao);
            this.multa = diasAtraso * 2.0;
            UUID uuid = UUID.randomUUID();
            String idPagamento = uuid.toString();
            this.idPagamentoMulta = idPagamento;
            
     		JsonRepository jsonPagamentoMultaRepository = new JsonRepository<ArrayList<PagamentoMulta>>("pagamentoMulta.json");
    		ArrayList<PagamentoMulta> listaPagamentoMulta = new ArrayList<PagamentoMulta>();
     		Type tipoListaPagamentoMulta = new TypeToken<ArrayList<PagamentoMulta>>() {}.getType();
     		listaPagamentoMulta = jsonPagamentoMultaRepository.carregar(tipoListaPagamentoMulta);
     		jsonPagamentoMultaRepository.salvar(listaPagamentoMulta);
        }
    }

    
    
    private short verificarInstancia(Obra obra) {
    	if(obra instanceof Livro) {
    		Livro livro = (Livro) obra;
    		return livro.getTempoEmprestimo();
    	}
    	else if(obra instanceof Revista) {
    		Revista revista = (Revista) obra;
    		return revista.getTempoEmprestimo();
    	}
    	else {
    		Artigo artigo = (Artigo) obra;
    		return artigo.getTempoEmprestimo();
    	}
    }

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

	public String getMatriculaUsuario() {
		return matriculaUsuario;
	}

	public void setMatriculaUsuario(String matriculaUsuario) {
		this.matriculaUsuario = matriculaUsuario;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getIdPagamentoMulta() {
		return idPagamentoMulta;
	}

	public void setIdPagamentoMulta(String idPagamentoMulta) {
		this.idPagamentoMulta = idPagamentoMulta;
	}

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}
}