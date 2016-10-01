# Product delivery problem

Deliver all this products to the clients is a very tough problem to solve.
Have you ever thought how much the suppliers have to pay?
The purpose of this problem is to help the suppliers find better and cheaper routes to delivery their products.
The suppliers need to know how much their current routes cost, how many different routes they can take with their budget and how they can improve their current routes.

## Input

The input will be a directed graph, each node of the graph represents a customer that made an order for a product, and each edge represents a route between two customers with a certain cost.

## Output

There are 12 different outputs, for the input 1 through 6, if there route doesn't exist on the graph, output 'NO SUCH ROUTE'.

1. The cost of the route A-D-E.
2. The cost of the route A-F-E.
3. The cost of the route E-C-B.
4. The cost of the route B-D-F-E.
5. The cost of the route F-C.
6. How many routes are arriving the client `C`
7. How many routes start at the client `B` and end at the client `A` with a maximum of 5 stops. 
In the sample data, there are 6 routes:

     - B -> A (1 stop)
     - B -> D -> F -> A (3 stops)
     - B -> A -> C -> B -> A (4 stops)
     - B -> A -> D -> F -> A (4 stops)
     - B -> D -> E -> C -> B -> A (5 stops)
     - B -> D -> F -> C -> B -> A (5 stops)

8. How many routes start at the client `A` and end at the client `A` with exactly 3 stops.
In the sample data, there are 2 routes:

     - A -> D -> F -> A 
     - A -> C -> B -> A

9. The cost of the shortest route between the clients `A` and `E`.
10. The cost of the shortest route between the clients `C` and `E`.
11. The number of different routes between the clients `A` and `B` that costs less than 40.
12. The number of different routes between the clients `E` and `D` that costs less than 60.

## Test Input:

On this test input, we are going to use letters to represent customers, and we will have 6 customers, so using the letters `A` to `F`.

All the routes are one-way as they are presented, so `AB` represents a route between the client `A` and `B`, going from `A` to `B`.

The routes may have different sizes, so the number on the input represents the cost to travel between these two clients, e.g. `CF7` represents a route going from the client `C` to the cliend `F` that costs 7.

Graph: 

```
AD4, DE1, EC8, CB2, BA6, AC9, DF7, FC5, FE9, BD3, FA3
```

## Expected Output:

```
Output #1: 5
Output #2: NO SUCH ROUTE
Output #3: 10
Output #4: 19
Output #5: 5 
Output #6: 3
Output #7: 6
Output #8: 2
Output #9: 5
Output #10: 6 
Output #11: 27
Output #12: 137
```
