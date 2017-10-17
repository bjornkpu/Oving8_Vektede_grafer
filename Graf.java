package Oving8_Vektede_grafer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Bjørn Kristian Punsvik
 */
class Graf {
	int N, K;
	Node[] node;

	public void ny_vgraf(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		node = new Node[N];
		for (int i = 0; i < N; ++i) {
			node[i] = new Node();
		}
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int fra = Integer.parseInt(st.nextToken());
			int til = Integer.parseInt(st.nextToken());
			int vekt = Integer.parseInt(st.nextToken());
			Vkant k = new Vkant(node[til], (Vkant)node[fra].kant1, vekt);
			node[fra].kant1 = k;
		}
	}

	void forkort(Node n, Vkant k) {
		Forgj nd = (Forgj)n.d, md = (Forgj)k.til.d;
		if(md.dist > nd.dist + k.vekt) {
			md.dist = nd.dist + k.vekt;
			md.forgj = n;
		}
	}

	void initforgj(Node s) {
		for (int i = N; i-- > 0; ) {
			node[i].d = new Forgj();
		}
		((Forgj) s.d).dist = 0;
	}

	void dijkstra(Node s) {
		initforgj(s);
		Node[] pri = new Node[N];
		lag_priko(pri);
		for (int i = N; i > 1; --i) {
			Node n = hent_min(i, pri);
			for (Vkant k = (Vkant)n.kant1; k != null; k = (Vkant)k.neste) {
				forkort(n, k);
			}
		}
	}
	void printDijkstra() {
		Node n;
		System.out.println("Node    "+"Forgj         "+"Dist");
		for (int i = 0; i < node.length; i++) {
			n = node[i];
			Forgj fj= (Forgj)n.d;
			int f = Arrays.asList(node).indexOf(fj.forgj);
			String forUt = ""+f;
			String distUt = ""+fj.dist;

			if (f == -1) {
				forUt = " ";
				if(fj.dist == 0){
					forUt = "Start";
				}
			}
			if (fj.dist == 1000000000) distUt = "nåes ikke";

			System.out.println(i + "          "
					+forUt + "           "
					+ distUt);
		}
	}

	void lag_priko(Node t[]) {
		for (int i = 0; i < N; ++i) {
			t[i] = node[i];
		}
	}

	Node hent_min(int ant, Node []t) {
		int min = 0;
		for (int i = ant; --i > 0;) {
			if (((Forgj)t[i].d).dist < ((Forgj)t[min].d).dist) min = i;
		}
		Node ret = t[min];
		t[min] = t[ant - 1];
		return ret;
	}
}
