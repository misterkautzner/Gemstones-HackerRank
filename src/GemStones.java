import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This is a comment I'm using to create a second version on github
public class GemStones {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		char rowcolumn[][] = new char[n][101];
		
		//This fills the array with 0's so we don't have to worry about the length of each string
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 101; j++) {
				rowcolumn[i][j] = '0';
			}
		}
		
		
		for(int i = 0; i < n; i++) {
		
			String row = in.next();
			
			for(int j = 0; j < row.length(); j++){
				
				rowcolumn[i][j] = row.charAt(j);
			}
		}
			
			//Here we will change any duplicate letters in the first string to 1's.
			for(int i = 0; i < 100; i++) {
				
				for(int j = i+1; j < 100; j++) {
				
					if(rowcolumn[0][i] == rowcolumn[0][j]) {
						rowcolumn[0][j] = '1';
						
					}
				}
			}
			
			int gems = 0;
			
			//Here we see which elements of the first string are in all of the others.
			//Iterating on the letter of the first string.
			for(int i = 0; i < 100; i++) {
				
				int potentialgem = 1;
				
				//If it gets to a '0' (the end of the string), then we're done.
				if(rowcolumn[0][i] == '0') {
					potentialgem = 0;
					break;
				}
				
				//Iterating on the row for which we are checking for the element.
				for(int j = 1; j < n; j++) {
					
					//Iterating on the element in the row.
					for(int k = 0; k < 101; k++) {
					
						//If we get the same element, we can move on to the next row.
						if(rowcolumn[0][i] == rowcolumn[j][k]) {
							break;
						}
						
						//If we get a '0', then the element didn't show up in this string.
						if(rowcolumn[j][k] == '0') {
							potentialgem = 0;
							break;
						}
					}
					
					if(potentialgem == 0) {
						break;
					}
				
			}
				if(potentialgem == 1) {
					gems++;
				}
				
			
		}
		
		System.out.println(gems);
		
	}
	

}

