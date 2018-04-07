# -*- coding: utf-8 -*-
"""
Created on Fri Feb 16 19:27:59 2018

@author: Aditi Kothari
"""
from  sklearn import preprocessing
from sklearn.cross_validation import train_test_split
from sklearn.feature_selection import SelectKBest
from sklearn.feature_selection import mutual_info_regression
import pandas as pd
import numpy as np
#import matplotlib.pyplot as plt
from sklearn.ensemble import RandomForestRegressor 




le = preprocessing.LabelEncoder()
data = pd.read_csv("script_2.csv")

#X = data.drop(['Population' , 'day' , 'time'] , 1)
X = data[['date' , 'time' , 'stop' , 'day']]
Y = data['Population']

#le= LabelEncoder()
le= preprocessing.LabelEncoder()
le.fit(["6:00" , "6:15" , "6:30" , "6:45" , "7:00" , "7:15" , "7:30" , "7:45" , "8:00" , "8:15" , "8:30" , "8:45" , "9:00" , "16:00" , "16:15" , "16:30" , "16:45" , "17:00" , "17:15" , "17:30" , "18:00" , "18:15" ,  "18:30" , "18:45" , "19:00"])
for col in X :
   if col == "time" :
       X[col] = le.transform(X[col])

le1 = preprocessing.LabelEncoder()
le1.fit(["Sunday" , "Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday"])# , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday" , "Sunday"])
for col in X :
   if col =="day":
       X[col] = le1.transform(X[col])       
       
X = SelectKBest(mutual_info_regression , k = 3).fit_transform(X , Y)
min_max_scaler = preprocessing.MinMaxScaler()

X = min_max_scaler.fit_transform(X)


X_train , X_test , Y_train , Y_test = train_test_split(X , Y , test_size = 0.1 , random_state = 2)

reg = RandomForestRegressor()
reg = reg.fit(X_train , Y_train)
#print(reg.predict(X_test))
Z = reg.predict(X_test)
#for i in range(23):
print(reg.score(X_test , Y_test))    
for i in range(25):
    print(np.round(reg.predict([X[i]])))
    
"""
for i in range(23) :
    print(Z[i])
Z = Z/10
Z = np.round(np.array(Z))
#for i in range(23) :
   # print(Z[i])
"""
    
