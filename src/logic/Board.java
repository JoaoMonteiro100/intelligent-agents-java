package logic;

import java.util.List;

public class Board {
	
	private Lot a1, a2, a3, a4,
	b1, b2, b3, b4,
	c1, c2, c3, c4,
	d1, d2, d3, d4,
	e1, e2, e3, e4,
	f1, f2, f3, f4,
	g1, g2, g3, g4,
	h1, h2, h3, h4,
	i1, i2, i3, i4,
	j1, j2, j3, j4,
	k1, k2, k3, k4,
	l1, l2, l3, l4,
	
	//Trenches
	t1, t3, t5, t7,
	t2, t4, t6, t8, t10,
	t9, t11, t13, t15,
	t12, t14, t16, t18, t20,
	t17, t19, t21, t23,
	t22, t24, t26, t28, t30,
	t25, t27, t29, t31,
	
	//Wells
	w1, w2, w3, w4, w5,
	w6, w7, w8, w9, w10,
	w11, w12, w13, w14, w15,
	w16, w17, w18, w19, w20;
	
	private Lot[] lands, trenches, wells;
	//private Lot[][] regionA, regionB, regionC, regionD, regionE, regionF, regionG, regionH, regionI, regionJ, regionK, regionL;
	
	public Board() {
		initialize();
	}
	
	private void initialize() {
		//Lands
		a1 = new Lot();
		a2 = new Lot();
		a3 = new Lot();
		a4 = new Lot();
		b1 = new Lot();
		b2 = new Lot();
		b3 = new Lot();
		b4 = new Lot();
		c1 = new Lot();
		c2 = new Lot();
		c3 = new Lot();
		c4 = new Lot();
		d1 = new Lot();
		d2 = new Lot();
		d3 = new Lot();
		d4 = new Lot();
		e1 = new Lot();
		e2 = new Lot();
		e3 = new Lot();
		e4 = new Lot();
		f1 = new Lot();
		f2 = new Lot();
		f3 = new Lot();
		f4 = new Lot();
		g1 = new Lot();
		g2 = new Lot();
		g3 = new Lot();
		g4 = new Lot();
		h1 = new Lot();
		h2 = new Lot();
		h3 = new Lot();
		h4 = new Lot();
		i1 = new Lot();
		i2 = new Lot();
		i3 = new Lot();
		i4 = new Lot();
		j1 = new Lot();
		j2 = new Lot();
		j3 = new Lot();
		j4 = new Lot();
		k1 = new Lot();
		k2 = new Lot();
		k3 = new Lot();
		k4 = new Lot();
		l1 = new Lot();
		l2 = new Lot();
		l3 = new Lot();
		l4 = new Lot();
		
		lands = new Lot[]{a1,a2,a3,a4,
				b1,b2,b3,b4,
				c1,c2,c3,c4,
				d1,d2,d3,d4,
				e1,e2,e3,e4,
				f1,f2,f3,f4,
				g1,g2,g3,g4,
				h1,h2,h3,h4,
				i1,i2,i3,i4,
				j1,j2,j3,j4,
				k1,k2,k3,k4,
				l1,l2,l3,l4};
		
		//Trenches
		t1 = new Lot();
		t2 = new Lot();
		t3 = new Lot();
		t4 = new Lot();
		t5 = new Lot();
		t6 = new Lot();
		t7 = new Lot();
		t8 = new Lot();
		t9 = new Lot();
		t10 = new Lot();
		t11 = new Lot();
		t12 = new Lot();
		t13 = new Lot();
		t14 = new Lot();
		t15 = new Lot();
		t16 = new Lot();
		t17 = new Lot();
		t18 = new Lot();
		t19 = new Lot();
		t20 = new Lot();
		t21 = new Lot();
		t22 = new Lot();
		t23 = new Lot();
		t24 = new Lot();
		t25 = new Lot();
		t26 = new Lot();
		t27 = new Lot();
		t28 = new Lot();
		t29 = new Lot();
		t30 = new Lot();
		t31 = new Lot();
		
		trenches = new Lot[]{t1, t3, t5, t7,
				t2, t4, t6, t8, t10,
				t9, t11, t13, t15,
				t12, t14, t16, t18, t20,
				t17, t19, t21, t23,
				t22, t24, t26, t28, t30,
				t25, t27, t29, t31};
		
		//Wells
		w1 = new Lot();
		w2 = new Lot();
		w3 = new Lot();
		w4 = new Lot();
		w5 = new Lot();
		w6 = new Lot();
		w7 = new Lot();
		w8 = new Lot();
		w9 = new Lot();
		w10 = new Lot();
		w11 = new Lot();
		w12 = new Lot();
		w13 = new Lot();
		w14 = new Lot();
		w15 = new Lot();
		w16 = new Lot();
		w17 = new Lot();
		w18 = new Lot();
		w19 = new Lot();
		w20 = new Lot();
		
		wells = new Lot[]{w1, w2, w3, w4, w5,
				w6, w7, w8, w9, w10,
				w11, w12, w13, w14, w15,
				w16, w17, w18, w19, w20};
		/*
		regionA = new Lot[][]{{A11,A12},{A21,A22}};
		regionB = new Lot[][]{{B11,B12},{B21,B22}};
		regionC = new Lot[][]{{C11,C12},{C21,C22}};
		regionD = new Lot[][]{{D11,D12},{D21,D22}};
		regionE = new Lot[][]{{E11,E12},{E21,E22}};
		regionF = new Lot[][]{{F11,F12},{F21,F22}};
		regionG = new Lot[][]{{G11,G12},{G21,G22}};
		regionH = new Lot[][]{{H11,H12},{H21,H22}};
		regionI = new Lot[][]{{I11,I12},{I21,I22}};
		regionJ = new Lot[][]{{J11,J12},{J21,J22}};
		regionK = new Lot[][]{{K11,K12},{K21,K22}};
		regionL = new Lot[][]{{L11,L12},{L21,L22}};
		*/
	}
	
