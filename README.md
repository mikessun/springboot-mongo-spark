# Springboot-MongoDB-Spark Demo
This is a simple demo to use spark with MongoDB in springboot. It is only tested in Windows OS

## Prerequisites

To build the MongoDB-Spark demo application, you'll need to have the following:

* [Maven](http://maven.apache.org)
* [Spark](http://spark.apache.org) (1.0 or greater, for Hadoop 2.x)
* In Windows OS, you have to set up below environment variable:
```
      hadoop.home.dir
```
  This needs point to the below file directory:
```
      winutils.exe

  e.g.: d:\springboot-mongodb-spark-demo-resmed\bin
```


### Spark

Refer to the [Spark overview](http://spark.apache.org/docs/latest/index.html) to get started.

## Building


    $ mvn install


## Running

    $ java -jar target/spring.mongo.spark-0.0.1-SNAPSHOT.jar

        
## Notes

The field names in sample summary data jsons are updated via replacing "." with "_". This can also be handled via following discussion:
https://stackoverflow.com/questions/44367019/column-name-with-dot-spark

In summary, following approaches could be taken (in scala):

* to provide schema explicitly
```
val schema = StructType((0 until 4).map(i => StructField(s"_$i", DoubleType)))

  val dfExplicit = spark.read.format("csv")
    .options(Map("header" -> "true"))
    .schema(schema)
    .load(path)
```
* use `(backticks) to enclose the column name.
```
  df.select("`col0.1`")
```
* renaming json attribute names to database convention