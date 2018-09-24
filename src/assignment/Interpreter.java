package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */
public class Interpreter implements CritterInterpreter {

	public void executeCritter(Critter c) {
		
		Random rand = new Random();
		@SuppressWarnings("unchecked")
		ArrayList<String> commands = (ArrayList)c.getCode();
		
		for (int i = 0; i < commands.size(); i ++) {
			
			String[] commandList = commands.get(i).split(" ");
			String command = commandList[0];
			
			if (command.equals("hop")) {
				c.hop();
			}
			if (command.equals("left")) {
				c.left();
			}
			if (command.equals("right")) {
				c.right();
			}
			if (command.equals("infect")) {
				if (c.getCellContent(Critter.FRONT) == Critter.ENEMY) {
					c.infect();
				}
			}
			if (command.equals("eat")) {
				if (c.getCellContent(Critter.FRONT) == Critter.ENEMY) {
					c.eat();
				}
			}
			if (command.equals("write")) {
				int r = Integer.parseInt(commandList[1]);
				int v = Integer.parseInt(commandList[2]);
				c.setReg(r, v);
			}
			if (command.equals("add")) {
				int r1 = Integer.parseInt(commandList[1]);
				int r2 = Integer.parseInt(commandList[2]);
				c.setReg(r1, c.getReg(r1) + c.getReg(r2));
			}
			if (command.equals("sub")) {
				int r1 = Integer.parseInt(commandList[1]);
				int r2 = Integer.parseInt(commandList[2]);
				c.setReg(r1, c.getReg(r1) - c.getReg(r2));
			}
			if (command.equals("inc")) {
				int r = Integer.parseInt(commandList[1]);
				c.setReg(r, c.getReg(r) + 1);
			}
			if (command.equals("dec")) {
				int r = Integer.parseInt(commandList[1]);
				c.setReg(r, c.getReg(r) - 1);
			}
			
			//****SECTION INCOMPLETE****
			if (command.equals("go")) {
				String n = commandList[1];
				
				//jump to nth
			}
			if (command.equals("ifrandom")) {
				int randNum = rand.nextInt(2);
				int n = Integer.parseInt(commandList[1]);
				if (randNum == 0) {
					c.setNextCodeLine(n);
				}
				
			}
			if (command.equals("ifhungry")) {
				if (c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
					//jump to nth
				}
			}
			if (command.equals("ifstarving")) {
				if (c.getHungerLevel() == Critter.HungerLevel.STARVING) {
					//jump to nth
				}
			}
			if (command.equals("ifempty")) {
				int bearing = Integer.parseInt(commandList[1]);
				int n = Integer.parseInt(commandList[2]);
				if (c.getCellContent(bearing) == Critter.EMPTY) {
					//jump to nth
				}
			}
			if (command.equals("ifally")) {
				int bearing = Integer.parseInt(commandList[1]);
				int n = Integer.parseInt(commandList[2]);
				if (c.getCellContent(bearing) == Critter.ALLY) {
					//jump to nth
				}
			}
			if (command.equals("ifenemy")) {
				int bearing = Integer.parseInt(commandList[1]);
				int n = Integer.parseInt(commandList[2]);
				if (c.getCellContent(bearing) == Critter.ENEMY) {
					//jump to nth
				}
			}
			if (command.equals("ifwall")) {
				int bearing = Integer.parseInt(commandList[1]);
				int n = Integer.parseInt(commandList[2]);
				if (c.getCellContent(bearing) == Critter.WALL) {
					//jump to nth
				}
			}
			if (command.equals("ifangle")) {
				int b1 = Integer.parseInt(commandList[1]);
				int b2 = Integer.parseInt(commandList[2]);
				int n = Integer.parseInt(commandList[2]);
				
				//check conditional and jump to nth
			}
			if (command.equals("iflt")) {
				int r1 = Integer.parseInt(commandList[1]);
				int r2 = Integer.parseInt(commandList[2]);
				
				if (c.getReg(r1) < c.getReg(r2)) {
					//jump to nth
				}
			}
			if (command.equals("ifgt")) {
				int r1 = Integer.parseInt(commandList[1]);
				int r2 = Integer.parseInt(commandList[2]);
				
				if (c.getReg(r1) > c.getReg(r2)) {
					//jump to nth
				}
			}
			if (command.equals("ifeq")) {
				int r1 = Integer.parseInt(commandList[1]);
				int r2 = Integer.parseInt(commandList[2]);
				
				if (c.getReg(r1) == c.getReg(r2)) {
					//jump to nth
				}
			}
		}
		
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {

		File file = new File(filename);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String temporaryReader;
		ArrayList<String> critterAttributes = new ArrayList<String>();
		String critterName = bufferedReader.readLine();
		
		while ((temporaryReader = bufferedReader.readLine()) != null) {
			critterAttributes.add(temporaryReader);
		}
		System.out.println("Name: " + critterName);
		for (int i = 0; i < critterAttributes.size(); i ++) {
			System.out.println(critterAttributes.get(i));
		}
		
		return new CritterSpecies(critterName, critterAttributes);
	}
}
