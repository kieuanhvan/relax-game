package GameCaro;

import GameCaro.Manager_chess_imp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kieu anh văn
 */
public class Thread_time extends Thread {

    Manager_chess_imp managerment;
    private JPanel panelIcon;
    private int endtime;
    private boolean isdelay, IsEnabled;

    public Thread_time(Manager_chess_imp managerment) {
        endtime = 0;
        this.managerment = managerment;

    }

    @Override
    public void run() {
        this.panelIcon = managerment.getPanelIcon();
        while (true) {
            coutnDown();
            if (this.endtime == 1) {
                this.endtime = 0;
                delete_itemJlabel1();
                try {
                    Thread.sleep(500);
                    managerment.changePointPlayer();
                    managerment.setPlayer(managerment.getPlayer() == 1 ? 0 : 1);
                    managerment.default_player();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread_time.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void delete_itemJlabel1() {
        for (Component item : panelIcon.getComponents()) {
            if (item instanceof JLabel) {
                panelIcon.remove(item);
            }
        }

        panelIcon.revalidate();
        panelIcon.repaint();
    }

    private void coutnDown() {
        for (int i = 0; i < 4; i++) {
            if (managerment.checkclick_stop == 1) {
                managerment.checkclick_stop = 0;
                break;
            }

            for (int j = 0; j < 300; j++) {
                if (i == 3 && j >= 295) {
                    this.endtime = 1;
                }
                JLabel label = new JLabel();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread_time.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (managerment.checkclick_stop == 1) {
                    delete_itemJlabel1();
                    break;
                }

                label.setBackground(Color.red);
                label.setOpaque(true);
                label.setSize(10, 10);
                panelIcon.add(label);
                if (i == 0) {
                    if (j >= panelIcon.getWidth() - 10) {
                        break;
                    }
                    label.setLocation(j, 0);
                }
                if (i == 1) {
                    label.setLocation(panelIcon.getWidth() - label.getWidth(), j - label.getWidth() * 2 - label.getHeight());
                }
                if (i == 2) {
                    if (j > 265) {
                        j += 10;
                    }
                    label.setLocation(panelIcon.getHeight() - label.getWidth() - j, panelIcon.getHeight() - label.getWidth());
                }
                if (i == 3) {
                    if (j > 250) {
                        j += 10;
                    }
                    label.setLocation(0, panelIcon.getHeight() - j - 2);
                }
                isdelay = this.managerment.isdelay;
                while (isdelay == true) {
                    isdelay = this.managerment.isdelay;
                    changeDisPlay();
                }
                changeDisPlay();
            }
        }
    }

    public void changeDisPlay() {
        this.IsEnabled = managerment.getMaingame().IsEnabled;
        if (this.IsEnabled == true) {
            for (int i = 0; i < Info_Chess.CHESS_BOARD_HEIGHT; i++) {
                for (int j = 0; j < Info_Chess.CHESS_BOARD_WIDTH; j++) {
                    managerment.getMatrix().get(i).get(j).setEnabled(false);
                }
            }
        } else {
            try {
                for (int i = 0; i < Info_Chess.CHESS_BOARD_HEIGHT; i++) {
                    for (int j = 0; j < Info_Chess.CHESS_BOARD_WIDTH; j++) {
                        managerment.getMatrix().get(i).get(j).setEnabled(true);
                    }
                }
            } catch (Exception e) {
                return;
            }

        }
    }
}
