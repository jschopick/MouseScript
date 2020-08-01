import java.awt.*;
import java.awt.event.InputEvent;

// Mass for the Dead Mouse Script Desktop
public class MouseScript {

	public static void main(String[] args) {
		try {
			Robot robot =  new Robot();
			// Desktop Y Values are 25 more than Laptop. X Values are the same (1920x1080 vs 1920x1200)
			// Values are {Room 1, Room 2, Room 3, Room 4, Refresh Lobbies, Auto, Loading, Loss, Back}
			int[] LaptopY = {430, 565, 700, 830, 285, 200, 250, 753, 185};
			int[] DesktopY = {455, 590, 725, 855, 310, 225, 275, 770, 210};
			clickAI(robot, DesktopY);
//			clickAI(robot, LaptopY);
//			getMouseDetails(robot, DesktopY);
//			getMouseDetails(robot, LaptopY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Prints out current mouse location and color as well as the 4 points used for determining the current lobby.
	public static void getMouseDetails(Robot robot, int[] Y) {
		try {
			int[] Lobby = new int[4];
			int MouseColor = 0;
			int auto = 0;
			int x = 0;
			int y = 0;
			int StrengthenX = 568;
			int AbyssX = 565;
			int LimitX = 557;
			int EventX = 567;
			while(true) {
				// Mouse Information
				x = (int)MouseInfo.getPointerInfo().getLocation().getX();
				y = (int)MouseInfo.getPointerInfo().getLocation().getY();
				MouseColor = robot.getPixelColor(x, y).getBlue();
				System.out.println("Color: " + MouseColor + " | Pos: (" + x + ", " + y + ")");

				x = EventX;
				Lobby[0] = robot.getPixelColor(x, Y[0]).getBlue();
				Lobby[1] = robot.getPixelColor(x, Y[1]).getBlue();
				Lobby[2] = robot.getPixelColor(x, Y[2]).getBlue();
				Lobby[3] = robot.getPixelColor(x, Y[3]).getBlue();

//				for(int i = 0; i < 4; i++) {
//					System.out.println("Lobby " + i + " Color: " + Lobby[i]);
//				}
//				auto = robot.getPixelColor(1461, 200).getBlue();
//				System.out.println("Auto: " + auto + ")");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Moves the mouse to desired location and clicks
	public static void click(Robot robot, int x, int y) {
		try {
			// Mouse overshoots so let it center before clicking
			robot.mouseMove(x, y);
			robot.mouseMove(x, y + 1);
			robot.mouseMove(x, y);

			// Hold button for 300ms before releasing
			robot.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(300);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(1100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickAI(Robot robot, int[] Y) {
		try {
			Thread.sleep(5000);
			int[] StrengthLobby = new int[4];
			int[] LimitLobby = new int[4];
			int[] EventLobby = new int[4];
			int[] AbyssLobby = new int[4];
			int[] Refresh = {1262, Y[4], 0}; // {x, y, color}
			int white = 255;
			int loading = 1;
			int auto = 0;
			int loss = 0;
			int back = 0;
			int StrengthenX = 568;
			int AbyssX = 565;
			int LimitBreakX = 557;
			int EventX = 567;

			int x = LimitBreakX;
			while(true) {
				// Initialize Variables
				StrengthLobby[0] = robot.getPixelColor(StrengthenX, Y[0]).getBlue();
				StrengthLobby[1] = robot.getPixelColor(StrengthenX, Y[1]).getBlue();
				StrengthLobby[2] = robot.getPixelColor(StrengthenX, Y[2]).getBlue();
				StrengthLobby[3] = robot.getPixelColor(StrengthenX, Y[3]).getBlue();

				AbyssLobby[0] = robot.getPixelColor(AbyssX, Y[0]).getBlue();
				AbyssLobby[1] = robot.getPixelColor(AbyssX, Y[1]).getBlue();
				AbyssLobby[2] = robot.getPixelColor(AbyssX, Y[2]).getBlue();
				AbyssLobby[3] = robot.getPixelColor(AbyssX, Y[3]).getBlue();

				LimitLobby[0] = robot.getPixelColor(LimitBreakX, Y[0]).getBlue();
				LimitLobby[1] = robot.getPixelColor(LimitBreakX, Y[1]).getBlue();
				LimitLobby[2] = robot.getPixelColor(LimitBreakX, Y[2]).getBlue();
				LimitLobby[3] = robot.getPixelColor(LimitBreakX, Y[3]).getBlue();

				EventLobby[0] = robot.getPixelColor(EventX, Y[0]).getBlue();
				EventLobby[1] = robot.getPixelColor(EventX, Y[1]).getBlue();
				EventLobby[2] = robot.getPixelColor(EventX, Y[2]).getBlue();
				EventLobby[3] = robot.getPixelColor(EventX, Y[3]).getBlue();

				Refresh[2] = robot.getPixelColor(1262, 285).getBlue();
				auto = robot.getPixelColor(1461, Y[5]).getBlue();
				back = robot.getPixelColor(370, Y[8]).getBlue();
				loading = robot.getPixelColor(1500, Y[6]).getBlue();
				loss = robot.getPixelColor(1030, Y[7]).getBlue();

				// In Battle
				if (back != 27 && auto < 100) { // Enable Auto Battle if Disabled
					click(robot, 1461, Y[5]);
				} else if(auto >= 150 || loading == 0) { // Pause 5 seconds to allow time to close script
					Thread.sleep(5000);
				}

				// If we lose, don't revive.
				if(loss == 77) {
					click(robot, 856, Y[7] - 10);
				}

				// Click on a lobby if it is Konosuba Event
				if ((LimitLobby[0] == white && EventLobby[0] == white) || LimitLobby[0] == white || StrengthLobby[0] == white || AbyssLobby[0] == white) {
					click(robot, 700, Y[0]);
				}
				if ((LimitLobby[1] == white && EventLobby[1] == white) || LimitLobby[1] == white || StrengthLobby[1] == white || AbyssLobby[1] == white) {
					click(robot, 700, Y[1]);
				}
				if ((LimitLobby[2] == white && EventLobby[2] == white) || LimitLobby[2] == white || StrengthLobby[2] == white || AbyssLobby[2] == white) {
					click(robot, 700, Y[2]);
				}
				if ((LimitLobby[3] == white && EventLobby[3] == white) || LimitLobby[3] == white || StrengthLobby[3] == white || AbyssLobby[3] == white) {
					click(robot, 700, Y[3]);
				}

				// Refresh
				click(robot, Refresh[0], Refresh[1]);
				Thread.sleep(800);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}