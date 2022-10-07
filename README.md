# ThreadingTrains


Problem

I'm learning about using threads and using the Reentrant lock in Java by trying to simulate a railway network. The program 
constructs a RailRoute from Track and station objects. Train objects (threads) are then created which move along the route. 
They can only continue if the next track or station has space to accommodate them. Track objects can hold only one train 
and each station has a specified capacity. There are two main problems:

    - Trains skip Track segments located between each station
    - When the first station reaches capacity, no additional trains enter the track. They never start their journey and are lost.

Train objects are responsible for traversing the rail route. I think this is where I'm going wrong... can anyone help please? 
