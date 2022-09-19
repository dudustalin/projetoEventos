
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class pessoa {


	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer id = 0;
	private String nome = null;
	private String sobrenome = null;
	private String dataNasc = null;
	private String cidade = null;
	private Float genero = null;
	List<Integer> listaEventos = new ArrayList<Integer>();
	private  Calendar pDate = Calendar.getInstance();
//	private  Calendar inter = Calendar.getInstance();
	
//	MÉTODOS PARA POPULAR ATRIBUTOS
	
//	POPULA DATA DE NASCIMENTO
	
//	POPULA ID
	
	public void create_id(Integer id_pessoa) {
		this.id = id_pessoa;
		
	}
	
//	POPULA NOME
	
	public void create_nome(String nome) {
		this.nome = nome;
	}
	
//	POPULA CIDADE
	
	public void create_cidade(String cidade) {
		this.cidade = cidade;
	}
	
//	POPULA SOBRENOME
	
	public void create_sobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
//	POPULA DATA DE NASCIMENTO
	
	public void create_dataNasc(String nasc) throws ParseException {
		pDate.setTime(sdf.parse(nasc));
		this.dataNasc = nasc;
	}
	
//	POPULA GÊNERO
	
	public void create_genero(Float genero) {
		this.genero = genero;
	}
	
//	MÉTODO PARA ADICIONAR PESSOA A UM EVENTO
//	
	
	public void associateToEv(Integer id_ev) {
		this.listaEventos.add(id_ev);
	}
	
	
// 	MÉTODOS PARA RECUPERAR INFORMAÇÕES
//
	

	
//	RECUPERA NOME
	
	public String getNome() {
		return nome;
	}
	
//	RECUPERA SOBRENOME
	
	public String getSobrenome() {
		return sobrenome;
	}
	
//	RECUPERA CIDADE
	
	public String getCidade() {
		return cidade;
	}
	
//	RECUPERA GÊNERO
	
	public Float getGenero() {
		return genero;
	}
	
//	RECUPERA DATA DE NASCIMENTO
	
	public String getNasc() {
		return dataNasc;
	}
	
//	RECUPERA ID
	
	public Integer get_id() {
		return id;
	}
	
//	MÉTODO PARA CALCULAR TEMPO
	
	public String timeDeltaY() {
		Long ms = System.currentTimeMillis();
		ms = ms - pDate.getTimeInMillis();
		long k = 31556952000l;
		ms = (ms / k);
			
		if (ms<0) {
			return "(Ainda não nasceu!!!";
		} else if (ms <1) {
			return "Recém nascido";
		} else {
			return "(" + ms + " anos)";
		}
		
	}

	
	}
	
