Cascalog for the Impatient, Part 5
===================================
The goal is to expand on our Word Count example in Cascalog, using an **custom function** to calculate [TF-IDF](http://en.wikipedia.org/wiki/Tf*idf). This shows how to use a subquery to aggregate the data needed.

We'll keep building on this example to show features related to TDD and "local" mode.

More detailed background information and step-by-step documentation is provided at the [project wiki](https://github.com/Quantisan/Impatient/wiki).

Build Instructions
==================
To build the sample app from the command line use:

    lein uberjar 

Before running this sample app, be sure to clear the `output` directory. To run on a desktop/laptop with Apache Hadoop in standalone mode:

    rm -rf output
    hadoop jar ./target/impatient.jar data/rain.txt output/wc data/en.stop output/tfidf

To view the results:

    more output/tfidf/part-00000

An example of log captured from a successful build+run is at [this
gist](https://gist.github.com/3845007)

For more discussion, see the [cascalog-user](https://groups.google.com/forum/?fromgroups#!forum/cascalog-user) email forum.

This tutorial is derived from the [Cascading for the Impatient](http://www.cascading.org/category/impatient/) series.
