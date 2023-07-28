package MenuGame;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 *
 * @author kieu anh văn
 */
public class BannerGame {

    private menuHome home;
    JPanel pnlBannerContainer, pnlConrolRadio;
    ArrayList<String> listBannerADS;
    int numberOfBanner;
    String pathArchive = "src\\images\\bannerImageIcon";
    Timer t;
    CardLayout controlLayout;
    ActionListener ac;
    JRadioButton[] rdoss;
    ButtonGroup bg = new ButtonGroup();

    public BannerGame(menuHome home) {
        this.home = home;
        pnlBannerContainer = home.getPnlContainerBanner();
        pnlConrolRadio = home.getPnlRadioChoose();
        pnlConrolRadio.setLayout(new FlowLayout(JLabel.LEFT));
        listBannerADS = getBanner(pathArchive);
        /*----------------------------------------------------------*/
        rdoss = new JRadioButton[numberOfBanner];
        createActionListner();
        createBanners();

        t = new Timer(2000, ac);
        t.start();
        controlLayout = (CardLayout) pnlBannerContainer.getLayout();
        rdoss[0].setSelected(true);
        loadbanner();
    }

    private void createBanners() {
        System.out.println(numberOfBanner);
        pnlBannerContainer.setLayout(new CardLayout());
        for (int i = 0; i < numberOfBanner; i++) {
            ImageIcon icon = new ImageIcon(pathArchive + "\\" + listBannerADS.get(i));
            JPanel pnl = new JPanel(new GridLayout(1, 1));
            JLabel labelImg = new JLabel();
            labelImg.setSize(600, 300);
            labelImg.setIcon(getIcon(pathArchive + "\\" + listBannerADS.get(i), labelImg));
            pnl.add(labelImg);
            rdoss[i] = new JRadioButton();
            addRdossMouseClicked(rdoss[i]);
            bg.add(rdoss[i]);
            pnlConrolRadio.add(rdoss[i]);
            pnlBannerContainer.add(pnl, String.valueOf(i));
        }

    }

    public ImageIcon resizeImge(String path, JLabel label) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageNew = new ImageIcon(newImage);
        return imageNew;
    }

    private ArrayList<String> getBanner(String path) {
        ArrayList<String> ads = new ArrayList<>();
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                int lastindex = file.getName().lastIndexOf(".");
                String name = file.getName().substring(lastindex, file.getName().length());
                if (name.compareTo(".jpg") == 0 || name.compareTo(".png") == 0) {
                    ads.add(file.getName());
                }
            }
        }
        numberOfBanner = ads.size();
        return ads;
    }

    private Icon getIcon(String string, JLabel labelImg) {
        return resizeImge(string, labelImg);
    }

    public void controlNextBanner() {
        controlLayout.next(pnlBannerContainer);
    }

    private void createActionListner() {
        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlNextBanner();
                control_RadioButtons_According_banner();

            }

            private void control_RadioButtons_According_banner() {
                JPanel pnlSelected = null;
                int indexSelected = 0;
                Component[] components = pnlBannerContainer.getComponents();
                for (int i = 0; i < components.length; i++) {
                    if (components[i] instanceof JPanel) {
                        if (components[i].isVisible() == true) {
                            indexSelected = i;
                            break;
                        }
                    }
                }
                rdoss[indexSelected].setSelected(true);
            }

        };
    }

    private int getIndexRadioSelected() {
        for (int i = 0; i < rdoss.length; i++) {
            if (rdoss[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }

    private void control_banner_According_Radio() {
        int index = getIndexRadioSelected();
        controlLayout.show(pnlBannerContainer, String.valueOf(index));
    }

    private void addRdossMouseClicked(JRadioButton rdos) {
        rdos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                control_banner_According_Radio();
            }

        });
    }

    private void loadbanner() {
        home.getLabelBaner().setIcon(resizeImge("src\\images\\images_banner.jpg", home.getLabelBaner()));
    }
}
