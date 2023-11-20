package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		return null;
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
//		return null;
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node res = new Node();
		res.generateBoard();
		int c = rd.nextInt(Node.N);
		System.out.println(c);
		for (int i = 0; i < c; i++) {
//			res.getState()[i] = x.getState()[i];
			res.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
//			res.getState()[i] = y.getState()[i];
			res.setRow(i, y.getRow(i));
		}
		return res;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
		// Enter your code here
		List<Node> re = new ArrayList<Node>();
		for (int i = 0; i < k; i++) {
			int stt = rd.nextInt(population.size());
			re.add(population.get(stt));
		}
		
		Collections.sort(re);
		return re.get(0);
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		int stt = rd.nextInt(population.size());
		return population.get(stt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GA_NQueenAlgo a = new GA_NQueenAlgo();
		a.initPopulation();
		Node x = a.getParentByRandomSelection();
		Node y = a.getParentByTournamentSelection(3);
		Node child = a.reproduce(x, y);
		System.out.println("cha ne");
		x.displayBoard();
		System.out.println("me ne");
		y.displayBoard();
		System.out.println("con ne");
		child.displayBoard();

	}

}
