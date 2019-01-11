import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);
		LinkedList<Integer> reqs = new LinkedList<>();
		reqs.add(1);
		reqs.add(9);
		reqs.add(12);
		reqs.add(16);
		reqs.add(34);
		reqs.add(36);
		Random rand = new Random();
		Scan disco = new Scan(40,34,reqs);
		CScan c = new CScan(40, 34, reqs);
		c.scandisk();
		//System.out.println(disco.getInicial());
		//disco.scandisk();
		
		
		
		boolean parar = false;
		int op = 0;
		int op2 = 0;
		int valor = 0;;
		while(parar) {
			System.out.println("1 - Scan");
			System.out.println("2 - C-Scan");
			System.out.println("3 - Encerrar");
			op = scanf.nextInt();
			switch(op) {
				case 1:
					System.out.println("1 - Usar exemplo base: 1,9,12,16,34,36");
					System.out.println("2 - Inserir requisicao nova");
					op2= scanf.nextInt();
					switch(op2) {
						case 1:
							Scan diskscan = new Scan(40, rand.nextInt(41), reqs);
							diskscan.scandisk();
							break;
						case 2:
							LinkedList<Integer> req = new LinkedList<>();
							System.out.println("Digite a requisicoes, digite -1 quando terminar");
							while(valor != -1) {
								valor = scanf.nextInt();
								req.add(valor);
							}
							if(valor == -1) {
								System.out.println("Digite agora o tamanho do cilindro");
								valor = scanf.nextInt();
							}
							Scan scan = new Scan(valor, rand.nextInt(valor+1), req);
							scan.scandisk();
							break;
					}
					break;
				case 2:
					System.out.println("1 - Usar exemplo base: 1,9,12,16,34,36");
					System.out.println("2 - Inserir requisicao nova");
					op2= scanf.nextInt();
					switch(op2) {
						case 1:
							CScan diskCscan = new CScan(40, rand.nextInt(41), reqs);
							diskCscan.scandisk();
							break;
						case 2:
							LinkedList<Integer> req = new LinkedList<>();
							System.out.println("Digite a requisicoes, digite -1 quando terminar");
							while(valor != -1) {
								valor = scanf.nextInt();
								req.add(valor);
							}
							if(valor == -1) {
								System.out.println("Digite agora o tamanho do cilindro");
								valor = scanf.nextInt();
							}
							CScan cscan = new CScan(valor, rand.nextInt(valor+1), req);
							cscan.scandisk();
							break;
					}
					break;
				case 3:
					parar = false;
				default:
					
			}
		}

	}

}