import numpy as np
import pandas as pd

sep = "\n *** {}: \n"
s = pd.Series([1, 3, 5, np.nan, 6, 8])
print(s)

print("\n *** Creating a DataFrame by passing a NumPy array, with a datetime index and labeled columns: \n")

dates = pd.date_range('20130101', periods=6)
print(dates)

df = pd.DataFrame(np.random.randn(6, 5), index=dates, columns=list('ABCDE'))
print(df)

print(sep.format('Creating a DataFrame by passing a dict of objects that can be converted to series-like'))

df2 = pd.DataFrame({'A': 1,
                    'B': pd.Timestamp('20200519'),
                    'C': pd.Series(list(range(1, 5)), index=list(range(4)), dtype='float32'),
                    'E': np.array([3] * 4, dtype='int32'),
                    'F': 'foo',
                    'G': [1, 2, 3, 4]})
print(df2)

print(sep.format('The columns of the resulting DataFrame have different dtypes'))

print(df2.dtypes)