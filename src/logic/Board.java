package logic;

public class Board {
	private Land A11, A12, A21, A22, B11, B12, B21, B22, C11, C12, C21, C22, D11, D12, D21, D22, E11, E12, E21, E22, F11, F12, F21, F22, G11, G12, G21, G22, H11, H12, H21, H22, I11, I12, I21, I22, J11, J12, J21, J22, K11, K12, K21, K22, L11, L12, L21, L22;
	private Land[][] regionA, regionB, regionC, regionD, regionE, regionF, regionG, regionH, regionI, regionJ, regionK, regionL;
	private Land[][][] map;
	
	public Board() {
		initialize();
	}
	
	private void initialize() {
		A11 = new Land();
		A12 = new Land();
		A21 = new Land();
		A22 = new Land();
		B11 = new Land();
		B12 = new Land();
		B21 = new Land();
		B22 = new Land();
		C11 = new Land();
		C12 = new Land();
		C21 = new Land();
		C22 = new Land();
		D11 = new Land();
		D12 = new Land();
		D21 = new Land();
		D22 = new Land();
		E11 = new Land();
		E12 = new Land();
		E21 = new Land();
		E22 = new Land();
		F11 = new Land();
		F12 = new Land();
		F21 = new Land();
		F22 = new Land();
		G11 = new Land();
		G12 = new Land();
		G21 = new Land();
		G22 = new Land();
		H11 = new Land();
		H12 = new Land();
		H21 = new Land();
		H22 = new Land();
		I11 = new Land();
		I12 = new Land();
		I21 = new Land();
		I22 = new Land();
		J11 = new Land();
		J12 = new Land();
		J21 = new Land();
		J22 = new Land();
		K11 = new Land();
		K12 = new Land();
		K21 = new Land();
		K22 = new Land();
		L11 = new Land();
		L12 = new Land();
		L21 = new Land();
		L22 = new Land();
		
		regionA = new Land[][]{{A11,A12},{A21,A22}};
		regionB = new Land[][]{{B11,B12},{B21,B22}};
		regionC = new Land[][]{{C11,C12},{C21,C22}};
		regionD = new Land[][]{{D11,D12},{D21,D22}};
		regionE = new Land[][]{{E11,E12},{E21,E22}};
		regionF = new Land[][]{{F11,F12},{F21,F22}};
		regionG = new Land[][]{{G11,G12},{G21,G22}};
		regionH = new Land[][]{{H11,H12},{H21,H22}};
		regionI = new Land[][]{{I11,I12},{I21,I22}};
		regionJ = new Land[][]{{J11,J12},{J21,J22}};
		regionK = new Land[][]{{K11,K12},{K21,K22}};
		regionL = new Land[][]{{L11,L12},{L21,L22}};
		
		map = new Land[][][]{regionA, regionB, regionC, regionD, regionE, regionF, regionG, regionH, regionI, regionJ, regionK, regionL};
		
		/*
		 * MISSING EDGES (IRRIGATIONS)
		 * AND INTERSECTIONS (WELLS)
		 */
	}
}
