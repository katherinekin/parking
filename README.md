# parking

Using OOP concepts to model a parking lot.

Each parking lot belongs to a group that sets the price, discounts, and policies in the group. Cars can inquire he latest price and availability of the parking space, and can only park in one parking lot.

The CarParker class contain methods that create the groups in charge of a parking lot. Each group will have a parking lot member, fo rwhich it will set prices and capacity. Input files located in the test/ directory contains a list of vehicles that need to park. CarParker creates a list of Vehicle objects based on these input files, and iterates through the list. Each vehicle parks in a lot based first on price, and then on capacity. If there are spots open, the vehicle will try to park. It will then check the type of spots available. If no spots are available, or the available spot is not the correct type for the vehicle, it will move on to the next parking lot.