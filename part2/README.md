Cascading for the Impatient, Part 2
===================================
The goal is to expand on the simplest [Cascalog](http://www.cascalog.org/) app possible, while following best practices, to implement a Word Count example.

We'll keep building on this example until we have a MapReduce implementation of [TF-IDF](http://en.wikipedia.org/wiki/Tf*idf).

More detailed background information and step-by-step documentation is provided at the [project wiki](https://github.com/Quantisan/Impatient/wiki).

Build Instructions
==================
To build the sample app from the command line use:

    lein uberjar 

Before running this sample app, be sure to set your `HADOOP_HOME` environment variable. Then clear the `output` directory. To run on a desktop/laptop with Apache Hadoop in standalone mode:

    rm -rf output
    hadoop jar ./target/impatient.jar data/rain.txt output/rain

To view the results:

    more output/rain/part-00000

An example of [log captured from a successful build+run](https://gist.github.com/3455515).

For more discussion, see the
[cascalog-user](https://groups.google.com/forum/?fromgroups#!forum/cascalog-user) email forum.

This tutorial is derived from the [Cascading for the Impatient](http://www.cascading.org/category/impatient/) series.
