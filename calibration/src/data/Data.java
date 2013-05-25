package data;

import java.util.*;

import common.TypeCalibration;
import filtre.Filter;

public class Data {

	private TypeCalibration calib;
	private Filter<Double> filtre;
	List<Vecteur> list = new LinkedList<Vecteur>();
	
	public Data(TypeCalibration calibration,Filter<Double> filtre) {
		this.calib = calibration;
		this.filtre = filtre;
	}

	public void store(double x_raw, double y_raw, double z_raw) {
		Vecteur vec = new Vecteur(x_raw, y_raw, z_raw);
		vec.setType(calib);
		list.add(vec);
		filtre.add(vec);
	}

	public String toString() {
		return list.toString();
	}

}
