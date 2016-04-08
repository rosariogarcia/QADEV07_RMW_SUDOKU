/**
 * 
 */
package branchandbound;

import java.util.LinkedList;

/**
 * @author rosariogarcia
 *
 */
public class Queue extends LinkedList {
	public boolean emptyQueue() {
		if (this.size() == 0) {
			return true;
		} else
			return false;
	}

	public Node atend() {
		Node firstElement = (Node) this.getFirst();
		Node possibleSolution = new Node();
		possibleSolution.column = firstElement.column;
		possibleSolution.row = firstElement.row;
		possibleSolution.solution = Utils.copiarmatrix(firstElement.solution);
		this.removeFirst();
		return possibleSolution;

	}

	public void askAgain(Node X) {
		Node possibleSolution = new Node();
		possibleSolution.column = X.column;
		possibleSolution.row = X.row;
		possibleSolution.solution = Utils.copiarmatrix(X.solution);

		this.addLast(possibleSolution);

	}
}
