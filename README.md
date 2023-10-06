# Flight Distance Limitation Calculator

This Spring Boot application validates if a flight is feasible based on certain rules. It takes the flight plan as input, including flight number, take-off time, number of passengers, departure location (latitude, longitude), and arrival location (latitude, longitude). The application checks whether the flight complies with the rules and provides feedback to the user.

## Rules

There are currently three rules the flight must comply with:

**RULE 1**
- The maximum flight range of the airplane is 12,000 km.
- If the flight has more than 250 passengers, it can travel a maximum of 8,000 km.

**RULE 2**
- Flights taking off after 2:00 pm can only travel 9,000 km.
- There shall be no take-offs after 8:00 pm.

**RULE 3**
- Flights going West must take off before 3:00 pm.
- They should not travel further than 3,000 km.

## Distance Calculation

The distance between airports is calculated using the Haversine formula.

## Example Flights

| Flight Number | Take-off Time | Passengers | Departure Latitude | Departure Longitude | Arrival Latitude | Arrival Longitude |
|---------------|---------------|------------|--------------------|---------------------|------------------|-------------------|
| BGA164F       | 15:41         | 360        | 53.4264            | -6.2499             | 48.8566          | 2.3522            |
| OAF815X       | 10:15         | 212        | 48.8566            | 2.3522              | 41.2974          | 2.0832            |

## Example Airport Locations and Distances

| Airport   | Latitude  | Longitude   |
|-----------|-----------|-------------|
| Melbourne | -37.6732  | 144.8431    |
| Dublin    | 53.4264   | -6.2499     |
| Vancouver | 49.1966   | -123.1815   |
| Barcelona | 41.2974   | 2.0832      |
| Paris     | 48.8566   | 2.3522      |
| Los Angeles | 33.941  | -118.4085   |
| London    | 51.5073   | -0.1277     |

### Example Distances
- Paris to Los Angeles is 9,104 km.
- London to Los Angeles is 8,774 km.
- Melbourne to London is 16,885 km.
- Dublin to Barcelona is 1,485 km.

## Usage

To use this application, follow these steps:

1. Build the application using Maven
2. Run the JAR file or run the application in a IDE
3. Access the application by opening a web browser and navigating to `http://localhost:8080`.

## Notes

-  This application provides feedback on whether a flight is feasible based on the defined rules.
- The rules may change in the future, so the application is designed to be flexible and easily adaptable.
- This implementation is designed to independently check all the rules, providing comprehensive feedback even if one rule is already violated or if one rule implies another. It ensures that all relevant information is presented to the user for a complete evaluation of the flight's feasibility.
- Testing is not implemented beacuse is has not been explicitly mentioned in the email instructions, but it's worth noting that the application's design allows for easy integration of testing (unit & integration).

## Contact

If you have any questions or need assistance, please contact me at gerardalvariz@gmail.com
