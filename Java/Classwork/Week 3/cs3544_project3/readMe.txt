Conder Shou
cs3544
Intro to CS Java

Programming Project 3

----------------------------------------------------------------------------
Zipcode.java
----------------------------------------------------------------------------

This code is meant to be tested by the tester class, "ZipTest.java". Simply run ZipTest and give an input to test
the function of this class. For a correct input to convert a zipcode into barcode, ensure that the input value is a 5-digit number that does not begin
with 0. For a correct input to convert a barcode into zipcode, simply enter the bar symbol equivalent to the zip code.

In CUNIX, ensure that the test program and Zipcode.java are in the same directory, then, 
simply type "javac [insert test program name].java" without the quotation marks and brackets to compile the test program
that will test Zipcode.java.

Then, type "java [insert test program name]" without the quotation marks and brackets to run the java
test program. 

----------------------------------------------------------------------------

In Zipcode.java, I converted the zipcode that the user would input as a String, into "int" and assigned that
into the instance variable "zipcode". Afterwards, I created a new method "check()" that would validate the input to see
if it was the right length. This way, if the user inputted a 0 as the first digit of the ZIP code, or inputted too many
or too few digits, the system would not convert the ZIP code and leave the barcode as "null", as well as printing out
an error message. 

I created a new method "checkZip()" in order to better organize the code. Also, because ZipTest only creates a Zipcode 
class and then calls "getBarcode()", I needed to tell the program to automatically convert the inputted zipcode after 
the class itself was instantiated. I figured that the best way to do this was to have the class directly call another 
method that would check for input validation and then, in order to better organize the code, to call another method
that would convert the ZIP code into its bar form. The same was done for checking to see if the barcode was long enough,
in which case I used "checkBar()" to see if it the barcode was at the correct length either with the check digit or without it.
Later, as I matched the bars to the zip code, if none of the zipcode matched a digit from 0-9, then I ended the loop
that allowed program to convert the zipcode, set the zipcode to null, and returned null. I did this in case the bar code was
input incorrectly and didn't have the right set of symbols. For the zip code, I realized that the program would already
give an error if the input was entirely an integer, so I realized I didn't need to do anything to account for that there.

Then, I used a for loop to go through the length of the string "zipcode" and convert each digit one by one with
a substring method. Meanwhile, I made sure to also add the converted digits together so that I could get the 
check digit later on. Then, I called another method called "matchDigit" that matched each digit to its corresponding
bar symbol and had that added on to the string called "digitBar".

Similarly, I used a for loop to go through the length of the bar code, increasing my "i" counter by 5 because each 
bar symbol took up five spaces in the string array. Then, I would take a substring of five symbols each time in order 
to make sure I got one whole bar symbol to convert each time. The method "matchBars" is then a reverse of "matchDigit",
where bar symbols are matched accordingly to their digit equivalent. Like the method that converted the zipcode,
the for loop here also started at 1 in order to ignore the extra full bar in the beginning. 

While I could have instantiated many of these variables as private instance variables for the entire class, I decided
that it was unnecessary since those variables (checkDigit, sum, digitBar, digit, etc...) were only needed for their own specific method,
"convertBarcode" and "convertZipcode". In the case of "matchDigit", the only instance variable it needed outside of its own class was "bar", 
which was the input of the method anyways. As a result, I saw no reason to make the variables of "convertZipcode"
and "convertBarcode" into class instance variables. 

I also used a "while" loop to continually check if the "checkDigit" was big enough to get the sum of the zipcode to be
a multiple of 10. After the while loop was done, I had this concatenated to "digitBar" as well, the variable whose
purpose was to hold the current bar symbol representation of the ZIP code. Then, I also added the closing "|" at the
end of "digitBar" before assigning it to the class instance variable "barcode". 

I used a while loop because the process of checking whether or not the sum of the zipcode was big enough, and
incrementing "checkDigit" if it wasn't, seemed most efficient as a continual conditional loop. The for loop would have also
worked here, it would have just meant slightly more code to type. I also had "digitBar" as the variable that held the 
complete bar representation of the ZIP in order to adhere to the core principles of object-oriented programming, 
which is to make the inner workings of the program as invisible as possible. As a result, I felt it more safe,
organized, and smooth if I used an inner variable "digitBar" to hold the information of the complete bar symbol, and to then 
simply assign it to "barcode" when I was ready.

In "convertBarcode", I accommodated for the check digit by having two options of for loops, one would set the
limit of the counter "i" to the length of the string minus 10, and the other, minus 5. This way, if the length of the
bar code was 32, it meant it had a check Digit, and therefore the "minus 10" limit prevented the check digit from
being converted. However, if the bar code was length 27, then there was no check digit, and as a result, it only
needed to avoid trying to convert the extra full bar the end. This is all done while keeping in mind that the substring
will take the value of "i", and add 5 to it to get the five digits after it. 

The getBarcode() method was left as it was, as the instructor requested. 
And the getZipcode(), likewise, was simply also a return statement that returns the private instance
variable "zipcode". 
