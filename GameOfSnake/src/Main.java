//package testSnakeGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Snake{
	Point point;
	char headDirection;
	char moveTo;
	public Snake(Point point,char headDirection, char moveTo) {
		this.point = point;
		this.headDirection = headDirection;
		this.moveTo = moveTo;
	}
	public void move() {
		switch(moveTo) {
		case 'H':
			switch(headDirection) {
			case 'U':
				point = new Point(point.x-1, point.y);
				break;
			case 'D':
				point = new Point(point.x+1, point.y);
				break;
			case 'L':
				point = new Point(point.x, point.y-1);
				break;
			case 'R':
				point = new Point(point.x, point.y+1);
				break;
			}
			break;
		case 'L':
			switch(headDirection) {
			case 'U':
				point = new Point(point.x, point.y-1);
				headDirection = 'L';
				break;
			case 'D':
				point = new Point(point.x, point.y+1);
				headDirection = 'R';
				break;
			case 'L':
				point = new Point(point.x+1, point.y);
				headDirection = 'D';
				break;
			case 'R':
				point = new Point(point.x-1, point.y);
				headDirection = 'U';
				break;
			}
			break;
		case 'D':
			switch(headDirection) {
			case 'U':
				point = new Point(point.x, point.y+1);
				headDirection = 'R';
				break;
			case 'D':
				point = new Point(point.x, point.y-1);
				headDirection = 'L';
				break;
			case 'L':
				point = new Point(point.x-1, point.y);
				headDirection = 'U';
				break;
			case 'R':
				point = new Point(point.x+1, point.y);
				headDirection = 'D';
				break;
			}
			break;
		}
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int boardSize = scan.nextInt();
		
		int numOfApple = scan.nextInt();
		ArrayList<String> apples = new ArrayList<>();
		ArrayList<Integer> timeOfCurve = new ArrayList<>();
		HashMap<Integer, Character> direction = new HashMap<>();
		
		scan.nextLine();
		String line;
		for(int i=0;i<numOfApple; i++) {
			line = scan.nextLine();
			apples.add((Integer.parseInt(line.split(" ")[0])-1)+""+(Integer.parseInt(line.split(" ")[1])-1));
		}
		int numOfCurve = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<numOfCurve; i++) {
			line = scan.nextLine();
			timeOfCurve.add(Integer.parseInt(line.split(" ")[0]));
			direction.put(Integer.parseInt(line.split(" ")[0]),line.split(" ")[1].charAt(0));
		}
		Snake snake = new Snake(new Point(0,0),'R','H');
		
		ArrayList<String> snakeBody = new ArrayList<>();
		snakeBody.add(snake.point.x+"/"+snake.point.y);
		
		int time = 1;
		while(true) {

			/*회전할지 말지*/
			if(timeOfCurve.contains(time-1)) {
				snake.moveTo = direction.get(time-1);
				timeOfCurve.remove(0);
			}
			/*이동*/
			snake.move();
			snake.moveTo = 'H';
			
			
			
			/*충돌*/
			if(snakeBody.contains(snake.point.x+"/"+snake.point.y)) {
				break;
			}
			if(snake.point.x > boardSize-1 || snake.point.y > boardSize-1 || snake.point.x < 0 || snake.point.y < 0) {
				break;
			}
			/*뱀의 길이 줄일지 말지*/
			if(apples.contains(snake.point.x+""+snake.point.y)) {
				snakeBody.add(snake.point.x+"/"+snake.point.y);
				apples.remove(snake.point.x+""+snake.point.y);
				
			}else {
				snakeBody.add(snake.point.x+"/"+snake.point.y);
				snakeBody.remove(0);
			}
			time++;
		}
		System.out.println(time);
	}

}
