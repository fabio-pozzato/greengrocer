# greengrocer

This simple application reads a list of fruits from a text file (sample under resources/shopping_items.txt). 
It then processes the data as per the requirements and prints to the console a formatted receipt, see example below:

<pre>
  : -------------------------------
  :            Receipt
  : -------------------------------
  : 11x Orange @ 0.3        3.3 CHF
  : 
  : 11x Banana @ 0.15      1.65 CHF
  : 
  : 14x Papaya @ 0.5        7.0 CHF
  :                        -2.0 CHF
  :                    ------------
  :                         5.0 CHF
  : 
  : 7x Apple @ 0.25        1.75 CHF
  : 
  : -------------------------------
  : Total cost:            11.7 CHF
</pre>
