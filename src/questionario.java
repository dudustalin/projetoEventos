import java.util.Scanner;
import java.util.List;


public class questionario{
	public static Scanner sc = new Scanner(System.in);
	public static acoes action = new acoes();
	public static Integer idPessoa = 0;
	public static Integer idEvento = 0;
	public static pessoa person = null;
	public static ev event = null;
	

	public static Integer gerar_id(Integer num){
		Integer Id_inicial = num;
		Integer Id_resultado = ++Id_inicial;
		return Id_resultado;
	}
	
	
	public static void main(String[] args) {
		try {
			quest();	
		} catch (Exception e){
		System.out.println("Vamos reiniciar, houve um erro!");
		quest();
		} finally {
			
			}
	}
	
	public static void quest() {


		Integer opcao = null;
		Integer opcao_2 = null;
		Integer escolha = null;

		
		
		do {
			opcao = acoes.askQuestionI(action.titulo());	
			
			switch(opcao) {
			
			case 1:
				person = new pessoa();
				idPessoa = gerar_id(idPessoa);
				acoes.cadastra_pessoa(idPessoa, person);
				
				do {
					
					opcao_2 = acoes.askQuestionI("Deseja associar um evento a " + person.getNome() + " (0 - não 1 - sim)?");
					System.out.println(opcao_2);
					if (opcao_2 == 1) {
						event = new ev();
						event.popuList();
						idEvento = gerar_id(idEvento);
						acoes.cadastra_evento(idEvento, event);
						} else {
							
						opcao_2 = 0;
							
						}
						
					} while (opcao_2 != 0);
					
				
				break;
				
			case 2:
				event = new ev();
				event.popuList();
				idEvento = gerar_id(idEvento);
				acoes.cadastra_evento(idEvento, event);
				
				break;
			
			case 3:
				for (pessoa pInst : acoes.cjPessoas) {
					System.out.println(acoes.printAttPessoa(pInst));
					
				}
				break;
			
			case 4:
				for (ev eInst : acoes.cjEventos) {
					System.out.println(acoes.printAttEvento(eInst));
				}
				
				
				break;
				
			case 5:
				for (ev eInst : acoes.cjEventos) {
					System.out.println(acoes.printAttEvento(eInst));
				}
				System.out.println("Escolha o evento pelo ID associado acima");
				escolha = Integer.parseInt(sc.nextLine());
				System.out.println(acoes.printPartic(acoes.cjEventos.get(escolha-1), acoes.cjPessoas));
				escolha = 0;
				break;
				
			case 6:
				for (pessoa pInst : acoes.cjPessoas) {
					System.out.println(acoes.printAttPessoa(pInst));
				}
				System.out.println("Escolha a pessoa pelo ID associado acima");
				escolha = Integer.parseInt(sc.nextLine());
				System.out.println(acoes.printAttend(acoes.cjPessoas.get(escolha-1), acoes.cjEventos));
				
				break;
			
			case 7:
				commit(true, person, event, acoes.cjPessoas, acoes.cjEventos);
				break;
				
				
			case 8:
				commit(false, person, event, acoes.cjPessoas, acoes.cjEventos);
				break;

			case 0:
				System.out.println("Tchau!");
				break;
			}
			
		} while (opcao != 0);
	}
	
	public static void commit(Boolean bool, pessoa pess, ev even, List<pessoa> lstPess, List<ev> lstEven) {
		
		String commit_;
		
		if (bool) {
			commit_ = " para exlusão:";
		} else {
			commit_ = " para inclusão";
		}
		
		
		if (even == null) {
			
			Integer yeNo = acoes.askQuestionI("Não existe evento cadastrado.\n Quer cadastrar? 0 - Não; 1 - Sim; 2+ = 0");
			
			if (yeNo != 1) {
				;
			} else {
				
				ev event = new ev();
				acoes.cadastra_evento(gerar_id(idEvento), event);
			}
			
			
						
		} else if(pess == null) {
			
				Integer yeNo = acoes.askQuestionI("Não existe pessoa cadastrada.\n Quer cadastrar? 0 - Não; 1 - Sim; 2+ = 0");
				
				if (yeNo != 1) {
					;
				} else {
				
				pessoa person = new pessoa();
				acoes.cadastra_pessoa(gerar_id(idPessoa), person);
			}
			
		} else {
			
			System.out.println(acoes.printList_pess(lstPess));
			Integer pessEsc = acoes.askQuestionI("Digite o ID associado à pessoa" + commit_);
			
			System.out.println(acoes.printList_even(lstEven));
			Integer evenEsc = acoes.askQuestionI("Digite o ID associado ao evento" + commit_);
			
			if (even.listaParticipantes.contains(pessEsc) == false) {
				
				//
				
			} else {
				control(bool, even, pess, pessEsc, evenEsc);
				
			}
				 
		}
		
	}
		
		
	public static void control(Boolean bool, ev even, pessoa pess, Integer int_pess, Integer int_even) {
		if (bool) {
			pess.listaEventos.add(int_pess);
			even.listaParticipantes.add(int_even);
		} else {
			pess.listaEventos.remove(int_pess);
			even.listaParticipantes.remove(int_even);
		}
	}
	
}