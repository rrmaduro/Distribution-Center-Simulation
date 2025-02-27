# Distribution Center Simulation Project

## Project Objective
The objective of this project was to develop a simulation of a product distribution center using the Java programming language and Object-Oriented Programming (OOP).

In this distribution center, products were received in a specific area of the warehouse, packed, and then transported to storage locations. The transportation was carried out by Automated Guided Vehicles (AGVs). The distribution of products to sales locations followed a similar process, where stored products were retrieved from storage locations and delivered to a collection point within the warehouse.

The project involved modeling and implementing a set of classes to represent the application logic, using the console for visualization. Particular attention was given to the use of OOP principles, such as encapsulation, inheritance, abstract classes, polymorphism, interfaces, cohesion maximization (single responsibility), coupling minimization, responsibility-driven design, and other best practices. A well-thought-out design facilitated the development and maintenance process.

This document covered only the first phase of the project. After its completion, the second phase was introduced in due course.

## Distribution Center
The distribution center was a rectangular space containing all elements of the simulation. This space was divided into positions, each representing a 2x2m square area. The elements included storage locations with shelves, vehicles circulating within the warehouse, and walls that delimited the space. Additionally, specific areas were designated for product loading and unloading, as well as zones in front of storage locations for depositing and retrieving products.

### Products
For this simulation, products were characterized by a name, a unique identifier, weight, and type. The following product types were considered:
- Clothing
- Accessories
- Small and large toys
- Small and large electronic devices
- Books

Received products were typically packed before storage. The following packaging types were defined:
- **Bag** – Used for storing lightweight, small items such as accessories, toys, small electronic devices, and clothing.
- **Box** – Similar to bags but not used for clothing; it could store books.
- **Cardboard Box** – Could hold up to 10 non-large products or a single large product (e.g., a large toy or electronic device).
- **Pallet** – Used to hold multiple cardboard boxes.

Each type of packaging had a unique integer identifier, represented by an abbreviation for the packaging type followed by its code.

### Collection and Delivery Points
Each warehouse had two separate areas for receiving and dispatching products. These points were located on opposite walls of the warehouse and occupied 50% of the wall's space. For example, one side could serve as the receiving area, while the opposite side served as the dispatch area. These areas were represented by an open space replacing a section of the wall, with a width of one position.

### Storage Locations
Storage locations were shelves forming rectangular areas within the warehouse that could hold any type of packaged product. Pallets containing multiple cardboard boxes were also stored in these locations. Each storage area had a designated front space along one of its longer sides, used by vehicles for depositing and retrieving packages.

### Automated Guided Vehicles (AGVs)
AGVs were used to transport products within the warehouse. They could follow predefined paths or determine their own routes based on the pickup and destination locations. Different types of sensors assisted in navigation.

#### Types of Vehicles
Depending on the type of product being transported, different vehicles were used:
- **Unit Load Carrier (ULC)** – Transported a single pallet with no weight restrictions.
- **Automatic Guided Cart (AGC)** – Transported lightweight products, typically in bags or boxes, with a weight limit of 100 kg.
- **Tugger Vehicle** – Did not directly transport products but towed a transport cart.
- **Transport Cart** – Not an AGV; it carried boxes or bags up to a 200 kg limit and was towed by a tugger vehicle.

Each vehicle occupied a single position within the warehouse.

#### Vehicle Movement
Vehicle movement within the warehouse was restricted to horizontal and vertical directions. Each vehicle moved one position per simulation step, with the option to turn or stop.
- The **ULC** could increase its speed to a maximum of three positions per simulation step. Speed increases were limited to one position per step. The ULC could stop immediately without deceleration.
- The **ULC** followed a predefined path, while other AGVs could determine their own routes between two positions automatically.

#### Types of Sensors
All AGVs used three types of sensors with different capabilities:
- **Lidar (Light Detection and Ranging)** – Detected occupied or empty warehouse positions up to 20 meters ahead, with a 30º field of view.
- **Ultrasonic Sensor** – Similar to Lidar but had a 180º field of view and an 8-meter range.
- **Camera** – Identified warehouse elements up to 30 meters away, with a 90º field of view. It could not measure distances or see beyond the first occupied position in its field of view. It was typically used alongside Lidar or ultrasonic sensors to identify objects such as vehicles, storage locations, or walls.

## Simulation
For this simulation, a warehouse was defined with vehicles and storage locations added to it. During the simulation, products were received, packaged, and stored. Packaging selection and vehicle allocation were required to transport products to storage locations. Similarly, stored products could be requested for retrieval and delivered to designated points within the warehouse.

Simulation data was provided through CSV files, which were read by the simulator during both setup and execution. These files contained information such as:
- Warehouse dimensions
- Storage locations with positions and dimensions
- List of available vehicles
- List of incoming products for storage and the simulation step at which they arrived
- List of products requested for retrieval and the time of request

During the simulation, log messages were displayed in the console to record events and actions.
