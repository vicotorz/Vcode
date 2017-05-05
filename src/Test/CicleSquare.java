package Test;
/**
 * 计算圆形面积
 * */

public class CicleSquare {
	
	private double diameter;
	private double Square;
	private double length;
	/*private point po;*/
	public double getDiameter() {
		return diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public double getSquare() {
		return Square;
	}
	public void setSquare(double square) {
		Square = square;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
/*	public point getPo() {
		return po;
	}
	public void setPo(point po) {
		this.po = po;
	}*/

   public double calculate(double diameter){
	   return 3.14*diameter*diameter;
   }
	 
   public double length(double diameter){
	  return length = 2*3.14*diameter;
	   
   }

}

