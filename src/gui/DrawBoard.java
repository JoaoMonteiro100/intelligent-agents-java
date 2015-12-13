package gui;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

public class DrawBoard {

    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] landsA = new JButton[8][6];
    private JPanel board;

    DrawBoard() {
        initializeGui();
    }

    public final void initializeGui() {
        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(new JButton("New")); // TODO - add functionality!
        tools.addSeparator();

        board = new JPanel(new GridLayout(0, 14));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        // create the lands
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int ii = 0; ii < landsA.length; ii++) {
            for (int jj = 0; jj < landsA[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(60, 80, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                b.setBackground(Color.LIGHT_GRAY);
                landsA[ii][jj] = b;
            }
        }

        //fill the board
        board.add(new JLabel(""));
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 6; jj++) {
                switch (jj) {
                    case 0:
                        board.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                    default:
                        board.add(landsA[ii][jj]);
                }
            }
        }
    }

    public final JComponent getBoard() {
        return board;
    }

    public final JComponent getGui() {
        return gui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
            	DrawBoard cb =
                        new DrawBoard();

                JFrame f = new JFrame("ChessChamp");
                f.add(cb.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}