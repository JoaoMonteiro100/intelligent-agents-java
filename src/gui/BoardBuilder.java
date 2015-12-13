package gui;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class BoardBuilder {
	private static JButton[] lands = new JButton[48];
    private static JButton[] horTrenches = new JButton[16];
    private static JButton[] verTrenches = new JButton[15];
    private static JButton[] wells = new JButton[20];

    public static void addComponentsToPane(Container pane) {
	    pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	    pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(1,1,1,1);
		c.gridwidth = c.RELATIVE;
	
	    //create the lands
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < lands.length; ii++) {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(60, 80, BufferedImage.TYPE_INT_ARGB));
            b.setIcon(icon);
            b.setBackground(Color.LIGHT_GRAY);
            lands[ii] = b;
        }
        
        //create the horizontal trenches
        for (int ii = 0; ii < horTrenches.length; ii++) {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(60, 25, BufferedImage.TYPE_INT_ARGB));
            b.setIcon(icon);
            b.setBackground(Color.MAGENTA);
            horTrenches[ii] = b;
        }
        
        //create the vertical trenches
        for (int ii = 0; ii < verTrenches.length; ii++) {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(25, 80, BufferedImage.TYPE_INT_ARGB));
            b.setIcon(icon);
            b.setBackground(Color.BLUE);
            verTrenches[ii] = b;
        }
        
        //create the wells
        for (int ii = 0; ii < wells.length; ii++) {
            JButton b = new JButton();
            b.setMargin(buttonMargin);
            ImageIcon icon = new ImageIcon(
                    new BufferedImage(25, 25, BufferedImage.TYPE_INT_ARGB));
            b.setIcon(icon);
            b.setBackground(Color.ORANGE);
            wells[ii] = b;
        }

        //fill the board
        pane.add(new JLabel(""));
        int w=0, ht=0, vt=0, l=0, hBuff=0, vBuff=0;
        for (int ii = 0; ii < 99; ii++) {
            if(ii<9 || (29<ii && ii<39) || (59<ii && ii<69) || 89<ii){
            	if(ii==0){ //first cell, a well
            		c.weightx = 1;
            		c.weighty = 1;
            		c.fill = GridBagConstraints.HORIZONTAL;
            		//c.anchor = GridBagConstraints.FIRST_LINE_START;
            		c.gridx = 0;
            		c.gridy = vBuff;
            		c.gridwidth = 1;
            		c.gridheight = 1;
            		pane.add(wells[w],c);
            		w++;
            		hBuff++;
            	}
            	else if (ii==30 || ii==60 || ii==90){ //first in a new line, a well
            		hBuff=0;
            		vBuff+=4;
            		c.fill = GridBagConstraints.HORIZONTAL;
            		c.anchor = GridBagConstraints.LINE_START;
            		c.anchor = GridBagConstraints.WEST;
            		c.gridx = hBuff;
            		c.gridy = vBuff;
            		c.gridwidth = 1;
            		c.gridheight = 1;
            		wells[w].setBackground(Color.GREEN);
            		pane.add(wells[w],c);
            		w++;
            		hBuff++;
            	}
            	else if (ii % 2 == 0){ //if it's an even number, a well
            		c.fill = GridBagConstraints.HORIZONTAL;
            		c.gridx = hBuff;
            		c.gridy = vBuff;
            		c.gridwidth = 1;
            		c.gridheight = 1;
            		wells[w].setBackground(Color.CYAN);
            		pane.add(wells[w],c);
            		w++;
            		hBuff++;
            	}
            	else { //horizontal trenches
            		c.fill = GridBagConstraints.HORIZONTAL;
            		c.gridx = hBuff;
            		c.gridy = vBuff;
            		c.gridwidth = 4;
            		c.gridheight = 1;
            		pane.add(horTrenches[ht],c);
            		ht++;
            		hBuff+=4;
            	}
            }
            else if (ii==9 || ii==39 || ii==69){ //first in a new line, a vertical trench
        		vBuff+=4;
        		hBuff=0;
        		c.fill = GridBagConstraints.VERTICAL;
        		c.gridx = hBuff;
        		c.gridy = vBuff;
        		c.gridwidth = 1;
        		c.gridheight = 4;
        		pane.add(verTrenches[vt],c);
        		vt++;
        		hBuff++;
        	}
        	else { //4 lands of the same region + a vertical trench
        		c.fill = GridBagConstraints.VERTICAL;
        		c.gridx = hBuff;
        		c.gridy = vBuff;
        		c.gridwidth = 2;
        		c.gridheight = 2;
        		pane.add(lands[l],c);
        		c.gridx = hBuff+2;
        		pane.add(lands[l+1],c);
        		c.gridx = hBuff;
        		c.gridy = vBuff+2;
        		pane.add(lands[l+2],c);
        		c.gridx = hBuff+2;
        		pane.add(lands[l+3],c);
        		l+=4;
        		c.gridx = hBuff+4;
        		c.gridy = vBuff;
        		c.gridwidth = 1;
        		c.gridheight = 4;
        		pane.add(verTrenches[vt],c);
        		vt++;
        		hBuff+=5;
        		ii+=5;
        	}
        }
    }
    
    private static void createAndShowGUI() {
        //create and set up the window
        JFrame frame = new JFrame("Santiago");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //set up the content pane
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        addComponentsToPane(frame.getContentPane());

        //display the window
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}