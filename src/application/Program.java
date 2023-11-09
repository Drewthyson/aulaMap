package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> countVotos = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		File file = new File(path);
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String votos = br.readLine();
			
			while (votos != null) {
				String[] fields = votos.split(",");
				String name = fields[0];
				Integer voto = Integer.parseInt(fields[1]);
				
				if (countVotos.containsKey(name)) {
					voto += countVotos.get(name);
				}
				
				countVotos.put(name, voto);
				votos = br.readLine();
			}
			
			for (String key : countVotos.keySet()) {
				System.out.println(key + ", " + countVotos.get(key));
			}
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
