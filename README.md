## <del>Cascading</del> *Cascalog* for the Impatient

Welcome to Cascalog for the Impatient, a series of tutorial 
and <del>Cascading 2.0</del> [Cascalog](http://www.cascalog.org/) code examples to get you started. 
Quickly. Like, yesterday.

*This is a shameless rip-off of [Cascading for the
Impatient](http://www.cascading.org/category/impatient/).*

This set of progressive coding examples starts with a simple file copy and builds up to a MapReduce implementation of the TF-IDF algorithm.

### Part 1
* Implements simplest <del>Cascading</del> Cascalog app possible
* Copies each TSV line from source tap to sink tap
* Roughly, in about a dozen lines of code
* Physical plan: 1 Mapper

### Part 2
* Implements a simple example of WordCount
* Uses a regex to split the input text lines into a token stream
* Generates a DOT file, to show the Cascading flow graphically
* Physical plan: 1 Mapper, 1 Reducer

### Part 3
* Uses a custom Function to scrub the token stream
* Discusses when to use standard Operations vs. creating custom ones
* Physical plan: 1 Mapper, 1 Reducer

### Part 4
* Shows how to use a HashJoin on two pipes
* Filters a list of stop words out of the token stream
* Physical plan: 1 Mapper, 1 Reducer

### Part 5
* Calculates TF-IDF using an ExpressionFunction
* Shows how to use a SumBy and a CoGroup
* Physical plan: 11 Mappers, 9 Reducers

## TO-DO

### Part 6
* Includes unit tests in the build
* Shows how to use other TDD features: checkpoints, assertions, traps, debug

### Part 7
* Implements switch to run the example in local mode (without Apache Hadoop)
* Uses [Incanter](https://github.com/liebke/incanter) to analyze/visualize the results

### Catch-up
* Generating DOT file

### Write-up
* installation and setup guide
* update each README
* a step-by-step tutorial for each part explaining Cascalog concepts and
best practices
