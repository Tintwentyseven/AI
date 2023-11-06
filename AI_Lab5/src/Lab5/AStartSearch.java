package Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStartSearch implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByF);
		frontier.add(model.getInitialState());
		List<Node> explored = new ArrayList<>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
//			System.out.println("curentstate: \n"+current+"\n"+current.getF());
			for (Node node : frontier) {
//				System.out.println("childFrontier: \n"+node+"\n"+node.getF());
			}
			if(current.getH()==0) return current;
			else {
				explored.add(current);
				List<Node> listChildren = model.getSuccessors(current);
				for (Node child : listChildren) {
					if(!frontier.contains(child)&& !explored.contains(child)) {
						child.setG(current.getG()+1);
						frontier.add(child);
					}else if(frontier.contains(child)&& child.getF()> current.getF()+1) {
						frontier.remove(child);
						child.setG(current.getG()+1);
						frontier.add(child);
					}
				}
			}
		}
		return null;
	

}
}
