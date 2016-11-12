package test;

import annotation.Autowired;

public class boss {
	private office office;
	private car car;

	public boss(){
	}
	@Autowired
	public boss(car car ,office office){
    	this.car = car;
    	this.office = office ;
	}
	public String tostring(){
		return "this boss has "+car.tostring()+"and in "+office.tostring();
	}
	/*public void setCar(car car){
		this.car = car;
	}
	public void setOffice(office office){
		this.office = office;
	}*/
	public car getCar(){
		return this.car;
	}
	public office getOffice(){
		return this.office;
	}
}
