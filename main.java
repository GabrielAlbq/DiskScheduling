import java.util.LinkedList;
import java.util.Random;

public class main {

	public static void main(String[] args) {
		int[] req = {1,9,12,16,34,36};
		LinkedList<Integer> reqs = new LinkedList<>();
		reqs.add(1);
		reqs.add(9);
		reqs.add(12);
		reqs.add(16);
		reqs.add(34);
		reqs.add(36);
		Random rand = new Random();
		//int a = rand.nextInt(40);
		//System.out.println(a);
		Scan disco = new Scan(40,req,rand.nextInt(41),reqs);
		CScan c = new CScan(40, req, rand.nextInt(41), reqs);
		c.scandisk();
		//System.out.println(disco.getInicial());
		//disco.scandisk();
		

	}

}