	/*
	 * Irrigates all lots given as argument
	 */
	private void irrigateLands (Lot[] lots) {
		for(int i = 0; i < lots.length; i++) {
			lots[i].irrigate();
		}
	}
	
	/*
	 * Returns the lands associated with a trench
	 */
	public Lot[] connectedLands (Lot lot) {
		//trenches and lands
		if (lot==t1) {
			return new Lot[]{a1,a2};
		}
		else if (lot==t2) {
			return new Lot[]{a1,a3};
		}
		else if (lot==t3) {
			return new Lot[]{b1,b2};
		}
		else if (lot==t4) {
			return new Lot[]{a2,a4,b1,b3};
		}
		else if (lot==t5) {
			return new Lot[]{c1,c2};
		}
		else if (lot==t6) {
			return new Lot[]{b2,b4,c1,c3};
		}
		else if (lot==t7) {
			return new Lot[]{d1,d2};
		}
		else if (lot==t8) {
			return new Lot[]{c2,c4,d1,d3};
		}
		else if (lot==t9) {
			return new Lot[]{a3,a4,e1,e2};
		}
		else if (lot==t10) {
			return new Lot[]{d2,d4};
		}
		else if (lot==t11) {
			return new Lot[]{b3,b4,f1,f2};
		}
		else if (lot==t12) {
			return new Lot[]{e1,e3};
		}
		else if (lot==t13) {
			return new Lot[]{c3,c4,g1,g2};
		}
		else if (lot==t14) {
			return new Lot[]{e2,e4,f1,f3};
		}
		else if (lot==t15) {
			return new Lot[]{d3,d4,h1,h2};
		}
		else if (lot==t16) {
			return new Lot[]{f2,f4,g1,g3};
		}
		else if (lot==t17) {
			return new Lot[]{e3,e4,i1,i2};
		}
		else if (lot==t18) {
			return new Lot[]{g2,g4,h1,h3};
		}
		else if (lot==t20) {
			return new Lot[]{h2,h4};
		}
		else if (lot==t21) {
			return new Lot[]{g3,g4,k1,k2};
		}
		else if (lot==t22) {
			return new Lot[]{i1,i3};
		}
		else if (lot==t23) {
			return new Lot[]{h3,h4,l1,l2};
		}
		else if (lot==t24) {
			return new Lot[]{i2,i4,j1,j3};
		}
		else if (lot==t25) {
			return new Lot[]{i3,i4};
		}
		else if (lot==t26) {
			return new Lot[]{j2,j4,k1,k3};
		}
		else if (lot==t27) {
			return new Lot[]{j3,j4};
		}
		else if (lot==t28) {
			return new Lot[]{k2,k4,l1,l3};
		}
		else if (lot==t29) {
			return new Lot[]{k3,k4};
		}
		else if (lot==t30) {
			return new Lot[]{l2,l4};
		}
		else if (lot==t31) {
			return new Lot[]{l3,l4};
		}
		
		//wells and trenches
		else if (lot==w1) {
			return new Lot[]{t1,t2};
		}
		else if (lot==w2) {
			return new Lot[]{t1,t3,t4};
		}
		else if (lot==w3) {
			return new Lot[]{t3,t5,t6};
		}
		else if (lot==w4) {
			return new Lot[]{t5,t7,t8};
		}
		else if (lot==w5) {
			return new Lot[]{t7,t10};
		}
		else if (lot==w6) {
			return new Lot[]{t2,t9,t12};
		}
		else if (lot==w7) {
			return new Lot[]{t4,t9,t11,t14};
		}
		else if (lot==w8) {
			return new Lot[]{t6,t11,t13,t16};
		}
		else if (lot==w9) {
			return new Lot[]{t8,t13,t15,t18};
		}
		else if (lot==w10) {
			return new Lot[]{t10,t15,t20};
		}
		else if (lot==w11) {
			return new Lot[]{t12,t17,t22};
		}
		else if (lot==w12) {
			return new Lot[]{t14,t17,t19,t24};
		}
		else if (lot==w13) {
			return new Lot[]{t16,t19,t21,t26};
		}
		else if (lot==w14) {
			return new Lot[]{t18,t21,t23,t28};
		}
		else if (lot==w15) {
			return new Lot[]{t20,t23,t30};
		}
		else if (lot==w16) {
			return new Lot[]{t22,t25};
		}
		else if (lot==w17) {
			return new Lot[]{t24,t25,t27};
		}
		else if (lot==w18) {
			return new Lot[]{t26,t27,t29};
		}
		else if (lot==w19) {
			return new Lot[]{t28,t29,t31};
		}
		else if (lot==w20) {
			return new Lot[]{t30,t31};
		}
		
		//default
		else
			return new Lot[]{};
	}
	
