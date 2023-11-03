package parking

class App {
    fun run() {
        var input = readln()
        var inputArray = input.split(" ")
        var command = inputArray[0]

        when (command) {
            "exit" -> {
                return
            }
            "create" -> {
                var parkingLot = createLot(inputArray[1].toInt())

                input = readln()

                while (input != "exit") {
                    inputArray = input.split(" ")
                    command = inputArray[0]

                    when (command) {
                        "park" -> {
                            val car = Car(inputArray[1], inputArray[2])
                            parkingLot.park(car)
                        }
                        "leave" -> parkingLot.leave(inputArray[1].toInt())
                        "status" -> parkingLot.status()
                        "create" -> parkingLot = createLot(inputArray[1].toInt())
                        "reg_by_color" -> parkingLot.regByColor(inputArray[1])
                        "spot_by_color" -> parkingLot.spotByColor(inputArray[1])
                        "spot_by_reg" -> parkingLot.spotByReg(inputArray[1])
                        "exit" -> break
                    }
                    input = readln()
                }
            }
            else -> {
                println("Sorry, a parking lot has not been created.")
                run()
            }
        }
    }

    private fun createLot(size: Int): ParkingLot {
        println("Created a parking lot with $size spots.")
        return ParkingLot(size)
    }
}
