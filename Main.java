package Oving8_Vektede_grafer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Bjørn Kristian Punsvik
 */
class Main {
	public static void main(String[] args) {
		BufferedReader reader = null;

		try {
			File file = new File("src/Oving8_Vektede_grafer/Grafer/vg1");
//			File file = new File("src/Oving7_Uvektede_grafer/grafer/L7g1.txt");
			reader = new BufferedReader(new FileReader(file));

			Graf g = new Graf();
			g.ny_vgraf(reader);

			//Utfører bredde-Først-Søk og skriver denne ut
				int StartNode = 1;
				System.out.println("Startnode: "+StartNode);
				g.dijkstra(g.node[StartNode]);
				g.printDijkstra();


		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Denne startnoden finnes ikke i grafen.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}