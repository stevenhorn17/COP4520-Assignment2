# COP4520-Assignment2
Assignment 2 for Parallel Processing

# Problem 1

To solve this problem, I designated the first guest to be the leader. The algorithm is as follows:
  
  If any guest apart from the leader enters the cake room:
      
      If the cake is eaten and the guest has not asked for a cake before:
          
          The guest will request the cake to be replaced.
      
      Otherwise if the cake is already there:
          
          The guest will do nothing.
  
  If the leader enters the room:
      
      If the cake is there:
          
          The leader increments their count (starting at 0) and eats the cake. Once the count reaches the number of guests - 1, the leader can be sure that all guests have visited the room.
      
      If the cake is eaten:
          
          The leader does nothing.
          
Once the leader's count reaches number of guest - 1, the guests can declare that they have all entered the room.

# Problem 2

I believe the guests should choose to implement the 2nd strategy. Its advantages include preventing crowd buildups in front of the door and also a queue forming where all guests are waiting to get in. In this strategy, guests are free to perform other tasks when they do not want to get in the room, unlike if they were in a line waiting. If a guest has a desire to get in (in my program, simulated by rolling a random number 1-10 above 8) and the room is available, they can get in. A guest can also visit the room multiple times, so long as it is availabe. This strategy also ensures that the moment a guest has the desire to enter the room and view the vase, they can do so if possible. Guests will not lose the desire to view the vase while waiting in a long queue.

Disadvantages for the second strategy include guests only being able to get in if the timing is just right for them. If the room is occupied and a guest wants to get in, they will have to try again at another time. Additionally, there is no order for guests waiting to get into the room, so a guest entering the room happens at random.
