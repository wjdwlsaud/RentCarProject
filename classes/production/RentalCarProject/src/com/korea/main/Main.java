package com.korea.main;

import com.korea.TUI.Viewer;
import com.korea.view.MainGUI;

public class Main
{
    public static void main(String[] args)
    {
//        MainGUI main = new MainGUI();
//        main.run();
        Viewer view = new Viewer();
        view.MainMenu();
    }
}