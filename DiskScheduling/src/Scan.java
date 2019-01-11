import java.util.*;

public class Scan {
	
	private int inicial;
	private int tamanho;
	private LinkedList<Integer> reqs;
	public Scan(int tamanho,int inicial, LinkedList reqs){
		this.inicial = inicial;
		this.tamanho = tamanho;
		this.reqs = new LinkedList<>(reqs);
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
		int menor = inicial;
		int primeiro = reqs.get(0);
		int ultimo = reqs.get(reqs.size()-1);
		Collections.sort(reqs);
		while(true){
			if(this.inicial <= (this.tamanho/2)){ 
				menor=Integer.MAX_VALUE;
				for(int i=0;i<reqs.size();i++){
					int a;
					a = reqs.get(i);
					if(a<=t){ //vai guardando em pred o valor mais proximo de a
						pred=a;		
						sub = Math.abs(t-a);
						if(sub<menor){
							menor=sub;
							pred=a;						
						}
					}
					else if(t==0){					
						sub = a - t;
						if(t==0){
							pred=a;
							break;
						}
//						if(sub<menor){
//							pred=a;
//						}
					}
					else if(pred==t && pred==0 && t==0){
						pred=a;
//						else if(a == ultimo) {
//							pred=a;
//						}
						//sub = a-t;
					}
					else if(a>t) {
						sub = a-t;
						if(sub<menor){
							menor=sub;
							pred=a;						
						}
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
					System.out.println("-----Indo para o inicio do disco-----");
					pred=0;
					t=pred;
					menor=pred;
				}

			}
			if(this.inicial > (this.tamanho/2)){
				menor=Integer.MAX_VALUE;
				for(int i=reqs.size()-1;i>=0;i--){
					int a;
					a = reqs.get(i);
					if(a>=t){
						pred=a;		
						sub = Math.abs(a-t);
						if(sub<menor){
							menor=sub;
							pred=a;						
						}
					}
					else if(t==40){
						sub = a - t;
						if(t==40){				
							pred=a;
							break;
						}
//						if(sub<menor){
//							pred=a;
//						}
					}
					else if(pred==t  && pred==0 && t==0){
						pred=a;
						//sub = a-t;
					}
					else if(a<t) {
						sub = t-a;
						if(sub<menor){
							menor=sub;
							pred=a;						
						}
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
					System.out.println("-----Indo para o fim do disco-----");
					pred=40;
					t=pred;
					menor=pred;
				}

			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t=pred;
		}
	}
}