	/*
	 * Returns the trenches associated with a well or another trench
	 */
	public Lot[] connectedTrenches (Lot lot) {
		
		//wells and trenches
		if (lot==w1) {
			return new Lot[]{t1,t2};
		}
		else if (lot==w2) {
			return new Lot[]{t1,t3,t4};
		}
		else if (lot==w3) {
			return new Lot[]{t3,t5,t6};
		}
		else if (lot==w4) {
			return new Lot[]{t5,t7,t8};
		}
		else if (lot==w5) {
			return new Lot[]{t7,t10};
		}
		else if (lot==w6) {
			return new Lot[]{t2,t9,t12};
		}
		else if (lot==w7) {
			return new Lot[]{t4,t9,t11,t14};
		}
		else if (lot==w8) {
			return new Lot[]{t6,t11,t13,t16};
		}
		else if (lot==w9) {
			return new Lot[]{t8,t13,t15,t18};
		}
		else if (lot==w10) {
			return new Lot[]{t10,t15,t20};
		}
		else if (lot==w11) {
			return new Lot[]{t12,t17,t22};
		}
		else if (lot==w12) {
			return new Lot[]{t14,t17,t19,t24};
		}
		else if (lot==w13) {
			return new Lot[]{t16,t19,t21,t26};
		}
		else if (lot==w14) {
			return new Lot[]{t18,t21,t23,t28};
		}
		else if (lot==w15) {
			return new Lot[]{t20,t23,t30};
		}
		else if (lot==w16) {
			return new Lot[]{t22,t25};
		}
		else if (lot==w17) {
			return new Lot[]{t24,t25,t27};
		}
		else if (lot==w18) {
			return new Lot[]{t26,t27,t29};
		}
		else if (lot==w19) {
			return new Lot[]{t28,t29,t31};
		}
		else if (lot==w20) {
			return new Lot[]{t30,t31};
		}
		
		//trenches and trenches
		else if (lot==t1) {
			return new Lot[]{t2,t3,t4};
		}
		else if (lot==t2) {
			return new Lot[]{t1,t9,t12};
		}
		else if (lot==t3) {
			return new Lot[]{t1,t4,t5,t6};
		}
		else if (lot==t4) {
			return new Lot[]{t1,t3,t9,t11,t14};
		}
		else if (lot==t5) {
			return new Lot[]{t3,t6,t7,t8};
		}
		else if (lot==t6) {
			return new Lot[]{t3,t5,t11,t13,t16};
		}
		else if (lot==t7) {
			return new Lot[]{t5,t8,t10};
		}
		else if (lot==t8) {
			return new Lot[]{t5,t7,t13,t15,t18};
		}
		else if (lot==t9) {
			return new Lot[]{t2,t4,t11,t12,t14};
		}
		else if (lot==t10) {
			return new Lot[]{t7,t15,t20};
		}
		else if (lot==t11) {
			return new Lot[]{t4,t6,t9,t13,t14,t16};
		}
		else if (lot==t12) {
			return new Lot[]{t2,t9,t17,t22};
		}
		else if (lot==t13) {
			return new Lot[]{t6,t8,t11,t15,t16,t18};
		}
		else if (lot==t14) {
			return new Lot[]{t4,t9,t11,t17,t19,t24};
		}
		else if (lot==t15) {
			return new Lot[]{t8,t10,t13,t18,t20};
		}
		else if (lot==t16) {
			return new Lot[]{t6,t11,t13,t19,t21,t26};
		}
		else if (lot==t17) {
			return new Lot[]{t12,t14,t19,t22,t24};
		}
		else if (lot==t18) {
			return new Lot[]{t8,t13,t15,t21,t23,t28};
		}
		else if (lot==t20) {
			return new Lot[]{t10,t15,t23,t30};
		}
		else if (lot==t21) {
			return new Lot[]{t16,t18,t19,t23,t26,t28};
		}
		else if (lot==t22) {
			return new Lot[]{t12,t17,t25};
		}
		else if (lot==t23) {
			return new Lot[]{t18,t20,t21,t28,t30};
		}
		else if (lot==t24) {
			return new Lot[]{t14,t17,t19,t25,t27};
		}
		else if (lot==t25) {
			return new Lot[]{t22,t24,t27};
		}
		else if (lot==t26) {
			return new Lot[]{t16,t19,t21,t27,t29};
		}
		else if (lot==t27) {
			return new Lot[]{t24,t25,t26,t29};
		}
		else if (lot==t28) {
			return new Lot[]{t18,t21,t23,t29,t31};
		}
		else if (lot==t29) {
			return new Lot[]{t26,t27,t28,t31};
		}
		else if (lot==t30) {
			return new Lot[]{t20,t23,t31};
		}
		else if (lot==t31) {
			return new Lot[]{t28,t29,t30};
		}
		
		//default
		else
			return new Lot[]{};
	}
	
