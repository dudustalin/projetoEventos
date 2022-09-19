
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ev{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Integer id_evento = 0;
	private String nome_evento = null;
	private String data_evento = null;
	private String cidade_evento = null;
	private String bairro_evento = null;
	private Integer categoria = null;
	List<Integer> listaParticipantes = new ArrayList<Integer>();
	List<String> categEvento = new ArrayList<String>();
	public Calendar eDate = Calendar.getInstance();
	

	
	public void create_id(Integer id) {
		this.id_evento = id;
		
	}
	
	public void create_nome(String nome_evento) {
		this.nome_evento = nome_evento;
	}
	
	public void create_data(String data_evento) throws ParseException {
		this.data_evento = data_evento;
		eDate.setTime(sdf.parse(data_evento));
	}
	
	public void create_cidade(String cidade_evento) {
		this.cidade_evento = cidade_evento;
	}
	
	public void add_categoria(Integer cat) {
		this.categoria = cat;
	}
	
	public void create_bairro(String bairro_evento) {
		this.bairro_evento = bairro_evento;
	}
	
	public void associateToPartic(Integer id_partic) {
		this.listaParticipantes.add(id_partic);
	}
	
	public Integer get_id() {
		return id_evento;
	}
	
	public Integer get_categoria() {
		return categoria;
	}
	
	public String getNome() {
		return nome_evento;
	}
	
	public String getData() {
		return data_evento;
	}
	
	public String getCidadde() {
		return cidade_evento;
	}
	
	public String getBairro() {
		return bairro_evento;
	}
	
	public void createListcategory() {
		this.categEvento.add("Trabalho");
		this.categEvento.add("Estudo");
		this.categEvento.add("Esportes");
		this.categEvento.add("Lazer");
		this.categEvento.add("Compromissos");
		this.categEvento.add("Social");
	}
	
	public void popuList() {
		createListcategory();
	}
	
//	MÉTODO PARA CALCULAR TEMPO
	
	public String timedeltaD() {
		Long ms = System.currentTimeMillis();
		ms = this.eDate.getTimeInMillis() - ms;
		
		ms = (ms / (24 * 60 * 60 * 1000));
		
		if (ms<0) {
			return "Ocorreu há " + ms +" dias";
		} else if (ms <1) {
			return "Ocorre hoje!";
		} else {
			return "Ocorre em " + ms + " dias";
		}
		
	}

	
	}
	
	
