import java.awt.*;
import java.awt.event.InputEvent;

// Mass for the Dead Mouse Script
public class MouseScript {

	public static void main(String[] args) {
		try {
			Robot robot =  new Robot();
//			getMouseDetails(robot);
			clickAI(robot);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Prints out current mouse location and color as well as the 4 points used for determining the current lobby.
	public static void getMouseDetails(Robot robot) {
		try {
			int[] Lobby = new int[4];
			int MouseColor = 0;
			int auto = 0;
			int x = 0;
			int y = 0;
			int strengthenX = 568;
			int abyssX = 565;
			int EventLimitX = 557;
			int EventKonosubaX = 567;
			while(true) {
				// Mouse Information
				x = (int)MouseInfo.getPointerInfo().getLocation().getX();
				y = (int)MouseInfo.getPointerInfo().getLocation().getY();
				MouseColor = robot.getPixelColor(x, y).getBlue();
				System.out.println("Color: " + MouseColor + " | Pos: (" + x + ", " + y + ")");

				x = EventLimitX;
				Lobby[0] = robot.getPixelColor(x, 430).getBlue();
				Lobby[1] = robot.getPixelColor(x, 565).getBlue();
				Lobby[2] = robot.getPixelColor(x, 700).getBlue();
				Lobby[3] = robot.getPixelColor(x, 830).getBlue();
				System.out.println(Lobby[0]);
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

	public static void clickAI(Robot robot) {
		try {
			Thread.sleep(5000);
			int[] StrengthLobby = new int[4];
			int[] EventLimitLobby = new int[4];
			int[] EventKonosubaLobby = new int[4];
			int[] AbyssLobby = new int[4];
			int[] Refresh = {1262, 285, 0}; // {x, y, color}
			int white = 255;
			int loading = 1;
			int auto = 0;
			int loss = 0;
			int strengthenX = 568;
			int abyssX = 565;
			int EventLimitBreakX = 557;
			int EventKonosubaX = 567;

			int x = EventLimitBreakX;
			while(true) {
				// Initialize Variables
				StrengthLobby[0] = robot.getPixelColor(strengthenX, 430).getBlue();
				StrengthLobby[1] = robot.getPixelColor(strengthenX, 565).getBlue();
				StrengthLobby[2] = robot.getPixelColor(strengthenX, 700).getBlue();
				StrengthLobby[3] = robot.getPixelColor(strengthenX, 830).getBlue();

				AbyssLobby[0] = robot.getPixelColor(abyssX, 430).getBlue();
				AbyssLobby[1] = robot.getPixelColor(abyssX, 565).getBlue();
				AbyssLobby[2] = robot.getPixelColor(abyssX, 700).getBlue();
				AbyssLobby[3] = robot.getPixelColor(abyssX, 830).getBlue();

				EventLimitLobby[0] = robot.getPixelColor(EventLimitBreakX, 430).getBlue();
				EventLimitLobby[1] = robot.getPixelColor(EventLimitBreakX, 565).getBlue();
				EventLimitLobby[2] = robot.getPixelColor(EventLimitBreakX, 700).getBlue();
				EventLimitLobby[3] = robot.getPixelColor(EventLimitBreakX, 830).getBlue();

				EventKonosubaLobby[0] = robot.getPixelColor(EventKonosubaX, 430).getBlue();
				EventKonosubaLobby[1] = robot.getPixelColor(EventKonosubaX, 565).getBlue();
				EventKonosubaLobby[2] = robot.getPixelColor(EventKonosubaX, 700).getBlue();
				EventKonosubaLobby[3] = robot.getPixelColor(EventKonosubaX, 830).getBlue();

				Refresh[2] = robot.getPixelColor(1262, 285).getBlue();
				auto = robot.getPixelColor(1461, 200).getBlue();
				loading = robot.getPixelColor(1500, 250).getBlue();
				loss = robot.getPixelColor(1030, 753).getBlue();

				// In Battle
				if (auto < 100 && auto != 24) { // Enable Auto Battle if Disabled
					click(robot, 1461, 200);
				} else if(auto >= 150 || loading == 0) { // Pause 5 seconds to allow time to close script
					Thread.sleep(5000);
				}

				// If we lose, don't revive.
				if(loss == 77) {
					click(robot, 856, 743);
				}

				// Click on a lobby if it is Konosuba Event or allLobbies is true
				if ((EventLimitLobby[0] == white && EventKonosubaLobby[0] == white) || StrengthLobby[0] == white || AbyssLobby[0] == white) {
					click(robot, 700, 400);
				}
				if ((EventLimitLobby[1] == white && EventKonosubaLobby[1] == white) || StrengthLobby[1] == white || AbyssLobby[1] == white) {
					click(robot, 700, 530);
				}
				if ((EventLimitLobby[2] == white && EventKonosubaLobby[2] == white) || StrengthLobby[2] == white || AbyssLobby[2] == white) {
					click(robot, 700, 670);
				}
				if ((EventLimitLobby[3] == white && EventKonosubaLobby[3] == white) || StrengthLobby[3] == white || AbyssLobby[3] == white) {
					click(robot, 700, 800);
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