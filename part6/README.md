# Cascading for the Impatient, Part 6
The goal is to expand on our Word Count example in Cascading, adding a custom **function** to calculate [TF-IDF](http://en.wikipedia.org/wiki/Tf*idf). This shows how to use a **sumby** and also a **cogroup**.

We'll keep building on this example to show features related to TDD and "local" mode.

More detailed background information and step-by-step documentation is provided at https://github.com/ConcurrentCore/impatient/wiki

# Run Tests

```bash
lein test
```

# Build Instructions
To build the sample app from the command line use:

    lein uberjar 

Before running this sample app, be sure to set your `HADOOP_HOME` environment variable. Then clear the `output` directory, then to run on a desktop/laptop with Apache Hadoop in standalone mode:

    rm -rf output
    hadoop jar ./build/libs/impatient.jar data/rain.txt output/wc data/en.stop output/tfidf output/trap output/check

To view the results:

    more output/tfidf/part-00000
    more output/trap/part-m-00001-00000 
    more output/check/part-00000 

An example of log captured from a successful build+run is at https://gist.github.com/3044049

For more discussion, see the [cascading-user](https://groups.google.com/forum/?fromgroups#!forum/cascading-user) email forum.

Stay tuned for the next installments of our [Cascading for the Impatient](http://www.cascading.org/category/impatient/) series.
