package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
	
	private TuringMachine tm = new TuringMachine();
	
	public Main() {
		
	}
	
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		BufferedReader br = new BufferedReader(new FileReader("data/in_turing.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/out_turing_marco.txt"));
		
		long time1 =  System.currentTimeMillis();
		String line = br.readLine();
		
		while(line!=null && !(line.equalsIgnoreCase("")) && !(line.equalsIgnoreCase(" "))) {
			
			int i=0;
			while(i<line.length()) {
				char head = line.charAt(i);
				i++;
				//System.out.println(i);
				switch(line.charAt(i)) {
					case '0':
						
						bw.write(main.tm.readTape(head)+"\n");
						break;
					case '1':
						i++;
						main.tm.addTape(line.charAt(i), head);
						
						break;
					case '2':
						main.tm.removeTape(head);
						break;
				}
				i++;
			}
			main.tm.resetValues();
			line = br.readLine();
		}
	
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
		br.close();
		bw.close();
	}

}