## Cascalog for the Impatient, Part 1

The goal is to create the simplest [Cascalog](http://www.cascalog.org/) app possible, while following best practices.

Here's a brief Cascalog program which copies lines of text from file "A" to file "B". We'll keep building on this example until we have a MapReduce implementation of [TF-IDF](http://en.wikipedia.org/wiki/Tf*idf).

## Getting Started

1. Read the [part 1 introduction](http://www.cascading.org/2012/07/02/cascading-for-the-impatient-part-1/) from Cascading for the Impatient.
2. 

##Build Instructions

To build the sample app from the command line use:

    lein uberjar 

Before running this sample app, be sure to set your `HADOOP_HOME` environment variable. Then clear the `output` directory, then to run on a desktop/laptop with Apache Hadoop in standalone mode:

    rm -rf output
    hadoop jar ./target/impatient.jar data/rain.txt output/rain

To view the results:

    more output/rain/part-00000

An example of [log captured from a successful build+run](https://gist.github.com/3441186).

For more discussion, see the
[cascalog-user](https://groups.google.com/forum/?fromgroups#!forum/cascalog-user) email forum.

This tutorial is derived from [Cascading for the Impatient](http://www.cascading.org/category/impatient/) series.
