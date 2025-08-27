package Actividad3;

public class Motor {
	private int numMotor;
	private int revolucionesPorMin;
	
	public Motor(int numMotor, int revolucionesPorMin) {
		this.numMotor = numMotor;
		this.revolucionesPorMin = revolucionesPorMin;
	}
	
	public int getNumMotor() {
		return numMotor;
	}
	
	public void setNumMotor(int numMotor) {
		this.numMotor = numMotor;
	}
	
	public int getRevoluciones() {
		return revolucionesPorMin;
	}
	
	public void setRevoluciones(int revolucionesPorMin) {
		this.revolucionesPorMin = revolucionesPorMin;
	}
	
	@Override 
	public String toString(){
		return ", numMotor: "+numMotor+", revolucionesPorMin: "+revolucionesPorMin+" }";
	}
	
	public static void main(String[] args) {
		Motor m1 = new Motor(12345, 6000);
		System.out.println(m1);
	}
}
