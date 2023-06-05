import collections
import os
from matplotlib import pyplot as plt

os.chdir('C:/Users/NasrJB/Desktop/photo')
print(os.getcwd())
taille = []
next = ""
namesDates = []
nameDate = []
monthval = []
flag = True

for i in os.listdir(os.getcwd()):
    month="00"
    
    if(os.path.isdir(i)):

        count = 0
        
        pwd = str(os.getcwd())
        next = pwd+"/"+i
        os.chdir(next)
        print(os.getcwd())
        countMonth = 0
        courentMonth = ""
        for j in (os.listdir(os.getcwd())):
            count+=1
            if(flag):
                month = j.split("_")[0][4:6]
                flag = False

            if(month == j.split("_")[0][4:6]):
                courentMonth = month
                countMonth +=1
            else:
                nameDate.append({courentMonth:count})
                month = j.split("_")[0][4:6]
                countMonth = 0
        
        os.chdir(pwd)
        flag = True

counter = collections.Counter()

for dict_item in nameDate:
    counter.update(dict_item)

result = dict(counter)
sort_dictionary= dict(sorted(result.items(), key=lambda item: item[1])) 
print(sort_dictionary)

import pandas as pd

data = {'01': 262, '12': 455, '02': 524, '03': 1344, '04': 1872, '05': 2334, '06': 2697, '07': 2908, '08': 3434, '09': 3577, '10': 4091, '11': 4424}

x = data.keys()  # extract the keys as x-axis values
y = data.values()  # extract the values as y-axis values

plt.bar(x, y)
plt.xlabel('Month')
plt.ylabel('Value')
plt.title('Visualization of data')
plt.show()