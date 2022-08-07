import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


import gui.*;
public class Game {
	
	public static int randomNum() {
		int min=1;
		int max=9;
		int num=(int)Math.floor(Math.random()*(max-min+1)+min);
		return num;
	}
	
	
	public static int[] playerSetting() {
		int[] playerSettingArr=new int[2];
		ImageIcon img =new ImageIcon("src/Football_Icon.PNG");
		try {
			GUI_Game dialog = new GUI_Game();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setIconImage(img.getImage());
			dialog.setVisible(true);
			if(dialog.getDirection().equals("L")) {
				playerSettingArr[0]=1;
			} else if(dialog.getDirection().equals("M")) {
				playerSettingArr[0]=2;
			} else {
				playerSettingArr[0]=3;
			}
			
			if(!dialog.getStrength().isBlank()) {
			playerSettingArr[1]=Integer.parseInt(dialog.getStrength());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playerSettingArr;
	}
	
	
	public static boolean playMatch(int playerdirec,int playerspeed,int playerstrength, Defender defender) {
		/*first place keeper on field*/
		int defenderpos=0;
		if(defender.getPosition()==Position.LEFT) {
			defenderpos=1;
		} else if(defender.getPosition()==Position.MIDDLE) {
			defenderpos=2;
		} else {
			defenderpos=3;
		}
		
		/*check if keeper placed in players way*/
		if(playerdirec==defenderpos || playerspeed<=defender.getSpeed()) {
			if(playerstrength<=defender.getEndurance()) {
				return false;
			} else {
				return true;
			}
		} else {
			/*how much speed does the defender lose*/
			if(defenderpos<playerdirec) {
				if(defender.getSpeed()-((playerdirec-defenderpos)*2)<=0) {
					defender.setSpeed(1);
				} else {
					defender.setSpeed(defender.getSpeed()-((playerdirec-defenderpos)*2));
				}
			} else {
				if(defender.getSpeed()-((defenderpos-playerdirec)*2)<=0) {
					defender.setSpeed(1);
				} else {
					defender.setSpeed(defender.getSpeed()-((defenderpos-playerdirec)*2));
				}
			}
			
			/*check if defense is fast enough to stop player*/
			if(playerspeed<=defender.getSpeed()) {
				if(playerstrength>defender.getEndurance()) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}
	
	public static void main(String [] args) {
		
		boolean win=false;
		boolean con=true;
		ImageIcon img =new ImageIcon("src/Football_Icon.PNG");
		
		try {
			GUI_Rules dialog = new GUI_Rules();
			dialog.setIconImage(img.getImage());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(con) {
			
			int defenderwins=0;
			int playerwins=0;
	
			while(playerwins<5 && defenderwins<5) {
				
				/*Keeper gets set*/
				Defender defender=new Defender(randomNum(),randomNum(),randomNum());
				
				/*Player-Stats get set*/
				int [] inputarr=playerSetting();
				if(inputarr==null) {
					System.exit(0);
				}
				int speed=randomNum()-(int)(Math.round(0.5*inputarr[1]));
				if(speed<=0) {
					speed=1;
				}
				
				win=playMatch(inputarr[0],speed,inputarr[1],defender);
				
				/*give point to winner*/
				if(win) {
					playerwins++;
					JOptionPane.showMessageDialog(null, "GOOOOAAAAAL! \n Playerwins/Defenderwins: "+playerwins+" : "+defenderwins );
				} else {
					defenderwins++;
					JOptionPane.showMessageDialog(null, "STOPPED BY DEFENSE... \n Playerwins/Defenderwins: "+playerwins+" : "+defenderwins );
				}
			}
			
			if(playerwins>defenderwins) {
				JOptionPane.showMessageDialog(null, "CONGRATS!!! YOU WON!!!");
			} else {
				JOptionPane.showMessageDialog(null, "GAME OVER! YOU LOST...");
			}
			
			//Continue Anfrage und Schleife, falls falsche Eingabe erfolgt ist//
			try {
				GUI_LastWindow dialog = new GUI_LastWindow();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setIconImage(img.getImage());
				dialog.setVisible(true);
				con=dialog.getContinue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}			
}
