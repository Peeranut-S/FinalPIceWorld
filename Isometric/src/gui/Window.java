package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
        
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private GameCanvas canvas = null;
        
        private final int HEIGHT = 1000;
        private final int WIDTH = 1000;
        private final String TITLE = "IceWorld";
        
        private JPanel jMain = null;

        public Window() {
                setup();
                addItems();
        }
        
        private void setup() {
                setTitle(TITLE);
                setVisible(true);
                setSize(WIDTH, HEIGHT);
                setResizable(false);
                setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setIgnoreRepaint(true);
                setContentPane(getMain());
        }
        
        private JPanel getMain() {
                if (jMain == null) {
                        jMain = new JPanel(true);
                        jMain.setLayout(new BorderLayout());
                }
                return jMain;
        }
        
        private void addItems() {
                getMain().add(getCanvas());
                getMain().validate();
                pack();
        }
        
        private GameCanvas getCanvas() {
                if (canvas == null) {
                        canvas = new GameCanvas();
                }
                return canvas;
        }
}
