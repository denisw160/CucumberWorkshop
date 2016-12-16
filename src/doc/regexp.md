Cucumber Regular Expressions Cheat Sheet
Pattern
Notes
Match Examples
.
one of anything (except a newline)
a B 3
.*
any character (except a newline) 0 or more times
a
AbCD
words with punctuation! 123-456
an empty string
.+
at least one of anything (except a newline)
all of the above except the empty string
.{2}
exactly two of any character
aa Ab !n 23
.{1,3}
one to three of any character
aa Ab !n2 9
^pattern
anchors match to beginning of string
/^foo/ matches foo and foo bar but not bar foo
pattern$
anchors match to end of string
/foo$/ matches foo and bar foo but not foo bar
[0-9]* or \d*
matches a series of digits (or nothing)
123456
9
an empty string
[0-9]+ or \d+
matches one or more digits
all of the above except the empty string
"[^\"]*"
matches something (or nothing) in double quotes; literally, “any character except a double quote zero or more times inside double quotes”
"foo"
"foo bar"
"12345"
?
makes the previous character or group optional
/an?/ matches a and an but not n
|
like a logical OR; can be used with parentheses to include an OR in a larger pattern
/I’m|I am/ matches I’m and I am
/I (eat|ate)/ matches I eat and I ate
(pattern)
a group; typically used in Cucumber to capture a substring for a step definition argument
/(\d+) users/ matches 3 users and captures the 3 for use later
(?:pattern)
a non-capturing group
/I (?:eat|ate)/ matches I eat and I ate but does not capture eat or ate for use later
See http://www.richardlawrence.info/2010/07/20/just-enough-regular-expressions-for-cucumber/ for more examples and explanations