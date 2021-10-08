package com.company.UI;

import com.company.Characters.Hero;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {

    private Hero mainHero;

    private void LoadFrameSettings(){
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("D:\\Works\\Java\\Practic2\\src\\main\\java\\com\\company\\Icons\\logo.png");
        setIconImage(img.getImage());
        setTitle("MIREA Hero");
    }

    private void SetButtonFont(JButton btn){
        btn.setFont(new Font(Font.DIALOG, Font.PLAIN, 45));
        btn.setFocusPainted(false);
    }

    private void SetUI(
            JButton HeroInfoBtn, JButton GoFightingBtn, JButton GoShopBtn, JButton GoSettingBtn, JLabel MenuLabel
    ){
        // Label "STAR MENU"
        MenuLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 45));
        MenuLabel.setForeground(Color.WHITE);

        // BUTTONS
        HeroInfoBtn.setBackground(new Color(141, 255, 224));
        GoFightingBtn.setBackground(new Color(255, 179, 179));
        GoShopBtn.setBackground(new Color(143, 255, 143));
        GoSettingBtn.setBackground(new Color(255, 221, 104));

        // Buttons Font
        SetButtonFont(HeroInfoBtn);
        SetButtonFont(GoFightingBtn);
        SetButtonFont(GoShopBtn);
        SetButtonFont(GoSettingBtn);

        // Layout format
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 3));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,4));
        panel.setBackground(new Color(12,167,137));

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5,1,0,55));
        gridPanel.setBackground(new Color(12,167,137));

        gridPanel.add(MenuLabel);
        gridPanel.add(HeroInfoBtn);
        gridPanel.add(GoFightingBtn);
        gridPanel.add(GoShopBtn);
        gridPanel.add(GoSettingBtn);

        panel.add(gridPanel);

        // Add all to main window
        add(panel);
    }

    public void LoadMenu(){
        JButton HeroInfoBtn = new JButton("HERO INFO");
        JButton GoFightingBtn = new JButton("GO FIGHTING");
        JButton GoShopBtn = new JButton("GO SHOP");
        JButton GoSettingBtn = new JButton("GO SETTINGS");
        JLabel MenuLabel = new JLabel("START MENU");

        SetUI(HeroInfoBtn, GoFightingBtn, GoShopBtn, GoSettingBtn, MenuLabel);

        ActionListener reDirectAction = new HeroInfoClickListener();

        HeroInfoBtn.setActionCommand("1. User wants to look at his Hero Information");
        HeroInfoBtn.addActionListener(reDirectAction);

        GoFightingBtn.setActionCommand("2. User wants to go to the Fighting Ring");
        GoFightingBtn.addActionListener(reDirectAction);

        GoShopBtn.setActionCommand("3. User wants to go to the Game Shop");
        GoShopBtn.addActionListener(reDirectAction);

        GoSettingBtn.setActionCommand("4. User wants to go to the Settings");
        GoSettingBtn.addActionListener(reDirectAction);


        setVisible(true);
    }

    public void LoadInfo(){
        getContentPane().removeAll();
        repaint();
    }

    public void LoadFighting(){}

    public void LoadShop(){}

    public void LoadSettings(){}

    public MainApp(){
        this.mainHero = new Hero("Untitled");
        LoadFrameSettings();


    }


    public class HeroInfoClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand().charAt(0));
            switch (e.getActionCommand().charAt(0)) {
                case '1' -> LoadInfo();
                case '2' -> LoadFighting();
                case '3' -> LoadShop();
                case '4' -> LoadSettings();
            }
        }
    }



}