	/*
	 * Irrigates a specific land, a specific well, or a trench with all the associated lands as well
	 */
	public void irrigate(Lot lot) {
		//look in trenches
		for(int i = 0; i < trenches.length; i++) {
			if(trenches[i]==lot){
				trenches[i].irrigate();
				irrigateLands(connectedLands(trenches[i]));
				return;
			}
		}
		
		//look in wells
		for(int i = 0; i < wells.length; i++) {
			if(wells[i]==lot){
				wells[i].irrigate();
				return;
			}
		}
		
		//look in lands
		for(int i = 0; i < lands.length; i++) {
			if(lands[i]==lot){
				lands[i].irrigate();
				return;
			}
		}
		
		//default
		return;
	}
	
	/*
	 * Looks for lands that are not being irrigated and reduces 1 worker for each
	 */
	public void reduceWorkersOverall() {
		for (int i = 0; i < lands.length; i++) {
			if(lands[i] instanceof Crop && !lands[i].isIrrigated){
				((Crop) lands[i]).reduceWorkers();
			}
		}
	}
	
	/*
	 * Adds crops to the board
	 */
	public void addCrop(Crop c, int pos){
		this.lands[pos]=c;
	}
	
	/*
	 * Returns the positions of unoccupied lands that are irrigated
	 */
	public List<Integer> checkIrrigatedFreeLands(){
		List<Integer> result = null;
		for(int i=0; i<lands.length; i++){
			if(lands[i] instanceof Crop && lands[i].isIrrigated){
				result.add(i);
			}
		}
		return result;
	}
	
	/*
	private List<List<Crop>> cropBoard;
	
	public Board(){
		cropBoard = new ArrayList<>();
		
	}
	*/
}
