package GameCaro;


import Streamer.PlayerCaro;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public interface ManagerChess {
    void drawTableChess();
    void timePlayer(JPanel panelIcon );
    default boolean checkWinUser(PlayerCaro player){
        return false;
    }
    default boolean countdown(Timer time){
        return false;
    }
    default boolean changeIconUser(ImageIcon image){
        return false;
    }
    default String showMessage(String str){
       return str;
    }
    default boolean changeNameUser(String oldName){
        return false;
    }
}
