
public class Defender {
	private int endurance;
	private int speed;
	private Position position;
	
	public Defender (int e,int s,int p) {
		endurance=e;
		speed=s;
		position=findDefender(p);
	}
	
	public int getEndurance() {
		return endurance;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int s) {
		speed=s;
	}

	public Position getPosition() {
		return position;
	}

	
	public Position findDefender(int num) {
		if(num<4) {
			return Position.LEFT;
		} else if(num<7) {
			return Position.MIDDLE;
		} else {
			return Position.RIGHT;
		}
		
	}
}
