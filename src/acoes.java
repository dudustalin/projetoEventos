
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Calendar;

public class acoes{
	
	public static Scanner sc = new Scanner(System.in);
	public static List<pessoa> cjPessoas = new ArrayList<pessoa>();
	public static List<ev> cjEventos = new ArrayList<ev>();
	public static Calendar hDate = Calendar.getInstance();
		
	//
	//
	//MÉTODOS DE ESCUTA
	//
	
	//MÉTODO PARA CAPTURAR INTEIROS
	//

	public static Integer askQuestionI(String question){
		Integer s = null;
		System.out.println(question);
		s = Integer.parseInt(sc.nextLine());
		
		return s;
		
	}
	
	//MÉTODO PARA CAPTURAR STRINGS
	//
	
	public static String askQuestionS(String question){
		String s = null;
		System.out.println(question);
		s = sc.nextLine();
		
		return s;
		
	}
	
	//MÉTODO PARA CAPTURA DE FLOATS
	//
		
	
	public static Float askQuestionF(String question){
		Float s = null;
		System.out.println(question);
		s = Float.parseFloat(sc.nextLine());
		
		return s;
		
	}
	
	//
	//MÉTODOS DE ARGUIÇÃO
	//
	
	//MÉTODO PARA CADASTRAR O USUÁRIO
	//
	
	public static void cadastra_pessoa(Integer Id, pessoa obj) {
		
		Integer stepper = 0;
		
		do {
			
			try {
			switch(stepper) {
			case 0:
				++stepper;
				obj.create_id(Id);
				
			break;
			case 1:
				++stepper;
				obj.create_nome(askQuestionS("Digite seu nome:\n"));
			break;
			case 2:
				++stepper;
				obj.create_sobrenome(askQuestionS("Digite seu Sobrenome:\n"));
			break;
			case 3:
				++stepper;
				obj.create_cidade(askQuestionS("Digite o nome da sua cidade:\n"));
			break;
			case 4:
				++stepper;
				obj.create_dataNasc(askQuestionS("Digite sua data de nascimento no formato 'dd/mm/aaaa':\n"));
			break;
			case 5:
				++stepper;
				obj.create_genero(askQuestionF("Digite seu gênero 0 - Masc; 1 - Fem; 2- Outro; 3 ou +:\n"));
			break;
			}
			} catch (Exception e) {
				System.out.println("Houve um erro no último dado cadastrado: \n" + e + "\n Vamos tentar novamente!\n");
				--stepper;
			}
		} while (stepper < 6);
	
		cjPessoas.add(obj);
	}
	//MÉTODO PARA CADASTRAR O EVENTO
	//
	
	public static void cadastra_evento(Integer Id, ev obj) {
		
		Integer stepper = 0;
		
		do {
			
			try {
				switch(stepper) {
				case 0:
					++stepper;
					obj.create_id(Id);
				break;
				case 1:
					++stepper;
					obj.create_nome(askQuestionS("Digite o nome do evento:\n"));
				break;
				case 2:
					++stepper;
					obj.create_data(askQuestionS("Digite a data em que ocorrerá no formato 'dd/mm/aaaa':\n"));
				break;
				case 3:
					++stepper;
					obj.create_cidade(askQuestionS("Digite a cidade em que ocorrerá:\n"));
				break;
				case 4:
					++stepper;
					obj.create_bairro(askQuestionS("Digite O endereço do evento:\n"));
				break;
				case 5:
					++stepper;
					System.out.println(printCatList(obj));
					obj.add_categoria(askQuestionI("Digite uma das categorias acima à qual o evento pertence:\n "));
				break;
			}
			} catch (Exception e) {
				System.out.println("Houve um erro no último dado cadastrado: \n" + e + "\n Vamos tentar novamente!");
				--stepper;	
			}
		} while (stepper < 6);
		cjEventos.add(obj);
	}
	
	
	//
	//MÉTODOS QUE APENAS GERAM STRINGS
	//
	//
	
	//MÉTODO QUE RETORNA A STRING INICIAL
	//
	
	public String titulo() {
		return "Escolha:\n" +
				"1 - cadastrar pessoa, 2 - cadastrar evento,\n"+
				"3 - imprimir pessoas cadastradas, 4 - Imprimir Eventos Cadastrados\n"+
				"5 - Imprimir Participantes de um determinado Evento\n"+
				"6 - Imprimir Eventos de um determinado participante\n"+
				"7 - Associar uma pessoa a um evento, 8 - Cancelar a participação\n"+
				" de uma pessoa em um evento\n"+
				"____________\n"+
				"0 Sair do programa";
	}
	
	//MÉTODO QUE RETORNA O NOME DE UMA PESSOA JÁ CADASTRADA
	//
	
	public static String printAttPessoa(pessoa obj) {
		
		return "ID " + obj.get_id() +" Nome Completo: " + obj.getNome() + " " + obj.getSobrenome() + " " + obj.timeDeltaY();
	
	}
	
	//MÉTODO QUE RETORNA O NOME DE UM EVENTO JÁ CADASTRADO
	//
	
	public static String printAttEvento(ev obj) {
		
		return "ID " + obj.get_id() + "- Nome do evento: " + obj.getNome() + " " + obj.getData() + " " + obj.timedeltaD();
		
	}
	
	
	//RETORNA A LISTA DE PARTICIPANTES DE UM EVENTO COM SEUS IDS
	//
	
	public static String printPartic(ev obj, List<pessoa> lst) {
		String lsPartic = "";
		for (Integer partic: obj.listaParticipantes) {
			lsPartic = partic + " - " + lst.get(partic-1).getNome() + obj.timedeltaD() + "\n" + lsPartic;
		}
			
		return lsPartic;
	}
	
	
	//RETORNA A LISTA DE EVENTOS COM SEUS IDS
	//
	
	public static String printAttend(pessoa obj, List<ev> lst) {
		String lsEvent = "";
		for (Integer att: obj.listaEventos) {
			lsEvent = att + " - " + lst.get(att-1).getNome() + obj.timeDeltaY() + "\n" + lsEvent;
		}
			
		return lsEvent;
	}
	
	//RETORNA A LISTA DE CATEGORIAS E SEUS IDS;
	//
	
	public static String printCatList(ev obj) {
		String lsEvent = "";
		Integer counter = 1;
		for (String att: obj.categEvento) {
			lsEvent = lsEvent + counter + " - " + att + ", " ;
			++counter;
		}
			
		return lsEvent;
	}
	
	//RETORNA A LISTA DE TODAS AS PESSOAS CADASTRADAS E SEUS IDS
	//
	
	public static String printList_pess(List<pessoa> lst) {
		String lsToPrint = "";
		Integer counter = 1;
		for (pessoa obj: lst) {
			lsToPrint = "id:" + counter + " - Nome:" + obj.getNome() + obj.timeDeltaY() + "\n" + lsToPrint;
			++counter;
		}
		return lsToPrint;
	
	//RETORNA A LISTA DE EVENTOS CADASTRADOS E SEUS IDS
	//
		
	}
	
	public static String printList_even(List<ev> lst) {
		String lsToPrint = "";
		Integer counter = 1;
		for (ev obj: lst) {
			lsToPrint = "id: " + counter + " - Nome:" + obj.getNome() + obj.timedeltaD() + "\n" + lsToPrint;
			++counter;
		}
		return lsToPrint;
		
	}
	
	public static Boolean confirm(Boolean bool) {
		askQuestionI("Confirma a informação cadastrada? 0 - Não; 1 - Sim.");
		
		return null;
	}
	

	
}