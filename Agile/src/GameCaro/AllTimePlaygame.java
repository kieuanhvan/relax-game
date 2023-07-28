
package GameCaro;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author kieu anh văn
 */
public class AllTimePlaygame extends Thread{
    private JLabel time;
    private int number;
    public AllTimePlaygame( JLabel time){
        number = 0;
        this.time = time;
    }
    @Override
    public void run() {
        while (true) {            
            try {
                Thread.sleep(1000);
                number++;
            } catch (InterruptedException ex) {
                Logger.getLogger(AllTimePlaygame.class.getName()).log(Level.SEVERE, null, ex);
            }
            time.setText(String.valueOf(number));
        }
    }
    
}
