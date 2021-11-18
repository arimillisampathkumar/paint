package edu.learn;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CanvasApp extends JPanel {
	static JFrame frame;

	
	public CanvasApp(Integer width, Integer height) {

		JFrame f = new JFrame("Paint App");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(width, height);
		//f.setPreferredSize(new Dimension(width, height));
		f.setAlwaysOnTop(true);
		f.setVisible(true);
		f.repaint();
		frame = f;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		CanvasApp currentCanvas = null;

		try (InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
				BufferedReader in = new BufferedReader(reader);) {
			String command;
			while ((command = in.readLine()) != null) {
				String[] commandArgs = command.split(" ");

				ArrayList<String> qCommands = new ArrayList<String>(Arrays.asList("C", "L", "R", "B", "Q"));

				if (commandArgs.length == 0 || !qCommands.contains(commandArgs[0])) {
					System.err.println("Invalid command " + command);
				}

				switch (commandArgs[0]) {
				case "C":
					currentCanvas = new CanvasApp(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]));
					currentCanvas.repaint();

					break;
				case "L":
					Line line = new Line(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]),
							Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
					if (null != currentCanvas)
						currentCanvas.execute(line);
					else
						System.err.println("create canvas first");

					break;
				case "R":
					Rectangle rectangle = new Rectangle(Integer.parseInt(commandArgs[1]),
							Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]),
							Integer.parseInt(commandArgs[4]));
					if (null != currentCanvas)
						currentCanvas.execute(rectangle);
					else
						System.err.println("create canvas first");
					break;
				case "B":
					Fill fill = new Fill(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]),
							getColor(commandArgs[3]));
					if (null != currentCanvas)
						currentCanvas.execute(fill);
					else
						System.err.println("create canvas first");

					break;
				case "Q":
					reader.close();
					in.close();
					System.exit(0);
					break;

				default:
					break;
				}

			}
		} catch (IOException e) {
			System.err.println("Unable to read Input ");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Invalid syntax. Refer to README file before using app ");
		}

	}

	private void execute(JPanel panel) {
		frame.getContentPane().add(panel);
		frame.repaint();
		repaint();
	}

	private static Color getColor(String color) {
		if ("black".equals(color)) {
			return Color.black;
		} else if ("BLACK".equals(color)) {
			return Color.BLACK;
		} else if ("blue".equals(color)) {
			return Color.blue;
		} else if ("BLUE".equals(color)) {
			return Color.BLUE;
		} else if ("cyan".equals(color)) {
			return Color.cyan;
		} else if ("CYAN".equals(color)) {
			return Color.CYAN;
		} else if ("DARK_GRAY".equals(color)) {
			return Color.DARK_GRAY;
		} else if ("darkGray".equals(color)) {
			return Color.darkGray;
		} else if ("gray".equals(color)) {
			return Color.gray;
		} else if ("GRAY".equals(color)) {
			return Color.GRAY;
		} else if ("green".equals(color)) {
			return Color.green;
		} else if ("GREEN".equals(color)) {
			return Color.GREEN;
		} else if ("LIGHT_GRAY".equals(color)) {
			return Color.LIGHT_GRAY;
		} else if ("lightGray".equals(color)) {
			return Color.lightGray;
		} else if ("magenta".equals(color)) {
			return Color.magenta;
		} else if ("MAGENTA".equals(color)) {
			return Color.MAGENTA;
		} else if ("orange".equals(color)) {
			return Color.orange;
		} else if ("ORANGE".equals(color)) {
			return Color.ORANGE;
		} else if ("pink".equals(color)) {
			return Color.pink;
		} else if ("PINK".equals(color)) {
			return Color.PINK;
		} else if ("red".equals(color)) {
			return Color.red;
		} else if ("RED".equals(color)) {
			return Color.RED;
		} else if ("white".equals(color)) {
			return Color.white;
		} else if ("WHITE".equals(color)) {
			return Color.WHITE;
		} else if ("yellow".equals(color)) {
			return Color.yellow;
		} else {
			return Color.YELLOW;
		}

	}
}
