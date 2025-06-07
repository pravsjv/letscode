**Problem Statement:**
Given a list of Cities, and each with its corresponding population represented as a pair of (city_name,poplation). Implement a function that takes the input and return a random city where the probability of selecting a city is proportional to its population.
Example:
    - input: city_populations = {{"NYC",100},{"LA",300},{"Austin",200}}
    - output: pickRandomCity(150) should return "LA" 

**Problem Breakdown**
- Input : List of Pairs where each pair contains cityName and population of the city.
- Implementation: pickIndex() 
- Output: return a random city based on probability of population[i]/total_population
- Subproblems:
  - Process the input to seggregate cityName and population
  - Simulate Weighted Randomness
  - Generate a random population
  - Map Index to the random population 

**Approach:**
- As per problem statement, the probability of picking a random city is proportional to population.
- Similar to original problem, to simulate the weighted randomness, place the population on number line.
  - ```text
    population = [1, 3, 2], compute prefix sums
    prefixSum = [1, 4, 6]
    Index 0 → (0, 1]  → weight 1
    Index 1 → (1, 4]  → weight 3
    Index 2 → (4, 6]  → weight 2
- Go over the input and store all the cities as a list of cities and calculate total population and prefixSums.
  - output: totalPopulation;prefixSums[], List cities
- - Genarate Random Index:
- Random function to generate a random values from the total population : Math.random()*totalPopulation : double target
- Find the smallest index i such that prefixSums[i]<target.
    - Linear Search: scan prefixSums linearly to check if the target falls in that range. TC:O(N)
    - Binary Search: perform a binary Search to find prefixSums for the target. TC: O(log N)
- Return the city from list of cities at the index found.

**Complexities**
- Time Complexity:
    - constructor : O(N) to build prefix sum and total population
    - pickIndex() : O(N) if Linear Search; O(log N) for Binary Search
- Space Complexity:
    - O(N) store the prefix sum array