# Permutation-Cipher
A custom permutation cipher. This cipher is immune to frequency analysis attacks.

The permutation cipher works as follows. It takes as input a plaintext from a message space and a key randomly chosen from a key space and returns a ciphertext.

    The message space is the set {<space>,a,..,z}^L. In other words the message m can be written as m[1]...m[L], where each m[i] is in {<space>,a,...,z}

    The ciphertext c can be written as c[1],...,c[L], where each c[i] is in {<space>,0,..,102}. To avoid ambiguities, cyphertext symbols are separated by a comma.

    The key space is the set of random maps from {0,..,26} to a permutation of all numbers in {0,…,102}, grouped in 26 lists, each list having length determined by column 2 of the table below.

    The encryption algorithm works as follows. A space in the plaintext is mapped to a space in the ciphertext. For each message character m[j], the algorithm finds m[j] in column 1 of the table below, and returns one of the keys in column 3 of the same row. The computation of which key is returned by the algorithm is based on a scheduling algorithm which is intentionally left unknown and is a deterministic algorithm (that is, it does not use new random bits) that may depend on j, L and the length of the list on that row.

    The decryption algorithm does the inverse process. It maps space to a space in the plaintext. On any ciphertext character different from a space, it finds the ciphertext character in column 3 of the table, and returns the column 1 plaintext letter that is on the same row.  

For instance, assume k(b,1)=23, k(c,1)=11, k(c,2)=98, k(c,3)=5, k(g,1)=34, k(g,2)=56. Then the plaintext “cbcb gbgg gcb” may be encrypted as “98,23,5,23 34,23,56,34 34,11,23”

| English Letters 	| Avg. Frequency 	| Key Values (randomly chosen distinct numbers between 0 and 102 	|
|:---------------:	|----------------	|----------------------------------------------------------------	|
|        a        	|        8       	|                        k(a,1),...,k(a,8)                       	|
|        b        	|        1       	|                             k(b,1)                             	|
|        c        	|        3       	|                        k(c,1),...,k(c,3)                       	|
|        d        	|        4       	|                        k(d,1),...,k(d,4)                       	|
|        e        	|       13       	|                       k(d,1),...,k(d,13)                       	|
|        f        	|        2       	|                               ...                              	|
|        g        	|        2       	|                                                                	|
|        h        	|        6       	|                                                                	|
|        i        	|        7       	|                                                                	|
|        j        	|        1       	|                                                                	|
|        k        	|        1       	|                                                                	|
|        l        	|        4       	|                                                                	|
|        m        	|        2       	|                                                                	|
|        n        	|        7       	|                                                                	|
|        o        	|        8       	|                                                                	|
|        p        	|        2       	|                                                                	|
|        q        	|        1       	|                                                                	|
|        r        	|        6       	|                                                                	|
|        s        	|        6       	|                                                                	|
|        t        	|        9       	|                                                                	|
|        u        	|        3       	|                                                                	|
|        v        	|        1       	|                                                                	|
|        w        	|        2       	|                                                                	|
|        x        	|        1       	|                                                                	|
|        y        	|        2       	|                                                                	|
|        z        	|        1       	|                                                                	|


## Download ZIP
* [Version 0.1](https://github.com/cnibley/permutation-cipher/archive/master.zip)

## Build
* Install Build Environoment Maven 3.3.9 or later from: [Maven](https://maven.apache.org/download.cgi)
* From the root folder run Maven: 
```$ mvn clean install```
* A JAR will be built in the root directory of the project.

## Command Line Usage
* Install Java 1.8 JDK from: [1.8 JDK](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
* To run the jar from the command line:
```$ java -jar permutation-cipher-0.0.1-SNAPSHOT.jar
...```

## Run Within IDE (optional)
* Install Maven plugins for Eclipse or other preferred IDE.
* Build the project then run the src/main/java/com/heynt/permutation/main/Main.java main class within your IDE.

## Download Source:
```$ git clone https://github.com/cnibley/permutation-software.git
...```

### Contributors on GitHub
* [Contributors](https://github.com/cnibley/permutation-cipher/graphs/contributors)

### Third party libraries
* see [LIBRARIES](https://github.com/cnibley/permutation-cipher/blob/master/LIBRARIES.md) files

## License 
* see [LICENSE](https://github.com/cnibley/permutation-cipher/blob/master/LICENSE.md) file

## Version 
* Version 0.1

## Contact
#### Charley Nibley
* Twitter: [@cnibley](https://twitter.com/cnibley "cnibley on twitter")

<!--
[![Flattr this git repo](http://api.flattr.com/button/flattr-badge-large.png)](https://flattr.com/submit/auto?user_id=username&url=https://github.com/cnibley/permutation-cipher&title=permuation-cipher&language=en&tags=github&category=software) -->
