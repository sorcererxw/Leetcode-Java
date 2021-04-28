package main

type ParkingSystem struct {
	slot [3]int
}

// Constructor Initializes object of the ParkingSystem class.
// The number of slots for each parking space are given as part of the constructor.
func Constructor(big int, medium int, small int) ParkingSystem {
	return ParkingSystem{slot: [3]int{big, medium, small}}
}

// AddCar Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
// carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
// A car can only park in a parking space of its carType.
// If there is no space available, return false, else park the car in that size space and return true.
func (p *ParkingSystem) AddCar(carType int) bool {
	if p.slot[carType-1] > 0 {
		p.slot[carType-1] -= 1
		return true
	}
	return false
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * obj := Constructor(big, medium, small);
 * param_1 := obj.AddCar(carType);
 */
