package Oving8_Vektede_grafer;

/**
 * @author Bjørn Kristian Punsvik
 */
class Heap {
	int len;
	int node[];

	public Heap(int lengde) {
		node = new int[lengde];
		len = 0;
	}

	public void fiks_heap(int i) {
		int m = venstre(i);
		if (m < len) {
			int h = m + 1;
			if (h < len && node[h] > node[m]) m = h;
			if (node[m] > node[i]) {
				bytt(node, i, m);
				fiks_heap(m);
			}
		}
	}

	int over(int i) { return (i - 1) >> 1; }
	int venstre(int i) { return (i << 1) + 1; }
	int hoyre(int i) { return (i + 1) << 1; }

	public void heapsort() {
		lag_heap();
		int l = len;
		while (len > 1) {
			int x = hent_maks();
			node[len] = x;
		}
		len = l;
	}

	public int hent_maks() {
		int maks = node[0];
		node[0] = node[--len];
		fiks_heap(0);
		return maks;
	}
	public int hent_min() {
		int min = node[0];
		node[0] = node[--len];
		fiks_heap(0);
		return min;
	}

	public void lag_heap() {
		int i = len / 2;
		while (i-- > 0) fiks_heap(i);
	}

	public void prio_ned(int i, int p) {
		node[i] -= p;
		fiks_heap(i);
	}

	public void prio_opp(int i, int p) {
		int f;
		node[i] += p;
		while (i>0 && node[i]>node[f=over(i)]) {
			bytt(node, i, f);
			i = f;
		}
	}

	public void sett_inn(int x) {
		int i = len++;
		node[i] = x;
		prio_opp(i, 0);
	}

	public static void bytt(int []t, int i, int j) {
		int k = t[j];
		t[j] = t[i];
		t[i] = k;
	}

	public static void main(String[] args) {
		int[] data = {5, 8, 3, 7, 12, 10, 9, 0, 4, 7, 2};
		Heap h = new Heap(data.length);
		for (int i=0; i < data.length; ++i) h.sett_inn(data[i]);
		for (int i=0; i<h.len;++i) System.out.print(h.node[i]+" ");
		System.out.println();
		h.prio_opp(2, 15);
		h.prio_ned(1, 10);
		for (int i=0; i<h.len;++i) System.out.print(h.node[i]+" ");
		System.out.println();
		h.heapsort();
		for (int i=0; i<h.len;++i) System.out.print(h.node[i]+" ");
		System.out.println();
	}
}