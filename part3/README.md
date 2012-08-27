Cascalog for the Impatient, Part 3
===================================
The goal is to expand on our Word Count example in Cascalog, and show how to write a custom Operation.

We'll keep building on this example until we have a MapReduce implementation of [TF-IDF](http://en.wikipedia.org/wiki/Tf*idf).

More detailed background information and step-by-step documentation is provided at the [project wiki](https://github.com/Quantisan/Impatient/wiki).

Build Instructions
==================
To build the sample app from the command line use:

    lein uberjar 

Before running this sample app, be sure to set your `HADOOP_HOME` environment variable. Then clear the `output` directory. To run on a desktop/laptop with Apache Hadoop in standalone mode:

    rm -rf output
    hadoop jar ./target/impatient.jar data/rain.txt output/wc

To view the results:

    more output/wc/part-00000

An example of log captured from a successful build+run is at <del>https://gist.github.com/3021655</del>

For more discussion, see the [cascalog-user](https://groups.google.com/forum/?fromgroups#!forum/cascalog-user) email forum.

This tutorial is derived from the [Cascading for the Impatient](http://www.cascading.org/category/impatient/) series.
