/**
 * 
 */
package branchandbound;

import java.util.LinkedList;

/**
 * @author rosariogarcia
 * This is a queue of possible solutions
 */
public class Queue extends LinkedList {
	/**
	 * Verify if the queue is empty
	 * @return, true if is empty, false if isn't
	 */
	public boolean emptyQueue() {
		if (this.size() == 0) {
			return true;
		} else
			return false;
	}
	/**
	 * Remove and solution that is not optima
	 * @return
	 */
	public Node atend() {
		Node firstElement = (Node) this.getFirst();
		Node possibleSolution = new Node();
		possibleSolution.column = firstElement.column;
		possibleSolution.row = firstElement.row;
		possibleSolution.solution = Utils.copiarmatrix(firstElement.solution);
		this.removeFirst();
		return possibleSolution;

	}
	/**
	 * Add a possible solution
	 * @param X
	 */
	public void askAgain(Node X) {
		Node possibleSolution = new Node();
		possibleSolution.column = X.column;
		possibleSolution.row = X.row;
		possibleSolution.solution = Utils.copiarmatrix(X.solution);

		this.addLast(possibleSolution);

	}
}
