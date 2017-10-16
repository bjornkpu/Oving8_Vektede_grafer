package Oving8_Vektede_grafer;

/**
 * @author Bjørn Kristian Punsvik
 */
class Kant {
	Kant neste;
	Node til;

	public Kant(Node n, Kant nst){
		til = n;
		neste = nst;
	}
}
