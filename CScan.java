import java.util.Arrays;
import java.util.LinkedList;

public class CScan {
	private int[] requisicoes;
	private int[] cilindro;
	private int inicial;
	private int tamanho;
	private LinkedList<Integer> reqs;
	public CScan(int tamanho, int[] req, int inicial, LinkedList reqs){
		cilindro = new int[tamanho];
		requisicoes = req;
		this.inicial = inicial;
		this.tamanho = tamanho;
		this.reqs = new LinkedList<>(reqs);
	}

	public int[] getRequisicoes() {
		return requisicoes;
	}

	public void setRequisicoes(int[] requisicoes) {
		this.requisicoes = requisicoes;
	}

	public int[] getCilindro() {
		return cilindro;
	}

	public void setCilindro(int[] cilindro) {
		this.cilindro = cilindro;
	}

	public int getInicial() {
		return inicial;
	}

	public void setInicial(int inicial) {
		this.inicial = inicial;
	}


	public void scandisk(){
		int sub;
		int t = inicial;
		int pred = reqs.get(0);
		int primeiro = reqs.get(0);
		int ultimo = reqs.get(reqs.size()-1);
		Arrays.sort(requisicoes);
		while(true){
			if(this.inicial < (this.tamanho/2)){ 
				for(int i=0;i<reqs.size();i++){
					int a;
					a = reqs.get(i);
					if(a<t){
						pred=a;		
						sub = Math.abs(inicial-a);		
						if(sub<t){				
							pred=a;						
						}
						else{

						}
					}
					else if(t==0){
						sub = a - inicial;
						if(t==0){
						
							pred=a;
						}
						if(sub<t){
							pred=a;
							
						}
					}
					else if(pred==t){
						pred=a;
						sub = a-inicial;
					}
				}
				for(int i=0;i<reqs.size();i++){
					System.out.println(reqs.get(i));
				}
				System.out.println("Movendo a cabeca para " + pred + " partindo de " + t);
				reqs.remove((Object)pred);
				if(reqs.isEmpty()){
					System.out.println("Todas as requisicoes foram atendidas!");
					break;
				}
				if(pred==primeiro){
					System.out.println("-----Rotacionando para o fim do disco-----");
					pred=40;
					t=pred;
				}

			}
			if(this.inicial > (this.tamanho/2)){
				for(int i=reqs.size()-1;i>=0;i--){
					int a;
					a = reqs.get(i);
					if(a>t){
						pred=a;		
						sub = Math.abs(inicial-a);		
						if(sub<t){				
							pred=a;						
						}
					}
					else if(t==0){
						sub = a - inicial;
						if(t==0){
							pred=a;
						}
						if(sub<t){
							pred=a;
							
						}
					}
					else if(pred==t){
						pred=a;
						sub = a-inicial;
					}
				}
				for(int i=0;i<reqs.size();i++){
					System.out.println(reqs.get(i));
				}
				System.out.println("Movendo a cabeca para " + pred + " partindo de " + t);
				reqs.remove((Object)pred);
				if(reqs.isEmpty()){
					System.out.println("Todas as requisicoes foram atendidas!");
					break;
				}
				if(pred==ultimo){
					System.out.println("-----Rotacionando para o inicio do disco-----");
					pred=0;
					t=pred;
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//this.inicial=pred;
			t=pred;
			//t=inicial;
		}
	}
}
