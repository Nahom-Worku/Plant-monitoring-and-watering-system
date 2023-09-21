# Plant-monitoring-and-watering-system

This is a project about a plant watering system built by using an Arduino grove board
and Java (Object Oriented Program (OOP) to be more specific).

The objective of this project is to water a plant whenever the soil is dry and stop
watering when the soil has been watered. To read the moisture level of the soil of the
plant, a moisture sensor was required, and it needed to be plugged into the soil while
the other end was plugged to the grove board. The pump needed to be connected to
a Mosfet that was connected to a 9V battery. The Mosfet was then connected to the
grove board. The pump was put in a plastic container full of water.

As mentioned above, the code was tested by debugging the Java files multiple times
until there were no identified errors before running the code. The plant is monitored
regularly and efficiently watered using a pump whenever the moisture sensor reads
values that indicate the soil is dry. Object Oriented Program (OOP) is widely used in
multiple engineering disciplines and this project is a simple example of that.

Since the moisture of the soil needed to be measured every time, a Timer Task
(“wateringTask” in the Java code) was required. To have full information about the
plant state, the moisture value of the soil was displayed on the command window and
OLED found on the Arduino Grove Board.
