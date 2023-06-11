package designpattern.abstractfactory;

public abstract class ElevatorFactory {
	abstract Motor createMotor();

	abstract Door createDoor();
}