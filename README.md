# supermarket

This is a program implementing the supermarket pricing kata. It supports adding new items, some of them are based on price per item, some items are based on weight.

It also supports adding different Group Discount options like:
- X items for Y (3 Beans for 2)
- X items for Y price (2 Coke for £1)

To exeute the program run the following line:
```
java policyexpert/App.class <filename>
```
where <filename> is the name of the file with the shopping list. Each line contains the name of the item and the quantity divided by hash symbol '#'.
  
Example file: cart.txt
```
coke#1
coke#1
beans#2
beans#1
oranges#0.200 kg
```
