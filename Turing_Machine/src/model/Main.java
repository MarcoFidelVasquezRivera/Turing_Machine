package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		
		while(line!=null && !(line.equalsIgnoreCase("")) && !(line.equalsIgnoreCase(" "))) {
			System.out.println(line);
			line = br.readLine();
		}
		
		

		System.out.println(line);
		br.close();
		bw.close();
	}

}