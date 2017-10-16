package Oving8_Vektede_grafer;

/**
 * @author Bjørn Kristian Punsvik
 */
class Vkant extends Kant {
	int vekt;

	public Vkant(Node n, Vkant nst, int vkt) {
		super(n, nst);
		vekt = vkt;
	}
}
