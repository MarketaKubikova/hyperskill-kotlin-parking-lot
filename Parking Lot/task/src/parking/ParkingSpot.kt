package parking

data class ParkingSpot(val index: Int, var car: Car? = null, var isFree: Boolean = true) {
}
