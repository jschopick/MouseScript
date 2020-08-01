//import java.awt.*;
//import java.awt.event.InputEvent;
//import java.util.Random;
//
//public class SOW_MouseScript {
//
//	public static void main(String[] args) {
//		try {
//			Robot robot =  new Robot();
////			getMouseDetails(robot);
//			clickAI(robot);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Prints out current mouse location and color as well as the 4 points used for determining the current screen.
//	public static void getMouseDetails(Robot robot) {
//		try {
//			int LobbyColor = 0;
//			int VictoryColor = 0;
//			int ChampProgressColor = 0;
//			int MilestoneProgressColor = 0;
//			int DisbandedColor = 0;
//			int MouseColor = 0;
//			int x = 0;
//			int y = 0;
//			while(true) {
//				x = (int)MouseInfo.getPointerInfo().getLocation().getX();
//				y = (int)MouseInfo.getPointerInfo().getLocation().getY();
//
//				LobbyColor = robot.getPixelColor(946, 118).getBlue();
//				VictoryColor = robot.getPixelColor(960, 860).getBlue();
//				ChampProgressColor = robot.getPixelColor(835, 660).getBlue();
//				MilestoneProgressColor = robot.getPixelColor(960, 660).getBlue();
//				DisbandedColor = robot.getPixelColor(960, 655).getBlue();
//				MouseColor = robot.getPixelColor(x, y).getBlue();
//
//				System.out.println("Mouse Position: (" + x + ", " + y + ")");
//				System.out.println("Mouse Color: " + MouseColor);
//				System.out.print("Lobby Color: " + LobbyColor);
//				System.out.print(", Victory Color: " + VictoryColor);
//				System.out.print(", Champ Progress Color: " + ChampProgressColor);
//				System.out.print(", Milestone Progress Color: " + MilestoneProgressColor);
//				System.out.println(", Disbanded Color: " + DisbandedColor);
//				Thread.sleep(1000);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void clickAI(Robot robot) {
//		try {
//			int LobbyColor = 0;
//			int VictoryColor = 0;
//			int ChampProgressColor = 0;
//			int MilestoneProgressColor = 0;
//			int DisbandedColor = 0;
//			int stuckCount = -2; // Click away if stuck on milestone rewards
//			int inGameCount = -2; // Emote every 15 counts in-game
//			int x = 0;
//			int y = 0;
//
//			while(true) {
////				System.out.println("Stuck: " + stuckCount);
////				System.out.println("In Game: " + inGameCount);
//
//				LobbyColor = robot.getPixelColor(946, 118).getBlue();
//				VictoryColor = robot.getPixelColor(960, 860).getBlue();
//				ChampProgressColor = robot.getPixelColor(835, 660).getBlue();
//				MilestoneProgressColor = robot.getPixelColor(960, 660).getBlue();
//				DisbandedColor = robot.getPixelColor(960, 655).getBlue();
//
//				// Select random value in desired box and move cursor there
//				if(ChampProgressColor == 107 || ChampProgressColor == 106) { // Champion Progress and Milestone Rewards
//					x = 960;
//					y = 725;
//					robot.mouseMove(x, y);
//					if(stuckCount % 5 == 0) { // Emote
//						x = 1100;
//						y = 955;
//						robot.mouseMove(x, y);
//						robot.mousePress(InputEvent.BUTTON1_MASK);
//						robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						x = 960;
//						y = 750;
//						robot.mouseMove(x, y);
//						robot.mousePress(InputEvent.BUTTON1_MASK);
//						robot.mouseRelease(InputEvent.BUTTON1_MASK);
//					}
//					stuckCount++;
//				} else
//				if(MilestoneProgressColor == 55 || MilestoneProgressColor == 102) { // Milestone Progress
//					x = 960;
//					y = 690;
//					robot.mouseMove(x, y);
//					if(stuckCount % 40 == 0) { // Emote
//						x = 1100;
//						y = 955;
//						robot.mouseMove(x, y);
//						robot.mousePress(InputEvent.BUTTON1_MASK);
//						robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						x = 960;
//						y = 710;
//						robot.mouseMove(x, y);
//						robot.mousePress(InputEvent.BUTTON1_MASK);
//						robot.mouseRelease(InputEvent.BUTTON1_MASK);
//					}
//					stuckCount++;
//				} else if(VictoryColor == 212){ // Stuck in victory screen
//					x = 960;
//					y = 400;
//					robot.mouseMove(x, y);
//				} else if(VictoryColor == 57 || VictoryColor == 58) { // Victory
//					x = 960;
//					y = 875;
//					robot.mouseMove(x, y);
//				}
////				else if(DisbandedColor == 211) {
////					x = 950;
////					y = 600;
////					robot.mouseMove(x, y);
////					robot.mousePress(InputEvent.BUTTON1_MASK);
////					robot.mouseRelease(InputEvent.BUTTON1_MASK);
////					Thread.sleep(1000);
////					x = 965;
////					y = 665;
////					robot.mouseMove(x, y);
////				}
//				else if(LobbyColor == 11) { // Versus
//					x = 800;
//					y = 640;
//					robot.mouseMove(x, y);
//				} else if(LobbyColor == 148) { // (46) Join Public Match
//					x = 955;
//					y = 780;
//					robot.mouseMove(x, y);
//				} else if(LobbyColor == 85) { // 70 || LobbyColor == 71) { // (85) Champion Select
//					x = 1045;
//					y = 840;
//					robot.mouseMove(x, y);
//				} else if(LobbyColor == 56) { // 48 || LobbyColor == 47) { // (56) Orc Select
//					x = 1045;
//					y = 865;
//					robot.mouseMove(x, y);
//					inGameCount = -2;
//				} else if(LobbyColor == 17) { // Defeat
//					x = 955;
//					y = 955;
//					robot.mouseMove(x, y);
//				} else if(LobbyColor != 49) { // In-Game
//					stuckCount = -2;
//
////					if(inGameCount == -1) { // Happy
////						x = 1100;
////						y = 955;
////						robot.mouseMove(x, y);
////						robot.mousePress(InputEvent.BUTTON1_MASK);
////						robot.mouseRelease(InputEvent.BUTTON1_MASK);
////						Thread.sleep(300);
////
////						x = 1180;
////						y = 520;
////						robot.mouseMove(x, y);
////						robot.mousePress(InputEvent.BUTTON1_MASK);
////						robot.mouseRelease(InputEvent.BUTTON1_MASK);
////					}
////					if(inGameCount % 15 == 0) { // Sad
////						x = 1100;
////						y = 955;
////						robot.mouseMove(x, y);
////						robot.mousePress(InputEvent.BUTTON1_MASK);
////						robot.mouseRelease(InputEvent.BUTTON1_MASK);
////						Thread.sleep(300);
////
////						x = 1180;
////						y = 575; // 520 - Happy
////						robot.mouseMove(x, y);
////						robot.mousePress(InputEvent.BUTTON1_MASK);
////						robot.mouseRelease(InputEvent.BUTTON1_MASK);
////					}
//
//					if (robot.getPixelColor(750, 990).getBlue() == 127) { // Revive P1
//						x = 750;
//						y = 975;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//						Thread.sleep(randomRange(100, 200));
//						x = 940;
//						y = 850;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							Thread.sleep(300);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//					} else if(robot.getPixelColor(875, 990).getBlue() == 126) { // Revive P2
//						x = 860;
//						y = 970;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//						Thread.sleep(randomRange(100, 200));
//						x = 940;
//						y = 850;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							Thread.sleep(300);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//					} else if(robot.getPixelColor(975, 990).getBlue() == 123) { // Revive P3
//						x = 950;
//						y = 970;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//						Thread.sleep(randomRange(100, 200));
//						x = 940;
//						y = 850;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							Thread.sleep(300);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//					} else if(robot.getPixelColor(1075, 990).getBlue() == 118) { // Revive P4
//						x = 1025;
//						y = 970;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//						Thread.sleep(randomRange(100, 200));
//						x = 940;
//						y = 850;
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							Thread.sleep(300);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
//					}
//
//					else if(robot.getPixelColor(750, 990).getBlue() != 54){ // Only click if alive
//						// Don't stand still!
////							Random r = new Random();
////							int rand = r.nextInt(4);
////							if (rand == 0) {
////								x = 260;
////								y = 555;
////							} else if (rand == 1) {
////								x = 200;
////								y = 450;
////							} else if (rand == 2) {
////								x = 350;
////								y = 450;
////							} else if (rand == 3) {
////								x = 200;
////								y = 650;
////							} else if (rand == 4) {
////								x = 350;
////								y = 650;
////							}
////							robot.mouseMove(x, y);
////							if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 1020) {
////								robot.mousePress(InputEvent.BUTTON1_MASK);
////								robot.mouseRelease(InputEvent.BUTTON1_MASK);
////							}
////							Thread.sleep(randomRange(500, 1000));
//						x = 750; // randomRange(65, 75);
//						y = 910; // randomRange(920, 930);
//						robot.mouseMove(x, y);
//						if ((int) MouseInfo.getPointerInfo().getLocation().getY() < 960) {
//							robot.mousePress(InputEvent.BUTTON1_MASK);
//							robot.mouseRelease(InputEvent.BUTTON1_MASK);
//						}
////						Thread.sleep(randomRange(1000, 3000)); // pve
//						Thread.sleep(randomRange(500, 1000)); // pvp
//					}
//					inGameCount++;
//				}
//				// Left Click Here
//				if((int)MouseInfo.getPointerInfo().getLocation().getX() > 700 && (int)MouseInfo.getPointerInfo().getLocation().getX() < 1240 && (int)MouseInfo.getPointerInfo().getLocation().getY() < 960) {
//					robot.mousePress(InputEvent.BUTTON1_MASK);
//					robot.mouseRelease(InputEvent.BUTTON1_MASK);
//				}
//				Thread.sleep(randomRange(500, 1000));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Gets random number within range min to max
//	public static int randomRange(int min, int max) {
//		if(min >= max) {
//			return -1;
//		}
//		Random r = new Random();
//		return r.nextInt(max - min + 1) + min;
//	}
//}