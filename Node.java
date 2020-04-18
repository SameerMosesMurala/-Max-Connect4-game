import java.util.ArrayList;

public class Node {
	public GameBoard state;
	public int depth;
	public int choice; //the column that was played to get to this node
	public long value;
	public ArrayList<Node> sucNode;
	int[][] gameArray;
	//constructor
	public Node(GameBoard state,int depth, int choice) {
		this.state = state;
		this.depth = depth;
		this.choice = choice;
	}
	
	public ArrayList<Node> getSuccessors() {
		ArrayList<Node> successors = new ArrayList<Node>();
		for(int choiceLoop = 0; choiceLoop <7; choiceLoop++) {
			if(state.isValidPlay(choiceLoop)) {
				gameArray=state.getGameBoard();
				GameBoard tempGame=new GameBoard(gameArray);
				tempGame.playPiece(choiceLoop);
				successors.add(new Node(tempGame, depth+1, choiceLoop));
				tempGame=null;
			}
		}
		
		return successors;
	}
}
