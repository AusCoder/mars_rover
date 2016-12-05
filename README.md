# Mars Rovers

This is my solution to a coding exercise about mars rovers.

### Usage

It is a gradle project that reads from stdin and prints to stdout. You can run it like this (from root project root directory):

```bash
$ ./gradlew run < test_input.txt
```

Alternatively, you can build an all in one Java Archive file:
```bash
$ ./gradlew clean
$ ./gradlew fatJar
$ java -jar build/libs/mars_rover_all.jar < test_input.txt
```

### Improvements
* put Rover and Plateau in own package and make variables package-private for easier use
