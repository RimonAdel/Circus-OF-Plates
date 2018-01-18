package eg.edu.alexu.csd.oop.game.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import eg.edu.alexu.csd.oop.game.world.Circuis;

public class Main {

	public static void main(String[] args) {
		System.out.println("Uncomment any of the lines in the Main to run a new game, Have Fun :)");
int level = 0;

		JMenuBar menuBar = new JMenuBar();
		;
		JMenu menu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem pauseMenuItem = new JMenuItem("Pause");
		JMenuItem resumeMenuItem = new JMenuItem("Resume");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		menu.add(newMenuItem);
		menu.add(exitMenuItem);
		menu.addSeparator();
		menu.add(pauseMenuItem);
		menu.add(resumeMenuItem);
		menuBar.add(menu);
		Object[] possibilities = { "easy", "medium", "hard" };
		 JFrame frame = new JFrame("InputDialog Example #1");
		String s = (String) JOptionPane.showInputDialog(frame, "select one choice \n" ,	"choose difficulty ", JOptionPane.PLAIN_MESSAGE, null, possibilities, null);
		if(s.equals("easy")){
			level=1;
		}
		else if(s.equals("medium")){
			level=2;
		}
		else if(s.equals("hard")){
			level=3;
		}
		final GameController gameController = GameEngine.start("Very Simple Game in 99 Line of Code",
				Circuis.getinstance(level), menuBar, Color.orange);


		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pauseMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.pause();
			}
		});
		resumeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameController.resume();
			}
		});
	}

}
