package dev.mikeburgess.adventofcode.day05

class Almanac(
    input: List<String>
) {

    val seeds: List<Long>
    val seedToSoil: List<Mapping>
    val soilToFertilizer: List<Mapping>
    val fertilizerToWater: List<Mapping>
    val waterToLight: List<Mapping>
    val lightToTemperature: List<Mapping>
    val temperatureToHumidity: List<Mapping>
    val humidityToLocation: List<Mapping>

    init {
        seeds = input[0].split(": ")[1].split(" ").map { it.toLong() }
        seedToSoil = input.subList(2, 35).map { Mapping(it) } // -2
        soilToFertilizer = input.subList(36, 77).map { Mapping(it) } // -3
        fertilizerToWater = input.subList(78, 120).map { Mapping(it) } // -4
        waterToLight = input.subList(121, 148).map { Mapping(it) } // -5
        lightToTemperature = input.subList(149, 187).map { Mapping(it) } // -6
        temperatureToHumidity = input.subList(188, 201).map { Mapping(it) } // -7
        humidityToLocation = input.subList(202, 227).map { Mapping(it) } // -8
    }

    fun closestLocation() =
        seeds.map { getSeedLocation(it) }.min()

    fun getSeedLocation(seed: Long) = seed
        .convert(seedToSoil)
        .convert(soilToFertilizer)
        .convert(fertilizerToWater)
        .convert(waterToLight)
        .convert(lightToTemperature)
        .convert(temperatureToHumidity)
        .convert(humidityToLocation)

    fun Long.convert(mapping: List<Mapping>): Long =
        mapping.firstOrNull { it.matches(this) }?.convert(this) ?: this
}
