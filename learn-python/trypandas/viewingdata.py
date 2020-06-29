import numpy as np
import pandas as pd

sep = "\n *** {}: \n"
s = pd.Series([1, 3, 5, np.nan, 6, 8])
dates = pd.date_range('20130101', periods=6)
df = pd.DataFrame(np.random.randn(6, 5), index=dates, columns=list('ABCDE'))

print(sep.format('Here is how to view the top and bottom rows of the frame'))

print(df.head())
print(df.tail(3))

print(sep.format('Display the index, columns'))

print(df.index)
print(df.columns)

print(sep.format('describe() shows a quick statistic summary of your data'))
print(df.describe())

print(sep.format('Transposing your data'))
print(df.T)

print(sep.format('Sorting by an axis'))
print(df.sort_index(axis=1, ascending=False))

print(sep.format('Sorting by values'))
print(df.sort_values(by='B'))
