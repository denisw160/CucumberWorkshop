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


Wildcards and quantifiers
Matching specific words is fine. But you often want flexibility to match a variety of strings. Here are some common patterns for non-exact matches.

.*	matches anything (or nothing), literally “any character (except a newline) 0 or more times”
.+	matches at least one of anything
[0-9]* or d*	matches a series of digits (or nothing)
[0-9]+ or d+	matches one or more digits
"[^"]*"	matches something (or nothing) in double quotes
an?	matches a or an (the question mark makes the n optional)

Capturing and not capturing
When you put part of a regular expression in parentheses, whatever it matches gets captured for use later. This is known as a “capture group.” In Cucumber, captured strings become step definition parameters. Typically, if you’re using a wildcard, you probably want to capture the matching value for use in your step definition. Here’s a Cuke4Nuke example,


[Given(@"^I'm logged in as an? (.*)$")]
public void ImLoggedInAsA(string role)
{
// log in as the given role
}

If your step is Given I'm logged in as an admin, then the step definition gets passed "admin" for role.

Cuke4Nuke converts captured strings to the step definition parameter type, which is handy for step definitions like this:


[Given(@"^I have (d+) cukes$")]
public void IHaveNCukes(int cukeCount)
{
// set up the given number of cukes
}

The step Given I have 42 cukes means the step definition gets called with 42 (as an integer) for cukeCount.

Sometimes, you have to use parentheses to get a regular expression to work, but you don’t want to capture the match.

For example, suppose I want to be able to match both When I log in as an admin and Given I'm logged in as an admin. After all, both step definitions do the same thing. There’s no reason to have duplicated automation code in my step definitions simply because one is a Given and one is a When.

I might write something like this:


[When(@"^(I'm logged|I log) in as an? (.*)$")]
public void LogInAs(string role)
{
// log in as the given role
}

The parentheses and pipe indicate a logical OR, just what I need to match two different strings.

This will fail to run, though. My regular expression is capturing two strings, but my step definition method only takes one. I need to designate the first group as non-capturing like this:


[When(@"^(?:I'm logged|I log) in as an? (.*)$")]
public void LogInAs(string role)
{
// log in as the given role
}

Now, with the addition of ?: at the beginning of the group, it will perform as I expect.

By the way: You may be wondering how the attribute can be When and still match Given I'm logged in as an admin. It turns out that in Cuke4Nuke, just like in Cucumber for Ruby, it doesn’t matter whether you use Given, When, or Then to define a step definition. They’re all step definitions and are interchangeable. It’s fairly common for today’s When to be tomorrow’s Given, so this is a nice feature.

