package parking

class ParkingLot(private val size: Int) {
    private val parkingSpots: Array<ParkingSpot> = Array(this.size) { ParkingSpot( it + 1 ) }

    fun park(car: Car) {
        if (isFull()) {
            println("Sorry, the parking lot is full.")
        } else {
            for (spot in parkingSpots) {
                if (spot.isFree) {
                    spot.car = car
                    spot.isFree = false
                    println("${car.color} car parked in spot ${spot.index}.")
                    break
                }
            }
        }
    }

    fun leave(index: Int) {
        val spot = parkingSpots[index - 1]

        if (!spot.isFree) {
            spot.car = null
            spot.isFree = true
            println("Spot ${spot.index} is free.")
        } else {
            println("There is no car in spot ${spot.index}.")
        }
    }

    fun status() {
        if (parkingSpots.all { parkingSpot -> parkingSpot.isFree }) {
            println("Parking lot is empty.")
        } else {
            for (spot in parkingSpots) {
                if (!spot.isFree) {
                    println("${spot.index} ${spot.car?.registrationNumber} ${spot.car?.color}")
                }
            }
        }
    }

    fun regByColor(color: String) {
        val filteredSpots = parkingSpots.filter { parkingSpot -> parkingSpot.car?.color?.lowercase() == color.lowercase() }
        val result = filteredSpots.stream()
            .map { it.car?.registrationNumber }
            .toList()

        if (result.isNotEmpty()) {
            println(result.joinToString(", "))
        } else {
           println("No cars with color $color were found.")
        }
    }

    fun spotByColor(color: String) {
        val filteredSpots = parkingSpots.filter { parkingSpot -> parkingSpot.car?.color?.lowercase() == color.lowercase() }
        val result = filteredSpots.stream()
            .map { it.index }
            .toList()

        if (result.isNotEmpty()) {
            println(result.joinToString(", "))
        } else {
            println("No cars with color $color were found.")
        }
    }

    fun spotByReg(reg: String) {
        val filteredSpots = parkingSpots.filter { parkingSpot -> parkingSpot.car?.registrationNumber == reg }
        val result = filteredSpots.stream()
            .map { it.index }
            .toList()

        if (result.isNotEmpty()) {
            println(result.joinToString(", "))
        } else {
            println("No cars with registration number $reg were found.")
        }
    }

    private fun isFull(): Boolean {
        return parkingSpots.all { parkingSpot -> !parkingSpot.isFree }
    }
}
