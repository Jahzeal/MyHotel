package Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoomType {
    JPanel roomPanel1;
    RoomType(Image image1, int gridx, int gridy, int right, JPanel roomDetails){
        GridBagConstraints gbc = new GridBagConstraints();
        roomPanel1 = new JPanel();
        roomPanel1.setBackground(Color.white);
//        roomPanel1.setLayout(new GridLayout(2,1,3,3));
        roomPanel1.setBorder(new EmptyBorder(10,0,10,0));

        roomPanel1.setPreferredSize(new Dimension(200, 180));
        gbc.gridy = gridy;
        gbc.gridx = gridx;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(5,0,5,right);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomDetails.add(roomPanel1, gbc);


//        roomPanel1 top
        JLabel roomPanelImage = new JLabel(new ImageIcon(image1));
        roomPanel1.add(roomPanelImage, gbc);

        JPanel roomPanelBottom = new JPanel();
        roomPanelBottom.setBackground(Color.white);
        roomPanel1.setBorder(new EmptyBorder(0,0,10,0));
        roomPanelBottom.setPreferredSize(new Dimension(200, 60));
        roomPanelBottom.setLayout(new GridBagLayout());
        roomPanel1.add(roomPanelBottom);

        JLabel roomType = new JLabel("<html><strong>#Single Room</strong>  <br> A/C Kings</html>");
        roomType.setFont(new Font("Sans-serif", Font.PLAIN, 12));

        gbc.gridy= 0;
        gbc.gridx =0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.insets = new Insets(0,10,0,0);
        gbc.ipady =0;
        gbc.fill = GridBagConstraints.NONE;
        roomPanelBottom.add(roomType, gbc);

        JButton roomPanelButton = new JButton("$29/day");
        roomPanelButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        roomPanelButton.setFont(new Font("Sans-serif", Font.PLAIN, 12));
        roomPanelButton.setBackground(new Color(197, 157, 44));
        roomPanelButton.setForeground(Color.white);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.insets = new Insets(0,0,0,0);
        gbc.fill = GridBagConstraints.NONE;
        roomPanelButton.setPreferredSize(new Dimension(80,30));
        roomPanelBottom.add(roomPanelButton, gbc);
    }

    public void get(){}
}