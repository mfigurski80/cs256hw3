### Mikolaj Figurski
## HW3 Explanation - Recurrence in word split and identification.

My solution iterates through each character in the given string. Once it finds/forms a valid word, it assumes that this word is part of the solution, and *iterates* on the remaining string. If the remaining part of the string is found to form no valid words (in my implementation, if it returns 'No Split'), then program continues iterating through the characters until another valid word is formed or the end of the string is reached. If the letters do run out, that means there is no valid split at all.

Once a valid set of splits is found, the solution propagates through the stack calls. Each called 'instance' of the function adds on the valid word it found and a space, beginning with the last function which should return ''; This moves the solution upwards and builds it recursively, until the stack calls are exhausted and we can return it to the user.

#### Additional note:
I would like to use 1 day of extension for this homework.

Extra information
