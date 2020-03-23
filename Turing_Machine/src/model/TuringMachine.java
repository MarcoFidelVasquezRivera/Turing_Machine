package model;

public class TuringMachine {

	private Tape c0 = null;
	private Tape c1 = null;
	private Tape c2 = null;
	private int nTapes = 0;
	
	public TuringMachine() {
		
	}
	
	public void addTape(char letter, char head) {
		Tape t = new Tape(letter);
		
		switch(head) {
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case '0':
				if(c0==null) {
					c0 = t;
					c1 = t;
					c2 = t;
					nTapes++;
				}else {
					t.setNextTape(c0);
					c0.setPreviusTape(t);
					c0=t;	
					nTapes++;
					if(nTapes%2==0) {
						c1 = c1.getPreviusTape();
					}
				}
				break;
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case '1':
				if(c1==null) {
					c0 = t;
					c1 = t;
					c2 = t;
					nTapes++;
				}else {
					Tape prev = c1.getPreviusTape();
					Tape next = c1.getNextTape();
					if(prev==null) {
						t.setNextTape(c1);
						c1.setPreviusTape(t);
						c0 = t;
						c1 = t;	
						nTapes++;
					}else {
						if(nTapes%2==0) {
							t.setPreviusTape(c1);
							t.setNextTape(next);
							c1.setNextTape(t);
							
							nTapes++;
							
						}else {
							t.setPreviusTape(prev);
							t.setNextTape(c1);
							c1.setPreviusTape(t);
							
							nTapes++;
						}
					}
				}
				break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////
			case '2':
				if(c2==null) {
					c0 = t;
					c1 = t;
					c2 = t;
					nTapes++;
				}else {
					t.setPreviusTape(c2);
					c2.setNextTape(t);
					c2=t;	
					nTapes++;
					if(nTapes%2!=0) {
						c1 = c1.getNextTape();
					}
				}
				break;
		}
	}
	
	public char readTape(char head) {
		char letter='#';
		
		switch(head) {
			case '0':
				letter = c0.getLetter();
				break;
			case '1':
				letter = c1.getLetter();
				break;
			case '2':
				letter = c2.getLetter();
				break;
		}
		
		return letter;
	}
	
	public void removeTape(char head) {

		switch(head) {
			case '0':
				if(c0!=null) {
				c0 = c0.getNextTape();
				c0.setPreviusTape(null);
				}
				break;
			case '1':
				if(c1!=null) {
					Tape prev = c1.getPreviusTape();
					Tape next = c1.getNextTape();
					
					prev.setNextTape(next);
					next.setPreviusTape(prev);
					
					if(nTapes%2==0) {
						c1 = next;
					}else {
						c1 = prev;
					}
				}
				break;
			case '2':
				if(c2!=null) {
				c2 = c2.getPreviusTape();
				c2.setNextTape(null);
				}
				break;
		}
		nTapes--;
	}
	
	public void resetValues() {
		c0=null;
		c1=null;
		c2=null;
		nTapes=0;
	}
}
