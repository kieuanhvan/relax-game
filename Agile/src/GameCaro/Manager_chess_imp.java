package GameCaro;


import Streamer.PlayerCaro;
import GameCaro.ManagerChess;
import GameCaro.Info_Chess;
import Streamer.InfoTable;
import home_game.loginFrm;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author kieu anh văn
 */
public class Manager_chess_imp implements ManagerChess {
    private JPanel panel, panelIcon;
    private JTextField PlayerName;
    private JLabel PlayerImage, point, labelTime;
    public int point1, point2;
    public int checkclick_stop = -1;
    public boolean isdelay ;
    private CaroFrm maingame;
    
    private ArrayList<PlayerCaro> players;
    private ArrayList<ArrayList<JToggleButton>> matrix;
    private String FileName  = "List_table_game.dat";

    private void getInfoTable() {
        //String id, PlayerCaro players1, PlayerCaro players2, int number_played, int time_playing
        InfoTable table = new InfoTable(maingame.playerGame.getFullName(),players.get(0),players.get(1),
        0,0);
    }
    
    private enum PlayerAction {
        player_one(0), player_two(1);
        private int value;

        private PlayerAction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private int player;

    public Manager_chess_imp() {
        
    }

    public Manager_chess_imp(CaroFrm maingame) {
        this.maingame  = maingame;
        player = PlayerAction.player_two.getValue();
        this.panel = maingame.getPnlCaro();
        this.PlayerName = maingame.getTxtName();
        this.PlayerImage = maingame.getLabelImge();
        this.point = maingame.getLabel_point();
        players = new ArrayList<>();
        point1 = point2 = 0;
        default_player();
       
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelIcon() {
        return panelIcon;
    }

    public void setPanelIcon(JPanel panelIcon) {
        this.panelIcon = panelIcon;
    }

    public JTextField getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(JTextField PlayerName) {
        this.PlayerName = PlayerName;
    }

    public JLabel getPlayerImage() {
        return PlayerImage;
    }

    public void setPlayerImage(JLabel PlayerImage) {
        this.PlayerImage = PlayerImage;
    }

    public JLabel getPoint() {
        return point;
    }

    public void setPoint(JLabel point) {
        this.point = point;
    }

    public JLabel getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(JLabel labelTime) {
        this.labelTime = labelTime;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public ArrayList<PlayerCaro> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerCaro> players) {
        this.players = players;
    }

    public ArrayList<ArrayList<JToggleButton>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<JToggleButton>> matrix) {
        this.matrix = matrix;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public CaroFrm getMaingame() {
        return maingame;
    }

    public void setMaingame(CaroFrm maingame) {
        this.maingame = maingame;
    }
    
    public void default_player() {
        players.add(new PlayerCaro(maingame.playerGame.getFullName(),"player1",
                new ImageIcon("src\\images\\icons8-o-30.png"), point1));
        
        players.add(new PlayerCaro(maingame.playerGame.getFullName(),"player2",
                new ImageIcon("src\\images\\icons8-x-30.png"), point2));
        
        PlayerName.setText(players.get(player).getName().toUpperCase());
        PlayerImage.setIcon(resizeImge(players.get(player).getIcon()));
        showPoint();
    }

    public void showPoint() {
        
        point.setText(players.get(0).getPoint() + " : " + players.get(1).getPoint());
    }

    public ImageIcon resizeImge(ImageIcon icon) {
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(PlayerImage.getWidth(),
                PlayerImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageNew = new ImageIcon(newImage);
        return imageNew;
    }

    @Override
    public void drawTableChess() {
        JToggleButton oldButton = new JToggleButton();
        oldButton.setLocation(0, 0);
        oldButton.setSize(0, Info_Chess.CHESS_HEIGHT);
        matrix = new ArrayList<ArrayList<JToggleButton>>();
        for (int i = 0; i < Info_Chess.CHESS_BOARD_HEIGHT; i++) {
            matrix.add(new ArrayList<JToggleButton>()); // tao ra hang moi
            for (int j = 0; j < Info_Chess.CHESS_BOARD_WIDTH; j++) {

                JToggleButton btn = new JToggleButton();
                btn.setSize(Info_Chess.CHESS_WIDTH, Info_Chess.CHESS_HEIGHT);
                btn.setLocation(oldButton.getWidth() + oldButton.getX(), oldButton.getY());
                btn.setBackground(Color.WHITE);

                btn.setName(String.valueOf(i)); // lay vi tri cua hang

                addACtionListnerClick(btn);
                addMouseListener_hover(btn);
                panel.add(btn);
                matrix.get(i).add(btn);

                oldButton = btn;
            }
            oldButton.setLocation(0, oldButton.getY() + Info_Chess.CHESS_HEIGHT);
            oldButton.setSize(0, 0);
        }
    }
    public Thread_time thread;

    @Override
    public void timePlayer(JPanel panelIcon) {
        this.panelIcon = panelIcon;
        this.thread = new Thread_time(this);
        thread.start();
    }

    private void addACtionListnerClick(JToggleButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn.getIcon() != null) {
                    return;
                }
                checkclick_stop = 1;
                changerLayer(btn);
                if (isEndGame(btn)) {
                    endGame();
                }
            }
        });
    }

    private void addMouseListener_hover(JToggleButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent event) {
                btn.setBackground(Color.lightGray);
            }

            public void mouseExited(MouseEvent event) {
                btn.setBackground(Color.WHITE);
            }
        });
    }

    private void changerLayer(JToggleButton btn) {
        btn.setIcon(players.get(player).getIcon());
        player = player == 0 ? PlayerAction.player_two.getValue()
                : PlayerAction.player_one.getValue();
        btn.setEnabled(true);
        default_player();
    }

    private boolean isEndGame(JToggleButton button) {
        return isEndGameHorizontal(button) || isEndGameVertical(button)
                || isEndGameDiagonal_primary(button) || isEndGameDiagonal_foreign(button);
    }

    private Point getLocationButton(JToggleButton button) {
        int vertical = Integer.valueOf(button.getName()); // tra ve vi tri hang doc
        int horizontal = matrix.get(vertical).indexOf(button);// tra ve vi tri hang ngang chieu ngang
        Point point = new Point(horizontal, vertical);
        return point;
    }

    private boolean isEndGameHorizontal(JToggleButton button) {
        //thuật toán từ vị trí của btn  , ta đếm xem bên trái và bên phải có bao nhiêu thằng giống nó
        Point point = getLocationButton(button);
        int countLeft = 0;
        for (int i = (int) point.getX(); i >= 0; i--) { // diem từ index sang trái;
            if (matrix.get((int) point.getY()).get(i).getIcon() == button.getIcon()) {
                countLeft++;
            } else {
                break;
            }
        }
        int countRight = 0;
        // cùng một điểm nếu ko cộng một thì sẽ đếm hai lần 
        for (int i = (int) point.getX() + 1; i < Info_Chess.CHESS_BOARD_WIDTH; i++) { // diem từ index sang phai;
            if (matrix.get((int) point.getY()).get(i).getIcon() == button.getIcon()) {
                countRight++;
            } else {
                break;
            }

        }

        return countLeft + countRight == 5;
    }

    private boolean isEndGameVertical(JToggleButton button) {
        Point point = getLocationButton(button);
        int countUp = 0;
        for (int i = (int) point.getY(); i >= 0; i--) {
            if (matrix.get(i).get((int) point.getX()).getIcon() == button.getIcon()) {
                countUp++;
            } else {
                break;
            }
        }

        int countDown = 0;
        for (int i = (int) point.getY() + 1; i < Info_Chess.CHESS_BOARD_HEIGHT; i++) {
            if (matrix.get(i).get((int) point.getX()).getIcon() == button.getIcon()) {
                countDown++;
            } else {
                break;
            }
        }
        return countDown + countUp == 5;
    }

    private boolean isEndGameDiagonal_primary(JToggleButton button) {
        Point point = getLocationButton(button);
        int countTop = 0;
        for (int i = 0; i <= (int) point.getX(); i++) { // diem từ index sang trái;
            if ((int) point.getX() - i < 0 || (int) point.getY() - i < 0) {
                break;
            }
            if (matrix.get((int) point.getY() - i).get((int) point.getX() - i).getIcon() == button.getIcon()) {
                countTop++;
            } else {
                break;
            }
        }
        int countBottom = 0;
        // cùng một điểm nếu ko cộng một thì sẽ đếm hai lần 
        for (int i = 1; i < Info_Chess.CHESS_BOARD_WIDTH - (int) point.getX(); i++) { // diem từ index sang phai;
            if ((int) point.getX() + i >= Info_Chess.CHESS_BOARD_WIDTH
                    || (int) point.getY() + i >= Info_Chess.CHESS_BOARD_HEIGHT) {
                break;
            }
            if (matrix.get((int) point.getY() + i).get((int) point.getX() + i).getIcon() == button.getIcon()) {
                countBottom++;
            } else {
                break;
            }

        }

        return countTop + countBottom == 5;
    }

    private boolean isEndGameDiagonal_foreign(JToggleButton button) {
        Point point = getLocationButton(button);
        int countTop = 0;
        for (int i = 0; i <= (Info_Chess.CHESS_BOARD_WIDTH - (int) point.getX()); i++) {
            if ((int) point.getY() - i < 0 || (int) point.getX() + i >= Info_Chess.CHESS_BOARD_WIDTH) {
                break;
            }
            if (matrix.get((int) point.getY() - i).get((int) point.getX() + i).getIcon() == button.getIcon()) {
                countTop++;
            } else {
                break;
            }
        }

        int countBottom = 0;
        for (int i = 1; i <= Info_Chess.CHESS_BOARD_WIDTH - (int) point.getX(); i++) {
            if ((int) point.getY() + i >= Info_Chess.CHESS_BOARD_HEIGHT
                    || (int) point.getX() - i < 0) {
                break;
            }
            if (matrix.get((int) point.getY() + i).get((int) point.getX() - i).getIcon() == button.getIcon()) {
                countBottom++;
            } else {
                break;
            }
        }

        return countBottom + countTop == 5;
    }

    private void endGame() {
        if (JOptionPane.showConfirmDialog(panel, "ket thuc game!!!!") == JOptionPane.OK_OPTION) {
                changePointPlayer();
        }
    }

    public void changePointPlayer() {
        players.get(player).setPoint((player == 0 ? point1 : point2) + 1);
        point1 = players.get(0).getPoint();
        point2 = players.get(1).getPoint();
        showPoint();
        clearData();
    }

    public void clearData() {
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).clear();
        }
        matrix.clear();
        for (Component item : panel.getComponents()) {
            if (item instanceof JToggleButton) {
                panel.remove(item);
            }
        }
        panel.revalidate();
        panel.repaint();
        drawTableChess();
    }
    public void getIsdelay(boolean  isdelay){
        this.isdelay = isdelay;
    }
    public void ChangeNamePlayers(ChangeNamePlayer changeName){
        this.isdelay = maingame.isdelay;
        changeName.getNamePlayers(players.get(0), players.get(1), this);
        changeName.setVisible(true);
    }
    
    public void WriteDataToFile() {
        getInfoTable();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ListFile/" + FileName))) {
            oos.writeObject(players);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(loginFrm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(loginFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
