## <del>Cascading</del> *Cascalog* for the Impatient

Welcome to Cascalog for the Impatient, a series of tutorial 
and <del>Cascading 2.0</del> [Cascalog](http://www.cascalog.org/) code examples to get you started. 
Quickly. Like, yesterday.

*This is a shameless rip-off of [Cascading for the
Impatient](http://www.cascading.org/category/impatient/).*

This set of progressive coding examples starts with a simple file copy and builds up to a MapReduce implementation of the TF-IDF algorithm.

### Part 1
* Implements simplest Cascalog query possible
* Copies each line from source tap to sink tap
* Roughly, in about 10 lines of code

### Part 2
* Implements a simple example of WordCount
* Uses a regex to split the input text lines into a Tuple stream of tokens
* Uses a custom Cascalog operator

### Part 3
* Uses a custom function to scrub the token stream
* Discusses when to use standard Operations vs. creating custom ones

### Part 4
* Shows how to join sources together
* Filters a list of stop words out of the token stream
* Uses a Predicate Macro

### Part 5
* Calculates TF-IDF by breaking the problem into sub-queries
* Shows using an abstracted, re-useable sub-query as a function

## TO-DO

### Part 6
* Includes unit tests in the build
* Shows how to use other TDD features: checkpoints, assertions, traps, debug

### Part 7
* Implements switch to run the example in local mode (without Apache Hadoop)
* Uses [Incanter](https://github.com/liebke/incanter) to analyze/visualize the results

### Catch-up
* Generating DOT file
* create Gists of outputs

### Write-up
* installation and setup guide
* update each README
* a step-by-step tutorial for each part explaining Cascalog concepts and
best practices
