/** 
 * the data package used to store the data messages gotten from the IMU client
 */
package data;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

/**
 * Class to store the data given by IMU
 * 
 * @author Alino�
 * 
 */
public class Vector extends Vector3D implements IVector<Double> {

	private static final long serialVersionUID = 1L;

	/**
	 * State of the vector after the filter
	 */
	private boolean state = true;

	/**
	 * Give the fields the values given by the IMU
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector(double x, double y, double z) {
		super(x, y, z);
	}

	/**
	 * Give the state of the correctness of the vector
	 * 
	 * @return state
	 */
	public boolean isCorrect() {
		return state;
	}

	/**
	 * Set the state of the correctness of the vector
	 */
	public void setCorrectness(boolean correctness) {
		this.state = correctness;

	}

	/**
	 * Convert to string
	 * 
	 * @return String
	 */
	public String toString() {

		return super.toString() + "sate" + this.state
				+ System.getProperty("line.separator");
	}

	/**
	 * Convert vector to array
	 * 
	 * @return the array containing the values of the vector
	 */
	public int getSize() {
		return super.toArray().length;
	}

	/**
	 * Test of equality between two vectors
	 * 
	 * @param test
	 * @return the result of the test
	 */
	public boolean equals(IVector<Double> test) {
		return super.equals(test);
	}

	public boolean isEqual(IVector<Double> v) {
		if (v.getX() == this.getX() && v.getY() == this.getY()
				&& v.getZ() == this.getZ()) {
			return true;
		} else {
			return false;
		}
	}

}
