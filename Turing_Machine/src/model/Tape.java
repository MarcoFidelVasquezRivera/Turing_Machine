package model;

public class Tape {
	
	private char letter;
	private Tape nextTape = null;
	private Tape previusTape = null;
	
	public Tape(char l) {
		letter=l;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void setLetter(char l) {
		letter=l;
	}
	
	public Tape getNextTape() {
		return nextTape;
	}
	
	public void setNextTape(Tape n) {
		nextTape = n;
	}
	
	public Tape getPreviusTape() {
		return previusTape;
	}
	
	public void setPreviusTape(Tape p) {
		previusTape = p;
	}
}
