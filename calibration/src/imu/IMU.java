package imu;

import fr.dgac.ivy.*;
import common.TypeCalibration;

/**
 * This is the class that links the calibrating program to the IVY bus in order
 * to get the RAW_DATA messages.
 * 
 * @author Florent GERVAIS
 */

public class IMU implements IvyMessageListener {

	private Ivy bus;

	/**
	 * allows to get back the right RAW_DATA messages
	 * 
	 * @throws IvyException
	 */
	IMU(TypeCalibration calibration) throws IvyException {
		if (TypeCalibration.ACCELEROMETER.equals(calibration)) {
			// initialization, name and ready message
			bus = new Ivy("IMU", "IMU Ready", null);
			// get back of the RAW_DATA messages needed depending on the
			// calibration
			bus.bindMsg(
					"^[A-Za-z0-9]+ IMU_ACCEL_RAW ([/-]*[0-9]+) ([/-]*[0-9]+) ([/-]*[0-9]+)",
					this);
			// starts the bus on the default domain
			bus.start(null);
		}
		if (TypeCalibration.MAGNETOMETER.equals(calibration)) {
			// initialization, name and ready message
			bus = new Ivy("IMU", "IMU Ready", null);
			// get back of the RAW_DATA messages needed depending on the
			// calibration
			bus.bindMsg(
					"^[A-Za-z0-9]+ IMU_MAG_RAW ([/-]*[0-9]+) ([/-]*[0-9]+) ([/-]*[0-9]+)",
					this);
			// starts the bus on the default domain
			bus.start(null);
		}
	}

	@Override
	public void receive(IvyClient arg0, String[] args) {
		System.out.println(args[0] + " " + args[1] + " " + args[2]);
	}

	public void transferData() {
		// TODO
	}

	public static void main(String args[]) throws IvyException {
		TypeCalibration t = TypeCalibration.ACCELEROMETER;
		new IMU(t);
	}
}
