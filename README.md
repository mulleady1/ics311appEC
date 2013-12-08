Battle of the Sorts
===================

Compilation
-----------
The easiest way to compile and run is to use the 'run' script:

    ./run <input_file_1> [<input_file_2> ... <input_file_n>]

where the input files are the 'names\_\*' files located in this directory.

If for some reason the run script doesn't work for you, use the typical commands:

    cd src/
    javac -d ../bin/ ics311km/*.java
    cd ../bin/
    java ics311km/Driver <input_file>

The run script uses the argument -Xss8m to allocate a stack large enough to handle
the recursion used in these sort algorithms.

I ran this on UH Uhix, so there shouldn't be any issues.

Credits
-------
Just me.


Revision History
----------------
None.


Bug Report
----------
No known bugs.


Available Documentation
-----------------------
Testing:    testing.txt
