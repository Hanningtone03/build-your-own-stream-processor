![CI](https://github.com/Hanningtone03/build-your-own-stream-processor/actions/workflows/ci.yml/badge.svg)

# Build Your Own Stream Processor

A stream processor built in Java; real-time filtering, transformation, aggregation and pipeline execution.

## How it works

Stream processors like Apache Flink and Kafka Streams read data continuously, apply a series of operations, and output results. This project implements that:

- Data flows through a typed Stream object
- Filter, map, and reduce operations chain together
- Sources load data from lists, files, ranges, or random generators
- Sinks output to console or file
- The Pipeline class tracks and logs each step of execution

## Project structure

```
src/main/java/stream/
├── Main.java
├── Stream.java
├── Pipeline.java
├── Source.java
├── Sink.java
└── operators/
    ├── Filter.java
    ├── Map.java
    └── Reduce.java
```

## Running locally

```bash
javac -d out src/main/java/stream/operators/*.java src/main/java/stream/*.java
java -cp out stream.Main
```

## Operations

Filter, map, reduce, forEach, count, toList. Sources include lists, files, integer ranges, and random number generators. Sinks output to console or file.

## Tech

- Java 21
- No external dependencies
