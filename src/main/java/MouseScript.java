import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

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

	// Prints out current mouse location and color as well as the 4 points used for determining the current screen.
	public static void getMouseDetails(Robot robot) {
		try {
			int LobbyColor = 0;
			int VictoryColor = 0;
			int ChampProgressColor = 0;
			int MilestoneProgressColor = 0;
			int MouseColor = 0;
			int x = 0;
			int y = 0;
			while(true) {
				x = (int)MouseInfo.getPointerInfo().getLocation().getX();
				y = (int)MouseInfo.getPointerInfo().getLocation().getY();

				LobbyColor = robot.getPixelColor(946, 118).getBlue();
				VictoryColor = robot.getPixelColor(960, 860).getBlue();
				ChampProgressColor = robot.getPixelColor(835, 660).getBlue();
				MilestoneProgressColor = robot.getPixelColor(960, 660).getBlue();
				MouseColor = robot.getPixelColor(x, y).getBlue();

				System.out.println("Mouse Position: (" + x + ", " + y + ")");
				System.out.println("Mouse Color: " + MouseColor);
				System.out.print("Lobby Color: " + LobbyColor);
				System.out.print(", Victory Color: " + VictoryColor);
				System.out.print(", Champ Progress Color: " + ChampProgressColor);
				System.out.println(", Milestone Progress Color: " + MilestoneProgressColor);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickAI(Robot robot) {
		try {
			int LobbyColor = 0;
			int VictoryColor = 0;
			int ChampProgressColor = 0;
			int MilestoneProgressColor = 0;
			int x = 0;
			int y = 0;
			while(true) {
				LobbyColor = robot.getPixelColor(946, 118).getBlue();
				VictoryColor = robot.getPixelColor(960, 860).getBlue();
				ChampProgressColor = robot.getPixelColor(835, 660).getBlue();
				MilestoneProgressColor = robot.getPixelColor(960, 660).getBlue();

				// Select random value in desired box and move cursor there
				if(LobbyColor == 11) { // Versus
					x = 800;
					y = 640;
					robot.mouseMove(x, y);
				} else if(LobbyColor == 148) { // Join Public Match
					x = 955; // randomRange(265, 275);
					y = 780; // randomRange(770, 780);
					robot.mouseMove(x, y);
				} else if(LobbyColor == 85) { // Champion Select
					x = 1045; // randomRange(360, 370);
					y = 840; // randomRange(835, 845);
					robot.mouseMove(x, y);
				} else if(ChampProgressColor == 107) { // Champion Progress and Milestone Rewards
					x = 960; // randomRange(265, 275);
					y = 725; // randomRange(725, 735);
					robot.mouseMove(x, y);
				} else if(MilestoneProgressColor == 55) { // Milestone Progress
					x = 960; // randomRange(270, 280);
					y = 675; // randomRange(675, 685);
					robot.mouseMove(x, y);
				} else if(LobbyColor == 56) { // Orc Select
					x = 1045; // randomRange(355, 365);
					y = 865; // randomRange(850, 860);
					robot.mouseMove(x, y);
				} else if(LobbyColor == 17) { // Defeat
					x = 955; // randomRange(270, 280);
					y = 955; // randomRange(955, 965);
					robot.mouseMove(x, y);
				} else if(VictoryColor == 57) { // Victory
					x = 960; // randomRange(270, 280);
					y = 875; // randomRange(875, 885);
					robot.mouseMove(x, y);
				} else if(LobbyColor != 49 && robot.getPixelColor(750, 990).getBlue() != 54) { // In-Game and Alive
					if (robot.getPixelColor(750, 990).getBlue() == 127) { // Revive P1
						x = 750;
						y = 975;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
						Thread.sleep(randomRange(500, 1000));
						x = 940;
						y = 850;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							Thread.sleep(300);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
					} else if(robot.getPixelColor(875, 990).getBlue() == 126) { // Revive P2
						x = 850;
						y = 990;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
						Thread.sleep(randomRange(500, 1000));
						x = 940;
						y = 850;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							Thread.sleep(300);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
					} else if(robot.getPixelColor(975, 990).getBlue() == 123) { // Revive P3
						x = 950;
						y = 975;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
						Thread.sleep(randomRange(500, 1000));
						x = 940;
						y = 850;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							Thread.sleep(300);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
					} else if(robot.getPixelColor(1075, 990).getBlue() == 118) { // Revive P4
						x = 1025;
						y = 975;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
						Thread.sleep(randomRange(500, 1000));
						x = 940;
						y = 850;
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							Thread.sleep(300);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
					} else {
						// Don't stand still!
//							Random r = new Random();
//							int rand = r.nextInt(4);
//							if (rand == 0) {
//								x = 260;
//								y = 555;
//							} else if (rand == 1) {
//								x = 200;
//								y = 450;
//							} else if (rand == 2) {
//								x = 350;
//								y = 450;
//							} else if (rand == 3) {
//								x = 200;
//								y = 650;
//							} else if (rand == 4) {
//								x = 350;
//								y = 650;
//							}
//							robot.mouseMove(x, y);
//							if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//								robot.mousePress(InputEvent.BUTTON1_MASK);
//								robot.mouseRelease(InputEvent.BUTTON1_MASK);
//							}
//							Thread.sleep(randomRange(500, 1000));
						x = 750; // randomRange(65, 75);
						y = 910; // randomRange(920, 930);
						robot.mouseMove(x, y);
						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 960) {
							robot.mousePress(InputEvent.BUTTON1_MASK);
							robot.mouseRelease(InputEvent.BUTTON1_MASK);
						}
						Thread.sleep(randomRange(500, 1000));
					}
				}
				// Left Click Here
				if((int)MouseInfo.getPointerInfo().getLocation().getX() > 700 && (int)MouseInfo.getPointerInfo().getLocation().getY() < 960) {
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
//					System.out.println("Clicked at (" + MouseInfo.getPointerInfo().getLocation().getX() + ", " + MouseInfo.getPointerInfo().getLocation().getY() + ")");
				}
				Thread.sleep(randomRange(500, 1000));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Gets random number within range min to max
	public static int randomRange(int min, int max) {
		if(min >= max) {
			return -1;
		}
		Random r = new Random();
		return r.nextInt(max - min + 1) + min;
	}
}