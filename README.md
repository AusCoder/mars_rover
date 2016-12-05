# Mars Rovers

This is my solution to a coding exercise about mars rovers.

### Usage

It is a gradle project that reads from stdin and prints to stdout. On a UNIX system, you can run it like this (from root project root directory):

```bash
$ ./gradlew run < test_input.txt
```

Alternatively, you can build an all in one Java Archive file:
```bash
$ ./gradlew clean
$ ./gradlew fatJar
$ java -jar build/libs/mars_rover_all.jar < test_input.txt
```

If you use Windows then you can use the `gradlew.bat` or use another [operating system.](https://wiki.archlinux.org/index.php/installation_guide)

### Improvements
* put Rover and Plateau in own package and make variables package-private for easier use
