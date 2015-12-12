package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Board {
	
	private Lot A11, A12, A21, A22,
	B11, B12, B21, B22,
	C11, C12, C21, C22,
	D11, D12, D21, D22,
	E11, E12, E21, E22,
	F11, F12, F21, F22,
	G11, G12, G21, G22,
	H11, H12, H21, H22,
	I11, I12, I21, I22,
	J11, J12, J21, J22,
	K11, K12, K21, K22,
	L11, L12, L21, L22,
	
	//Rivers
	R2, R4, R6,
	R1, R3, R5, R7,
	R8, R10, R12,
	R9, R11, R13, R15,
	R14, R16, R18,
	
	//Wells
	W1, W2, W3,
	W4, W5, W6;
	
	private Lot[] lands, rivers, wells;
	private Lot[][] regionA, regionB, regionC, regionD, regionE, regionF, regionG, regionH, regionI, regionJ, regionK, regionL;
	
	public Board() {
		initialize();
	}
	
	private void initialize() {
		//Lands
		A11 = new Lot();
		A12 = new Lot();
		A21 = new Lot();
		A22 = new Lot();
		B11 = new Lot();
		B12 = new Lot();
		B21 = new Lot();
		B22 = new Lot();
		C11 = new Lot();
		C12 = new Lot();
		C21 = new Lot();
		C22 = new Lot();
		D11 = new Lot();
		D12 = new Lot();
		D21 = new Lot();
		D22 = new Lot();
		E11 = new Lot();
		E12 = new Lot();
		E21 = new Lot();
		E22 = new Lot();
		F11 = new Lot();
		F12 = new Lot();
		F21 = new Lot();
		F22 = new Lot();
		G11 = new Lot();
		G12 = new Lot();
		G21 = new Lot();
		G22 = new Lot();
		H11 = new Lot();
		H12 = new Lot();
		H21 = new Lot();
		H22 = new Lot();
		I11 = new Lot();
		I12 = new Lot();
		I21 = new Lot();
		I22 = new Lot();
		J11 = new Lot();
		J12 = new Lot();
		J21 = new Lot();
		J22 = new Lot();
		K11 = new Lot();
		K12 = new Lot();
		K21 = new Lot();
		K22 = new Lot();
		L11 = new Lot();
		L12 = new Lot();
		L21 = new Lot();
		L22 = new Lot();
		
		lands = new Lot[]{A11,A12,A21,A22,
				B11,B12,B21,B22,
				C11,C12,C21,C22,
				D11,D12,D21,D22,
				E11,E12,E21,E22,
				F11,F12,F21,F22,
				G11,G12,G21,G22,
				H11,H12,H21,H22,
				I11,I12,I21,I22,
				J11,J12,J21,J22,
				K11,K12,K21,K22,
				L11,L12,L21,L22};
		
		//Rivers
		R1 = new Lot();
		R2 = new Lot();
		R3 = new Lot();
		R4 = new Lot();
		R5 = new Lot();
		R6 = new Lot();
		R7 = new Lot();
		R8 = new Lot();
		R9 = new Lot();
		R10 = new Lot();
		R11 = new Lot();
		R12 = new Lot();
		R13 = new Lot();
		R14 = new Lot();
		R15 = new Lot();
		R16 = new Lot();
		R18 = new Lot();
		
		rivers = new Lot[]{R2, R4, R6,
				R1, R3, R5, R7,
				R8, R10, R12,
				R9, R11, R13, R15,
				R14, R16, R18};
		
		//Wells
		W1 = new Lot();
		W2 = new Lot();
		W3 = new Lot();
		W4 = new Lot();
		W5 = new Lot();
		W6 = new Lot();
		
		wells = new Lot[]{W1, W2, W3,
				W4, W5, W6};
		
		/*
		 * Only keep the regions if they're useful for the GUI
		 */
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
	}
	
	private void irrigateConnectedLands(Lot lot) {
		if (lot==R1) {
			A21.irrigate();
			A22.irrigate();
			E11.irrigate();
			E12.irrigate();
		}
		else if (lot==R2) {
			A12.irrigate();
			A22.irrigate();
			B11.irrigate();
			B21.irrigate();
		}
		else if (lot==R3) {
			B21.irrigate();
			B22.irrigate();
			F11.irrigate();
			F12.irrigate();
		}
		else if (lot==R4) {
			B12.irrigate();
			B22.irrigate();
			C11.irrigate();
			C21.irrigate();
		}
		else if (lot==R5) {
			C21.irrigate();
			C22.irrigate();
			G11.irrigate();
			G12.irrigate();
		}
		else if (lot==R6) {
			C12.irrigate();
			C22.irrigate();
			D11.irrigate();
			D21.irrigate();
		}
		else if (lot==R7) {
			D21.irrigate();
			D22.irrigate();
			H11.irrigate();
			H12.irrigate();
		}
		else if (lot==R8) {
			E12.irrigate();
			E22.irrigate();
			F11.irrigate();
			F21.irrigate();
		}
		else if (lot==R9) {
			E21.irrigate();
			E22.irrigate();
			I11.irrigate();
			I12.irrigate();
		}
		else if (lot==R10) {
			F12.irrigate();
			F22.irrigate();
			G11.irrigate();
			G21.irrigate();
		}
		else if (lot==R11) {
			F21.irrigate();
			F22.irrigate();
			J11.irrigate();
			J12.irrigate();
		}
		else if (lot==R12) {
			G12.irrigate();
			G22.irrigate();
			H11.irrigate();
			H21.irrigate();
		}
		else if (lot==R13) {
			G21.irrigate();
			G22.irrigate();
			K11.irrigate();
			K12.irrigate();
		}
		else if (lot==R14) {
			I12.irrigate();
			I22.irrigate();
			J11.irrigate();
			J21.irrigate();
		}
		else if (lot==R15) {
			H21.irrigate();
			H22.irrigate();
			L11.irrigate();
			L12.irrigate();
		}
		else if (lot==R16) {
			J12.irrigate();
			J22.irrigate();
			K11.irrigate();
			K21.irrigate();
		}
		else if (lot==R18) {
			K12.irrigate();
			K22.irrigate();
			L11.irrigate();
			L21.irrigate();
		}
	}
	
	public void irrigate(Lot lot) {

		//look in rivers
		for(int i = 0; i < rivers.length; i++) {
			if(Arrays.asList(rivers).contains(lot)){
				rivers[i].irrigate();
				irrigateConnectedLands(rivers[i]);
				return;
			}
		}
		
		//look in wells
		for(int i = 0; i < wells.length; i++) {
			if(Arrays.asList(wells).contains(lot)){
				wells[i].irrigate();
				return;
			}
		}
		
		//look in lands
		for(int i = 0; i < lands.length; i++) {
			if(Arrays.asList(lands).contains(lot)){
				lands[i].irrigate();
				return;
			}
		}
	}
	
	/*
	private List<List<Crop>> cropBoard;
	
	public Board(){
		cropBoard = new ArrayList<>();
		
	}
	*/
}
