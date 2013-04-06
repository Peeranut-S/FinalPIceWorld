import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//Still require to guarantee that it will be off after it called the new iceWorld

public class splashScr {

    private static class FadingPanel extends JPanel {
        private BufferedImage buffer;
        private boolean isFading = false;
        private long start;
        private float alpha = 1.0f;

     private   FadingPanel(){
    	 setPreferredSize(new Dimension(430,433));
        	
        }
        @Override
        public void paint(Graphics g) {
            if (isFading) {// During fading, we prevent child components from being painted
                g.clearRect(0, 0, getWidth(), getHeight());
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                g.drawImage(buffer, 0, 0, this);// We only draw an image of them with an alpha
            } else {
                super.paint(g);
            }
        }

        public void fade(int time) {
            start = System.currentTimeMillis();
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            this.print(buffer.getGraphics());// Draw the current components on the buffer
            isFading = true;
            final int timeInMillis = time * 1000;
            final Timer t = new Timer(50, null);
            t.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    long elapsed = System.currentTimeMillis() - start;
                    if (elapsed > timeInMillis) {
                        start = 0;
                        isFading = false;
                        buffer = null;
                        repaint();
                        t.stop();
                    } else {
                        alpha = 1.0f - (float) elapsed / timeInMillis;
                        repaint();
                    }
                }
            });
            t.start();
        }
    }

    protected void initUI() throws MalformedURLException {
        JWindow frame = new JWindow();
 
        final FadingPanel panel = new FadingPanel();
        
        JLabel image = new JLabel(new ImageIcon("/Users/ZethaRia/Desktop/201448_BNX1G_1000_001_web_full.jpg"));
       

          
        panel.add(image);
        
        frame.add(panel);
        frame.setSize(430, 433);
        frame.setVisible(true);
        panel.fade(5);
        
       
    }
    
   
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new splashScr().initUI();
                    
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
      
    }

}